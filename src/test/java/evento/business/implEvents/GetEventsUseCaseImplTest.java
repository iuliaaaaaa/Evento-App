//package evento.business.implEvents;
//
//import evento.domain.Event;
//import evento.domain.User;
//import evento.domain.eventActions.GetAllEventsRequest;
//import evento.domain.eventActions.GetAllEventsResponse;
//import evento.repository.EventRepository;
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
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//@ExtendWith({SpringExtension.class, MockitoExtension.class})
//@SpringBootTest
//class GetEventsUseCaseImplTest {
//
//    @Mock
//    private EventRepository eventRepository;
//    @Mock
//    private UserRepository userRepository;
//    @InjectMocks
//    private GetEventsUseCaseImpl getEventsUseCase;
//    @Test
//    void getEvents_returnConverted() {
//
//        List<Event> events = new ArrayList<>();
//
//        User user = User.builder()
//                .id(10L)
//                .name("ana")
//                .surname("karenina")
//                .userType("ORGANIZER")
//                .email("ana@gmail.com")
//                .password("literature")
//                .build();
//        //userRepository.create(user);
//
//        User user2 = User.builder()
//                .id(11L)
//                .name("ana")
//                .surname("client")
//                .userType("CLIENT")
//                .email("ana@gmail.com")
//                .password("literature")
//                .build();
//        //userRepository.create(user2);
//
//        Event concert = Event.builder()
//                .id(1L)
//                .name("classical concert")
//                .description("concert")
//                .location("Eindhoven")
//                .date("1 September")
//                .user(user)
//                .build();
//        events.add(concert);
//        //eventRepository.createEvent(concert);
//
//        Event race = Event.builder()
//                .id(2L)
//                .name("F1")
//                .description("formula 1 race")
//                .location("Milan")
//                .user(user2)
//                .build();
//        events.add(race);
//        //eventRepository.createEvent(race);
//
//
//        when(eventRepository.findByUser(user))
//                .thenReturn(List.of(concert));
//
//        when(userRepository.findById(10L)).thenReturn(Optional.ofNullable(user));
//
//        GetAllEventsRequest request = GetAllEventsRequest.builder()
//                .organizerId(10L)
//                .build();
//
//        GetAllEventsResponse actualResult = getEventsUseCase.getEvents(request);
//
//        GetAllEventsResponse expectedResult = GetAllEventsResponse
//                .builder()
//                .events(List.of(concert))
//                .build();
//
//        assertEquals(expectedResult, actualResult);
//
//        verify(eventRepository).findByUser(user);
//    }
//
//}
