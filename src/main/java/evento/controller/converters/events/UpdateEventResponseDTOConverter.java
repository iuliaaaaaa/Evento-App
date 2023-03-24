package evento.controller.converters.events;

import evento.controller.DTOs.events.CreateEventResponseDTO;
import evento.controller.DTOs.events.UpdateEventResponseDTO;
import evento.domain.eventActions.CreateEventResponse;
import evento.domain.eventActions.UpdateEventResponse;

public class UpdateEventResponseDTOConverter {
    private UpdateEventResponseDTOConverter(){

    }

    public static UpdateEventResponseDTO convert(UpdateEventResponse updateEventResponse) {
        return UpdateEventResponseDTO.builder()
                .id(updateEventResponse.getId())
                .build();
    }
}
