//package evento.business.impl;
//
//import evento.domain.User;
//import evento.persistance.entity.UserEntity;
//import evento.repository.UserRepository;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//@ExtendWith({SpringExtension.class, MockitoExtension.class})
//@SpringBootTest
//class GetUserUseCaseImplTest {
//
//    @Mock
//    private UserRepository userRepository;
//
//    @Test
//    void getUser() {
//        User user = User.builder()
//                .id(10L)
//                .name("Harry")
//                .surname("Potter")
//                .userType("CLIENT")
//                .email("harry@gmail.com")
//                .password("hogwarts")
//                .build();
//        userRepository.create(user);
//
//
//        User user2 = User.builder()
//                .id(11L)
//                .name("Hermione")
//                .surname("Gringer")
//                .userType("ORGANIZER")
//                .email("hermione@gmail.com")
//                .password("weLoveBooks")
//                .build();
//        userRepository.create(user2);
//
//        when(userRepository.findById(10L)).thenReturn(Optional.ofNullable(user));
//
//        Optional<User> expected = Optional.ofNullable(user);
//        Optional<User> actual = userRepository.findById(10L);
//
//        assertEquals(expected, actual);
//        verify(userRepository).findById(10L);
//    }
//}