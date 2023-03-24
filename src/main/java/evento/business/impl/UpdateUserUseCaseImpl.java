package evento.business.impl;

import evento.business.RESTforUsers.UpdateUserUseCase;
import evento.business.exception.InvalidUserException;
import evento.domain.User;
import evento.domain.userActions.UpdateUserRequest;
import evento.domain.userActions.UpdateUserResponse;
import evento.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import evento.persistance.entity.UserEntity;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UpdateUserUseCaseImpl implements UpdateUserUseCase {
    private final UserRepository userRepository;
    @Override
    public UpdateUserResponse updateUser(UpdateUserRequest request) {
        Optional<User> userEntityOptional = userRepository.findById(request.getId());
        if(userEntityOptional.isEmpty()){
            throw new InvalidUserException("INVALID USER ID");
        }

        User user = userEntityOptional.get();
        updateUser(request, user);

        return UpdateUserResponse.builder()
                .id(user.getId())
                .build();

    }

    private void updateUser(UpdateUserRequest request, User user){
       user.setEmail(request.getEmail());
       user.setName(request.getName());

       userRepository.create(user);
    }
}
