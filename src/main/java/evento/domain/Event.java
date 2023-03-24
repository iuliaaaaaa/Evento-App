package evento.domain;

import evento.persistance.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
public class Event {
    private Long id;
    private String name;
    private String description;
    private String location;
    private String date;
    private User user;

}
