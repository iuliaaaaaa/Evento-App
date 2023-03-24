package evento.controller.DTOs.users;

import evento.controller.DTOs.UserDTO;
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
public class GetAllUsersResponseDTO {
    private List<UserDTO> users;
}
