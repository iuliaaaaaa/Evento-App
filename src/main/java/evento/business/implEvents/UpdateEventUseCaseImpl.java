package evento.business.implEvents;

import evento.business.RESTforEvents.UpdateEventUseCase;
import evento.business.exception.InvalidEventException;
import evento.domain.Event;
import evento.domain.User;
import evento.domain.eventActions.UpdateEventRequest;
import evento.domain.eventActions.UpdateEventResponse;
import evento.repository.EventRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UpdateEventUseCaseImpl implements UpdateEventUseCase {
    private EventRepository eventRepository;
    @Transactional
    @Override
    public UpdateEventResponse updateEvent(UpdateEventRequest request) {

        Optional<Event> eventEntityOptional = eventRepository.getEvent(request.getId());

        if(eventEntityOptional.isEmpty()){
            throw new InvalidEventException("INVALID EVENT NAME");
        }

        Event event = Event.builder()
                .id(eventEntityOptional.get().getId())
                .user(eventEntityOptional.get().getUser())
                .name(request.getName())
                .date(request.getDate())
                .description(request.getDescription())
                .location(request.getLocation())
                .build();
        //updateEvent(request, event);

        eventRepository.updateEvent(event);

        return UpdateEventResponse.builder()
                .id(event.getId())
                .build();
    }

    private void updateEvent(UpdateEventRequest request, Event event){


        event.setUser(User.builder().id(request.getOrganizerId()).build());

        event.setName(request.getName());
        event.setDescription(request.getDescription());
        event.setDate(request.getDate());
        event.setLocation(request.getLocation());

        eventRepository.createEvent(event);
    }


}
