package evento.business.RESTforEvents;

import javax.transaction.Transactional;

public interface DeleteEventUseCase {
    void deleteEvent(long eventId);
    @Transactional
    void deleteEventByName(String name);
}
