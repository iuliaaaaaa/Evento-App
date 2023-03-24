//package evento.business.implEvents;
//
//import evento.domain.Event;
//import evento.domain.User;
//import evento.persistance.entity.EventEntity;
//import evento.persistance.entity.UserEntity;
//import evento.repository.EventRepository;
//import evento.repository.JPA.EventRepositoryJPA;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@ExtendWith({SpringExtension.class, MockitoExtension.class})
//@SpringBootTest
//class DeleteEventUseCaseImplTest {
//
//    @Mock
//    private EventRepository eventRepository;
//
//    @Test
//    void deleteEvent() {
//        User user = User.builder()
//                .id(10L)
//                .name("Luca")
//                .surname("Boliva")
//                .userType("CLIENT")
//                .email("luca@gmail.com")
//                .password("a123r13rdefre")
//                .build();
//
//        Event event = Event.builder()
//                .id(11L)
//                .name("Vivaldi concert")
//                .date("20/02/2023")
//                .description("classical music")
//                .location("ROME")
//                .user(user)
//                .build();
//
//        eventRepository.createEvent(event);
//
//        eventRepository.deleteById(event.getId());
//
//        Boolean response = eventRepository.existsById(event.getId());
//
//        assertEquals(false, response);
//
//    }
//}