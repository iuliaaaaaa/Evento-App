package evento.domain.eventActions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateEventRequest {

    private Long id;

    private String name;

    private String description;

    private String location;
   // @NotBlank
    private String date;

    private long organizerId;

}
