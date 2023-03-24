package evento.repository;
import evento.domain.Event;
import evento.domain.User;
import evento.persistance.entity.EventEntity;
import java.util.List;
import java.util.Optional;


public interface EventRepository {
    Event findByName(String name);
    Event updateEvent(Event event);
    List<Event> findAllByLocation(String location);
    List<Event> findByUser(User user);
    void deleteByName(String name);
    void deleteById(Long id);

    Event createEvent (Event event);
    List<Event> getEvents();
    Optional<Event> getEvent(Long id);


    boolean existsById(Long id);

}

