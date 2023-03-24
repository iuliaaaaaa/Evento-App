package evento.domain.eventActions;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateEventResponse {
    private String name;
}
