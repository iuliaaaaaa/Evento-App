package evento.persistance.converters;

import evento.domain.Event;
import evento.persistance.entity.EventEntity;

public class EventConverter {
    private EventConverter(){

    }

    public static Event convert(EventEntity event){
        return Event.builder()
                .id(event.getId())
                .name(event.getName())
                .location(event.getLocation())
                .description(event.getDescription())
                .date(event.getDate())
                .user(UserConverter.convert(event.getUser()))
                .build();
    }
}

