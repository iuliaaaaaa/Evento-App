package evento.repository;

import evento.domain.Event;
import evento.domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface TicketsRepository {
    Ticket findById(long id);
    Ticket create(Ticket ticket);
}
