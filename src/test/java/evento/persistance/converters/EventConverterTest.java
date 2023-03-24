package evento.persistance.converters;

import evento.domain.User;
import evento.domain.Event;
import evento.persistance.entity.EventEntity;
import evento.persistance.entity.UserEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventConverterTest {
    @Test
    void convertEntityToDomain() {
        EventEntity eventEntity = EventEntity.builder()
                .id(1L)
                .name("UserName")
                .description("UserSurname")
                .location("userName@gmail.com")
                .date("1234test")
                .user(UserEntity.builder()
                        .id(1L)
                        .name("bob")
                        .surname("bobistic")
                        .email("bob@gmail.com")
                        .password("bobita")
                        .role("CLIENT")
                        .build())
                .build();
        Event actual = EventConverter.convert(eventEntity);

        Event expected = Event.builder()
                .id(1L)
                .name("UserName")
                .description("UserSurname")
                .location("userName@gmail.com")
                .date("1234test")
                .user(User.builder()
                        .id(1L)
                        .name("bob")
                        .surname("bobistic")
                        .email("bob@gmail.com")
                        .password("bobita")
                        .userType("CLIENT")
                        .build())
                .build();

        assertEquals(expected, actual);
    }
}
