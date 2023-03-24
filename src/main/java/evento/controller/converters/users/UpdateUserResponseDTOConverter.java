package evento.controller.converters.users;

import evento.controller.DTOs.events.UpdateEventResponseDTO;
import evento.domain.eventActions.UpdateEventResponse;
import evento.domain.userActions.UpdateUserResponse;

public class UpdateUserResponseDTOConverter {
    private UpdateUserResponseDTOConverter(){

    }

    public static UpdateEventResponseDTO convert(UpdateUserResponse updateUserResponse) {
        return UpdateEventResponseDTO.builder()
                .id(updateUserResponse.getId())
                .build();
    }
}
