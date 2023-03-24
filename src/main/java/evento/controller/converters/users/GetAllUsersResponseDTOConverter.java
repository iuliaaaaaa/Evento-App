package evento.controller.converters.users;

import evento.controller.DTOs.users.CreateUserResponseDTO;
import evento.controller.DTOs.users.GetAllUsersResponseDTO;
import evento.controller.converters.EventDTOConverter;
import evento.controller.converters.UserDTOConverter;
import evento.domain.userActions.CreateUserResponse;
import evento.domain.userActions.GetAllUsersResponse;

public class GetAllUsersResponseDTOConverter {
    private GetAllUsersResponseDTOConverter(){

    }

    public static GetAllUsersResponseDTO convert(GetAllUsersResponse getAllUsersResponse) {
        return GetAllUsersResponseDTO.builder()
                .users(getAllUsersResponse.getUsers()
                        .stream()
                        .map(UserDTOConverter::convert)
                        .toList()
                ).build();
    }
}
