package evento.persistance.converters;

import evento.domain.User;
import evento.persistance.entity.UserEntity;

public class UserToEntityConverter {
    private UserToEntityConverter() {}

    public static UserEntity convertToDTO(User user) {
        return UserEntity.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .email(user.getEmail())
                .password(user.getPassword())
                .role(user.getUserType())
                .build();
    }
}
