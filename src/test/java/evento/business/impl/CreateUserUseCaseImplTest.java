//package evento.business.impl;
//
//import evento.domain.User;
//import evento.domain.userActions.CreateUserRequest;
//import evento.domain.userActions.CreateUserResponse;
//import evento.persistance.entity.UserEntity;
//import evento.repository.UserRepository;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.util.Assert;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//@ExtendWith({SpringExtension.class, MockitoExtension.class})
//@SpringBootTest
//class CreateUserUseCaseImplTest {
//
//    @Mock
//    private  UserRepository userRepository;
//
//    @Mock
//    private  PasswordEncoder passwordEncoder;
//
//
//    @InjectMocks
//    private CreateUserUseCaseImpl createUserUseCase;
//
//    @Test
//    void createUser() {
//
//        User user = User.builder()
//                .id(10L)
//                .name("Irina")
//                .surname("Rimes")
//                .userType("CLIENT")
//                .email("irina@gmail.com")
//                .password("a123r13rdefre")
//                .build();
//
//        CreateUserRequest request = CreateUserRequest.builder()
//                .id(10L)
//                .name("Irina")
//                .surname("Rimes")
//                .role("CLIENT")
//                .email("irina@gmail.com")
//                .password("skupi11")
//                .build();
//
//        CreateUserResponse response = CreateUserResponse.builder()
//                .id(10L)
//                .build();
//
//        when(userRepository.create(user)).thenReturn(user);
//        when(passwordEncoder.encode("skupi11")).thenReturn("a123r13rdefre");
//
//        CreateUserResponse actual = createUserUseCase.createUser(request);
//        assertEquals(actual, response);
//        verify(userRepository).create(user);
//
//    }
//}