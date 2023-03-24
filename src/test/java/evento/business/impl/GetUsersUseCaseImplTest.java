//package evento.business.impl;
//
//import evento.controller.DTOs.users.GetAllUsersResponseDTO;
//import evento.controller.converters.UserDTOConverter;
//import evento.domain.User;
//import evento.domain.userActions.GetAllUsersRequest;
//import evento.domain.userActions.GetAllUsersResponse;
//import evento.persistance.converters.UserConverter;
//import evento.persistance.entity.UserEntity;
//import evento.repository.UserRepository;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//@ExtendWith({SpringExtension.class, MockitoExtension.class})
//@SpringBootTest
//class GetUsersUseCaseImplTest {
//
//    @Mock
//    private UserRepository userRepository;
//
//    @InjectMocks
//    private GetUsersUseCaseImpl getAllUsersUseUserUseCase;
//
//    @Test
//    void getUsers() {
//
//        List<User> users = new ArrayList<>();
//
//        User user = User.builder()
//                .id(10L)
//                .name("Harry")
//                .surname("Potter")
//                .userType("CLIENT")
//                .email("harry@gmail.com")
//                .password("hogwarts")
//                .build();
//
//        users.add(user);
//        userRepository.create(user);
//
//        User user2 = User.builder()
//                .id(11L)
//                .name("Hermione")
//                .surname("Gringer")
//                .userType("ORGANIZER")
//                .email("hermione@gmail.com")
//                .password("weLoveBooks")
//                .build();
//
//        users.add(user2);
//        userRepository.create(user2);
//
//        User user3 = User.builder()
//                .id(12L)
//                .name("Snape")
//                .surname("Slytherin")
//                .userType("ADMIN")
//                .email("snape@gmail.com")
//                .password("weLoveBooks")
//                .build();
//
//        users.add(user3);
//        userRepository.create(user3);
//
//        GetAllUsersRequest request = GetAllUsersRequest.builder().build();
//
//        GetAllUsersResponse response = GetAllUsersResponse.builder().users(users).build();
//
//
//        when(userRepository.findAll()).thenReturn(users);
//
//        GetAllUsersResponse actual = getAllUsersUseUserUseCase.getUsers(request);
//
//        assertEquals(response, actual);
//        verify(userRepository).findAll();
//
//
//    }
//}