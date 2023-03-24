package evento.controller.DTOs.events;

import evento.controller.DTOs.EventDTO;
import evento.domain.Event;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetAllEventsResponseDTO {
    private List<EventDTO> events;
}
