package evento.business.RESTforEvents;

import evento.domain.eventActions.UpdateEventRequest;
import evento.domain.eventActions.UpdateEventResponse;


public interface UpdateEventUseCase {
     UpdateEventResponse updateEvent(UpdateEventRequest request);
}
