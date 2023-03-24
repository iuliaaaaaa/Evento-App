package evento.controller.DTOs.events;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateEventResponseDTO {
    private String name;
}
