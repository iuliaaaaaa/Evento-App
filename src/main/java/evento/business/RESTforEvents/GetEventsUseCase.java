package evento.business.RESTforEvents;

import evento.domain.Event;
import evento.domain.eventActions.GetAllEventsRequest;
import evento.domain.eventActions.GetAllEventsResponse;

import java.util.Optional;


public interface GetEventsUseCase {
    GetAllEventsResponse getEvents(GetAllEventsRequest request);

    Optional<Event> getEvent(long id);
}
