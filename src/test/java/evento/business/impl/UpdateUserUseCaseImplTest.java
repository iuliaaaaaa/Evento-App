//package evento.business.impl;
//
//import evento.domain.User;
//import evento.domain.userActions.CreateUserResponse;
//import evento.domain.userActions.UpdateUserRequest;
//import evento.domain.userActions.UpdateUserResponse;
//import evento.repository.UserRepository;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@ExtendWith({SpringExtension.class, MockitoExtension.class})
//@SpringBootTest
//class UpdateUserUseCaseImplTest {
//
//    @Mock
//    private UserRepository userRepository;
//    @InjectMocks
//    private UpdateUserUseCaseImpl updateUserUseCase;
//    @Test
//    void updateUser() {
//        User user = User.builder()
//                .id(10L)
//                .name("Frida")
//                .surname("Kahlo")
//                .userType("CLIENT")
//                .email("frida@gmail.com")
//                .password("a123r13rdefre")
//                .build();
//
//        UpdateUserResponse response = UpdateUserResponse.builder()
//                .id(10L)
//                .build();
//
//        UpdateUserRequest request = UpdateUserRequest.builder()
//                .email("updated")
//                .build();
//
//        UpdateUserResponse actual = updateUserUseCase.updateUser(request);
//
//        assertEquals(actual, response);
//    }
//}