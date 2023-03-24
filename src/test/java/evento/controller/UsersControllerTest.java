//package evento.controller;
//
//import evento.business.RESTforUsers.*;
//import evento.controller.DTOs.UserDTO;
//import evento.controller.DTOs.users.GetAllUsersResponseDTO;
//import evento.domain.User;
//import evento.domain.userActions.*;
//import evento.persistance.entity.UserEntity;
//import evento.repository.JPA.UserRepositoryJPA;
//import evento.repository.UserRepository;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.security.test.context.support.WithMockUser;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;
//
//
//@ExtendWith(SpringExtension.class)
//@SpringBootTest
//@AutoConfigureMockMvc
//class UserControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private GetUsersUseCase getUsersUseCase;
//    @MockBean
//    private GetUserUseCase getUserUseCase;
//    @MockBean
//    private DeleteUserUseCase deleteUserUseCase;
//    @MockBean
//    private CreateUserUseCase createUserUseCase;
//    @MockBean
//    private UpdateUserUseCase updateUserUseCase;
//
//
//    @Test
//    @WithMockUser(username = "10@fontys.nl", roles = {"CLIENT"})
//    void getUser_shouldReturn200_whenUserFound() throws Exception {
//        User user = User.builder()
//                .name("Dante")
//                .surname("Aligheri")
//                .id(10L)
//                .userType("CLIENT")
//                .email("dante.a@gmail.com")
//                .password("divineComedy")
//                .build();
//        when(getUserUseCase.getUser(10L)).thenReturn(Optional.of(user));
//
//        mockMvc.perform(get("/users/id/10"))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(header().string("Content-Type", APPLICATION_JSON_VALUE))
//                .andExpect(content().json("""
//                            {"id":10,"surname":"Aligheri","name":"Dante"}
//                        """));
//
//        verify(getUserUseCase).getUser(10L);
//    }
//
////    @Test
////    @WithMockUser(username = "10@fontys.nl", roles = {"CLIENT"})
////    void getUser_shouldReturn404Error_whenUserNotFound() throws Exception {
////        when(getUserUseCase.getUser(10L)).thenReturn(Optional.empty());
////
////        mockMvc.perform(get("/users/id/10"))
////                .andDo(print())
////                .andExpect(status().isNotFound());
////
////        verify(getUserUseCase).getUser(10L);
////    }
//
//    @Test
//    @WithMockUser(username = "admin@fontys.nl", roles = {"ADMIN"})
//    void getAllUsers_shouldReturn200WithUsersList_WhenNoFilterProvided() throws Exception {
//        GetAllUsersResponse response = GetAllUsersResponse.builder()
//                .users(List.of(
//                        User.builder()
//                                .id(1L)
//                                .name("Etta")
//                                .surname("James")
//                                .email("etta@gmail.com")
//                                .userType("CLIENT")
//                                .password("sundayKindOfLove")
//                                .build(),
//                        User.builder()
//                                .id(2L)
//                                .name("Mike")
//                                .surname("Davis")
//                                .email("mike@gmail.com")
//                                .userType("ORGANIZER")
//                                .password("bluesRules")
//                                .build()
//                ))
//                .build();
//        GetAllUsersRequest request = GetAllUsersRequest.builder().build();
//        when(getUsersUseCase.getUsers(request)).thenReturn(response);
//
//        mockMvc.perform(get("/users"))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(header().string("Content-Type", APPLICATION_JSON_VALUE))
//                .andExpect(content().json("""
//                            {
//                                "users":[
//                                    {"id":1,"name":"Etta","surname":"James", "email": "etta@gmail.com", "role":"CLIENT", "password": "sundayKindOfLove"},
//                                    {"id":2,"name":"Mike","surname":"Davis", "email": "mike@gmail.com", "role":"ORGANIZER", "password": "bluesRules"}
//                                ]
//                            }
//                        """));
//
//        verify(getUsersUseCase).getUsers(request);
//    }
//
//    @Test
//    @WithMockUser(username = "admin@fontys.nl", roles = {"ADMIN"})
//    void getAllUsers_shouldReturn200WithUsersList_WhenRoleFilterProvided() throws Exception {
//
//        GetAllUsersResponse responseDTO = GetAllUsersResponse.builder()
//                .users(List.of(
//                        User.builder()
//                                .id(1L)
//                                .name("Bon")
//                                .surname("Jovi")
//                                .email("bon@gmail.com")
//                                .userType("CLIENT")
//                                .password("music123")
//                                .build(),
//                        User.builder()
//                                .id(2L)
//                                .name("Elvis")
//                                .surname("Presley")
//                                .email("elvis@gmail.com")
//                                .userType("CLIENT")
//                                .password("bluesRules")
//                                .build()
//                ))
//                .build();
//        GetAllUsersRequest request = GetAllUsersRequest.builder()
//                .role("CLIENT")
//                .build();
//        when(getUsersUseCase.getUsers(request)).thenReturn(responseDTO);
//
//        mockMvc.perform(get("/users/role/CLIENT"))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(header().string("Content-Type", APPLICATION_JSON_VALUE))
//                .andExpect(content().json("""
//                            {
//                                "users":[
//                                    {"id":1,"name":"Bon","surname":"Jovi", "email": "bon@gmail.com", "role":"CLIENT", "password": "music123"},
//                                    {"id":2,"name":"Elvis","surname":"Presley", "email": "elvis@gmail.com", "role":"CLIENT", "password": "bluesRules"}
//                                ]
//                            }
//                        """));
//
//        verify(getUsersUseCase).getUsers(request);
//    }
//
//
//    @Test
//    @WithMockUser(username = "admin@fontys.nl", roles = {"ADMIN"})
//    void deleteUser_shouldReturn204() throws Exception {
//        mockMvc.perform(delete("/users/100"))
//                .andDo(print())
//                .andExpect(status().isNoContent());
//
//        verify(deleteUserUseCase).deleteUser(100L);
//    }
//
//
//    @Test
//    void createUser_shouldReturn201_whenRequestIsValid() throws Exception {
//         CreateUserRequest expectedRequest = CreateUserRequest.builder()
//                 .name("Elvis")
//                 .surname("Presley")
//                 .email("elvis@gmail.com")
//                 .role("CLIENT")
//                 .password("music80")
//                .build();
//        when(createUserUseCase.createUser(expectedRequest))
//                .thenReturn(CreateUserResponse.builder()
//                        .id(200L)
//                        .build());
//
//        mockMvc.perform(post("/users")
//                        .contentType(APPLICATION_JSON_VALUE)
//                        .content("""
//                                {
//                                    "name": "Elvis",
//                                    "surname": "Presley",
//                                    "password": "music80",
//                                    "role": "CLIENT",
//                                    "email": "elvis@gmail.com"
//                                }
//                                """))
//                .andDo(print())
//                .andExpect(status().isCreated())
//                .andExpect(content().json("""
//                            { "id":  200 }
//                        """));
//
//        verify(createUserUseCase).createUser(expectedRequest);
//    }
//
//    @Test
//    @WithMockUser(username = "10@fontys.nl", roles = {"CLIENT"})
//    void updateUser_shouldReturn204() throws Exception {
//        mockMvc.perform(put("/users/100")
//                        .contentType(APPLICATION_JSON_VALUE)
//                        .content("""
//                                {
//                                    "id":100,
//                                    "name":"James",
//                                    "email": "james@gmail.com",
//                                    "password": "james123"
//
//                                }
//                                """))
//                .andDo(print())
//                .andExpect(status().isNoContent());
//
//        UpdateUserRequest expectedRequest = UpdateUserRequest.builder()
//                .id(100L)
//                .name("James")
//                .email("james@gmail.com")
//                .password("james123")
//                .build();
//        verify(updateUserUseCase).updateUser(expectedRequest);
//    }
//    /////BEfore
//
//    @Autowired
//    UserRepositoryJPA userRepository;
////    @Test
////    void addUser() {
////        UserEntity user = new UserEntity("name","test", "testD", "test", "test");
////        assertAll("user",
////                () -> assertEquals("testD", user.getPassword()),
////                () -> assertEquals("test", user.getSurname())
////        );
////    }
//
//    @Test
//     void saveUserTest(){
//
//        UserEntity user = UserEntity.builder()
//                .name("Zoe")
//                .email("zoeWhite@gamil.com")
//                .password("zoe1999")
//                .surname("White")
//                .role("CLIENT")
//                .build();
//
//        userRepository.save(user);
//
//        assertTrue(user.getId() > 0);
//    }
//
//    @Test
//    void getUserTest(){
//
//        UserEntity user = userRepository.findById(1L).get();
//
//        assertEquals(1L, (long) user.getId());
//
//    }
//
//    @Test
//    void getListOfUsersTest(){
//
//        List<UserEntity> userList = userRepository.findAll();
//
//        assertTrue(userList.size()> 0);
//
//    }
//
//    @Test
//    void updateUserTest(){
//
//        UserEntity user = userRepository.findById(1L).get();
//
//        user.setEmail("ram@gmail.com");
//
//        UserEntity userUpdated =  userRepository.save(user);
//
//       assertEquals("ram@gmail.com", userUpdated.getEmail());
//
//    }
//
//}
