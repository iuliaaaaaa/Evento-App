package evento.business.RESTforEvents;

import evento.domain.eventActions.CreateEventRequest;
import evento.domain.eventActions.CreateEventResponse;


public interface CreateEventUseCase {
    CreateEventResponse createEvent(CreateEventRequest request);
}
