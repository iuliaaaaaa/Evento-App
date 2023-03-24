package evento.repository;

import evento.persistance.entity.EventEntity;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;


class EventRepositoryTest {

    @Autowired
    private EventEntity entityManager;

    @Autowired
    private EventRepository eventRepository;

}