package evento.controller.converters.events;

import evento.controller.DTOs.events.GetAllEventsResponseDTO;
import evento.controller.converters.EventDTOConverter;
import evento.domain.eventActions.GetAllEventsResponse;

public class GetAllEventsResponseDTOConverter {
    private GetAllEventsResponseDTOConverter(){

    }

    public static GetAllEventsResponseDTO convert(GetAllEventsResponse getAllEventsResponse){
        return GetAllEventsResponseDTO.builder()
                .events(getAllEventsResponse.getEvents()
                        .stream()
                        .map(EventDTOConverter::convert)
                        .toList()
                ).build();

    }
}
