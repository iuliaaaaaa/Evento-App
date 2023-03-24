package evento.repository.impl;

import evento.domain.Event;
import evento.domain.User;
import evento.persistance.converters.EventToEntityConverter;
import evento.persistance.converters.UserToEntityConverter;
import evento.persistance.converters.EventConverter;
import evento.persistance.entity.EventEntity;
import evento.repository.EventRepository;
import evento.repository.JPA.EventRepositoryJPA;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class EventRepositoryImpl implements EventRepository {

    private EventRepositoryJPA eventRepositoryJPA;


    @Override
    public Optional<Event> getEvent(Long id) {
        return eventRepositoryJPA.findById(id).map(EventConverter::convert);
    }


    @Override
    public boolean existsById(Long id) {
        return false;
    }


    @Override
    public List<Event> getEvents(){
        return eventRepositoryJPA.findAll()
                .stream()
                .map(EventConverter::convert)
                .toList();
    }

    @Override
    public Event findByName(String name) {
        return null;
    }

    @Override
    public Event updateEvent(Event event) {
        EventEntity entity = EventEntity.builder()
                .id(event.getId())
                .user(UserToEntityConverter.convertToDTO(event.getUser()))
                .name(event.getName())
                .description(event.getDescription())
                .date(event.getDate())
                .location(event.getLocation())
                .build();
        return EventConverter.convert(eventRepositoryJPA.save(entity));
    }


    @Override
    public List<Event> findAllByLocation(String location) {
        return eventRepositoryJPA.findByLocation(location)
                .stream()
                .map(EventConverter::convert)
                .toList();
    }

    @Override
    public List<Event> findByUser(User user) {
        return eventRepositoryJPA.findByUser(UserToEntityConverter.convertToDTO(user))
                .stream()
                .map(EventConverter::convert)
                .toList();
    }

    @Override
    public void deleteByName(String name) {
        eventRepositoryJPA.deleteByName(name);
    }

    @Override
    public void deleteById(Long id) {
        eventRepositoryJPA.deleteById(id);
    }

    @Override
    public Event createEvent(Event event){
        EventEntity entity = EventEntity.builder()
                .user(UserToEntityConverter.convertToDTO(event.getUser()))
                .name(event.getName())
                .description(event.getDescription())
                .date(event.getDate())
                .location(event.getLocation())
                .build();
        return EventConverter.convert(eventRepositoryJPA.save(entity));
    }



}
