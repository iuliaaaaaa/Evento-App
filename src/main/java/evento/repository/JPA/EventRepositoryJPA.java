package evento.repository.JPA;

import evento.domain.Event;
import evento.domain.User;
import evento.persistance.entity.EventEntity;
import evento.persistance.entity.UserEntity;
import org.apache.commons.lang3.stream.Streams;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepositoryJPA extends JpaRepository<EventEntity, Long> {
    void deleteByName(String name);


    List<EventEntity> findByUser(UserEntity user);

    List<EventEntity> findByLocation(String location);
}
