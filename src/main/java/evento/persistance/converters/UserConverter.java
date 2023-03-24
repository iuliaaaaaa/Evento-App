package evento.persistance.converters;

import evento.domain.User;
import evento.persistance.entity.UserEntity;

public final class UserConverter {
    private UserConverter(){

    }

    public static User convert(UserEntity userEntity){
        return User.builder()
                .id(userEntity.getId())
                .name(userEntity.getName())
                .surname(userEntity.getSurname())
                .email(userEntity.getEmail())
                .password(userEntity.getPassword())
                .userType(userEntity.getRole())
                .build();
    }
}
