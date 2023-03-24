package evento.persistance.converters;

import evento.domain.User;
import evento.persistance.entity.UserEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserConverterTest {

    @Test
    void convertEntityToDomain() {
        UserEntity userEntity = UserEntity.builder()
                .id(1L)
                .name("UserName")
                .surname("UserSurname")
                .email("userName@gmail.com")
                .password("1234test")
                .role("CLIENT")
                .build();
        User actual = UserConverter.convert(userEntity);

        User expected = User.builder()
                .id(1L)
                .name("UserName")
                .surname("UserSurname")
                .email("userName@gmail.com")
                .password("1234test")
                .userType("CLIENT")
                .build();

        assertEquals(expected, actual);
    }

}