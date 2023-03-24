package evento.controller.converters;

import evento.controller.DTOs.UserDTO;
import evento.domain.User;
import evento.persistance.entity.UserEntity;

public class UserDTOConverter {
    private UserDTOConverter(){

    }

    public static UserDTO convert(User user){
        return UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .email(user.getEmail())
                .password(user.getPassword())
                .role(user.getUserType())
                .build();
    }
}
