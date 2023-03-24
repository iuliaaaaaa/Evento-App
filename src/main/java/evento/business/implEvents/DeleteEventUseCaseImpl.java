package evento.business.implEvents;

import evento.business.RESTforEvents.DeleteEventUseCase;
import evento.repository.EventRepository;
import evento.repository.JPA.EventRepositoryJPA;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class DeleteEventUseCaseImpl implements DeleteEventUseCase {

    @Autowired
    private EventRepository eventRepository;

    @Override
    @Transactional
    public void deleteEvent(long eventId) {
        this.eventRepository.deleteById(eventId);
    }

    @Override
    public void deleteEventByName(String name) { this.eventRepository.deleteByName(name);}
}
