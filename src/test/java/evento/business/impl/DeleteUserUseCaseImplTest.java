//package evento.business.impl;
//
//import evento.persistance.entity.UserEntity;
//import evento.repository.JPA.UserRepositoryJPA;
//import evento.repository.UserRepository;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.when;
//
//
//@ExtendWith({SpringExtension.class, MockitoExtension.class})
//@SpringBootTest
//class DeleteUserUseCaseImplTest {
//
//    @Mock
//    private UserRepositoryJPA userRepository;
//
//    @Test
//    void deleteUser() {
//        UserEntity user = UserEntity.builder()
//                .id(10L)
//                .name("Luca")
//                .surname("Boliva")
//                .role("CLIENT")
//                .email("luca@gmail.com")
//                .password("a123r13rdefre")
//                .build();
//
//        userRepository.save(user);
//        userRepository.deleteByEmail("luca@gmail.com");
//        Boolean response = userRepository.existsById(user.getId());
//
//        assertEquals(false, response);
//    }
//}