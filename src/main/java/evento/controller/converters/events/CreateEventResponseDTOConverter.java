package evento.controller.converters.events;

import evento.controller.DTOs.events.CreateEventResponseDTO;
import evento.controller.DTOs.events.GetAllEventsResponseDTO;
import evento.domain.eventActions.CreateEventResponse;
import evento.domain.eventActions.GetAllEventsResponse;

public class CreateEventResponseDTOConverter {
    private CreateEventResponseDTOConverter(){

    }

    public static CreateEventResponseDTO convert(CreateEventResponse createEventResponse) {
        return CreateEventResponseDTO.builder()
                .name(createEventResponse.getName())
                .build();
    }
}
