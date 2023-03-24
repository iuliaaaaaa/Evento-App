package evento.business.implEvents;

import evento.business.RESTforEvents.GetEventUseCase;
import evento.domain.Event;
import evento.persistance.converters.EventConverter;
import evento.repository.JPA.EventRepositoryJPA;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class GetEventUseCaseImpl implements GetEventUseCase {
    private EventRepositoryJPA eventRepository;

    @Override
    public Optional<Event> getEvent(long id) {
        return eventRepository.findById(id).map(EventConverter::convert);
    }
}
