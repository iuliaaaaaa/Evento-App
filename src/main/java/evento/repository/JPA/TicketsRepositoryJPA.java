package evento.repository.JPA;

import evento.domain.Ticket;
import evento.persistance.entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketsRepositoryJPA extends JpaRepository<TicketEntity, Long> {
}
