package evento.controller.DTOs;

import evento.domain.User;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class EventDTO {
    private Long id;
    private String name;
    private String description;
    private String location;
    private String date;
    private UserDTO organizerId;

}
