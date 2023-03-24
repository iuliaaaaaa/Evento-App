//package evento.business.implEvents;
//
//import evento.business.RESTforEvents.CreateEventUseCase;
//import evento.business.RESTforUsers.GetUserUseCase;
//import evento.domain.Event;
//import evento.domain.User;
//import evento.domain.eventActions.CreateEventRequest;
//import evento.domain.eventActions.CreateEventResponse;
//import evento.persistance.entity.EventEntity;
//import evento.persistance.entity.UserEntity;
//import evento.repository.EventRepository;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//@ExtendWith({SpringExtension.class, MockitoExtension.class})
//@SpringBootTest
//class CreateEventUseCaseImplTest {
//
//    @Mock
//    private EventRepository eventRepository;
//
//    @Mock
//    private GetUserUseCase getUserUseCase;
//    @InjectMocks
//    private CreateEventUseCaseImpl createEventUseCase;
//    @Test
//    void createEvent() {
//
//        User user = User.builder()
//                .id(15L)
//                .name("Leo")
//                .surname("Franklin")
//                .userType("ORGANIZER")
//                .email("leo.a@gmail.com")
//                .password("classics")
//                .build();
//
//        Event event = Event.builder()
//                .id(0L)
//                .name("Vivaldi concert")
//                .date("20/02/2023")
//                .description("classical music")
//                .location("ROME")
//                .user(user)
//                .build();
//
//        CreateEventRequest request = CreateEventRequest.builder()
//                .name("Vivaldi concert")
//                .date("20/02/2023")
//                .description("classical music")
//                .location("ROME")
//                .organizerId(user.getId())
//                .build();
//
//        CreateEventResponse response = CreateEventResponse.builder()
//                .name("Vivaldi concert")
//                .build();
//
//        when(eventRepository.createEvent(event)).thenReturn(event);
//        when(getUserUseCase.getUser(15L)).thenReturn(Optional.of(user));
//
//        CreateEventResponse actual = createEventUseCase.createEvent(request);
//
//        assertEquals(response, actual);
//        verify(eventRepository).createEvent(event);
//
//    }
//}