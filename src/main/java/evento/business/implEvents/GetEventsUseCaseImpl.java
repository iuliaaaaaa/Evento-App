package evento.business.implEvents;

import evento.business.RESTforEvents.GetEventsUseCase;
import evento.domain.Event;
import evento.domain.User;
import evento.domain.eventActions.GetAllEventsRequest;
import evento.domain.eventActions.GetAllEventsResponse;
import evento.persistance.converters.EventConverter;
import evento.persistance.entity.EventEntity;
import evento.repository.EventRepository;
import evento.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GetEventsUseCaseImpl implements GetEventsUseCase {
    private EventRepository eventRepository;
    private UserRepository userRepository;
    @Override
    public GetAllEventsResponse getEvents(final GetAllEventsRequest request) {
        List<Event> results;

        if(request.getLocation() != null) {
            results = eventRepository.findAllByLocation(request.getLocation());
        }else{
            results= eventRepository.getEvents();
        }

        if(request.getOrganizerId() != null) {
            User user = userRepository.findById(request.getOrganizerId()).get();
            results = eventRepository.findByUser(user);
        }else{
            results= eventRepository.getEvents();
        }

        final GetAllEventsResponse response = new GetAllEventsResponse();
        List<Event> events = results;

        response.setEvents(events);

        return response;
    }

    @Override
    public Optional<Event> getEvent(long id) {
        return Optional.empty();
    }
}
