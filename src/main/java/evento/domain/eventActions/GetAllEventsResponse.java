package evento.domain.eventActions;

import evento.controller.DTOs.EventDTO;
import evento.domain.Event;
import evento.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetAllEventsResponse {
    private List<Event> events;
}
