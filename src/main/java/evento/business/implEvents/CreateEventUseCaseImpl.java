package evento.business.implEvents;

import evento.business.RESTforEvents.CreateEventUseCase;
import evento.business.RESTforUsers.GetUserUseCase;
import evento.business.exception.IdAlreadyExists;
import evento.business.impl.GetUserUseCaseImpl;
import evento.domain.Event;
import evento.domain.User;
import evento.domain.eventActions.CreateEventRequest;
import evento.domain.eventActions.CreateEventResponse;
import evento.persistance.entity.EventEntity;
import evento.persistance.entity.UserEntity;
import evento.repository.EventRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CreateEventUseCaseImpl implements CreateEventUseCase {
    private EventRepository eventRepository;

    GetUserUseCase getUserUseCase;

    @Override
    public CreateEventResponse createEvent(CreateEventRequest request) {
        //exists by name
//        if(eventRepository.existsById(request.getId())) {
//            throw new IdAlreadyExists();
//        }
        Event savedEvent = saveNewEvent(request);

        return CreateEventResponse.builder()
                .name(savedEvent.getName())
                .build();

    }

    private Event saveNewEvent(CreateEventRequest request) {

        Optional<User> optUser = getUserUseCase.getUser(request.getOrganizerId());

        User userInEvent = User.builder()
                .id(optUser.get().getId())
                .name(optUser.get().getName())
                .surname(optUser.get().getSurname())
                .email(optUser.get().getEmail())
                .password(optUser.get().getPassword())
                .userType(optUser.get().getUserType())
                .build();

        Event newEvent = Event.builder()
                .id(request.getId())
                .name(request.getName())
                .location(request.getLocation())
                .date(request.getDate())
                .description(request.getDescription())
                .user(userInEvent)
                .build();
        return eventRepository.createEvent(newEvent);
    }

}
