package evento.business.RESTforEvents;

import evento.domain.Event;
import java.util.Optional;

public interface GetEventUseCase {
    Optional<Event> getEvent(long id);
}
