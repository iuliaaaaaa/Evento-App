package evento.controller.converters;

import evento.controller.DTOs.EventDTO;
import evento.domain.Event;
import evento.persistance.converters.UserConverter;
import evento.persistance.entity.EventEntity;

public class EventDTOConverter {
    private EventDTOConverter(){

    }

    public static EventDTO convert(Event event){
        return EventDTO.builder()
                .id(event.getId())
                .name(event.getName())
                .location(event.getLocation())
                .description(event.getDescription())
                .date(event.getDate())
                .organizerId(UserDTOConverter.convert(event.getUser()))
                .build();
    }
}
