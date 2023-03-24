package evento.persistance.converters;

import evento.domain.Event;
import evento.persistance.entity.EventEntity;

public class EventToEntityConverter {

    private EventToEntityConverter(){}

    public static EventEntity convertToDTO(Event event){
        return EventEntity.builder()
                .id(event.getId())
                .name(event.getName())
                .location(event.getLocation())
                .description(event.getDescription())
                .date(event.getDate())
                .user(UserToEntityConverter.convertToDTO(event.getUser()))
                .build();
    }

}
