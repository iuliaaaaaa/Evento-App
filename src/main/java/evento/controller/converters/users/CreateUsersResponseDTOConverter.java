package evento.controller.converters.users;

import evento.controller.DTOs.events.CreateEventResponseDTO;
import evento.controller.DTOs.users.CreateUserResponseDTO;
import evento.domain.eventActions.CreateEventResponse;
import evento.domain.userActions.CreateUserResponse;

public class CreateUsersResponseDTOConverter {

    private CreateUsersResponseDTOConverter(){

    }

    public static CreateUserResponseDTO convert(CreateUserResponse createUserResponse) {
        return CreateUserResponseDTO.builder()
                .id(createUserResponse.getId())
                .build();
    }
}
