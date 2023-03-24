package evento.business.impl;

import evento.business.RESTforUsers.CreateUserUseCase;
import evento.business.exception.IdAlreadyExists;
import evento.domain.User;
import evento.domain.userActions.CreateUserRequest;
import evento.domain.userActions.CreateUserResponse;
import evento.persistance.entity.UserEntity;
import evento.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class CreateUserUseCaseImpl implements CreateUserUseCase {

    @Autowired
    private  UserRepository userRepository;

    private  PasswordEncoder passwordEncoder;
    @Transactional
    @Override

    public CreateUserResponse createUser(CreateUserRequest request) {
        //exists by email
 //       if(userRepository.existsBySurname(request.getSurname())){
//            throw new IdAlreadyExists();
//        }

        User savedUser = saveNewUser(request);
        //saveUser(savedUser, request.getPassword());

        return CreateUserResponse.builder()
                .id(savedUser.getId())
                .build();
    }

//    private void saveUser(UserEntity user, String password){
//
//        UserEntity newUser = UserEntity.builder()
//                .name(user.getName())
//                .surname(user.getSurname())
//                .role(user.getRole())
//                .email(user.getEmail())
//                .password(password)
//                .build();
//
//    }

    private User saveNewUser(CreateUserRequest request) {
        String encodedPassword = passwordEncoder.encode(request.getPassword());
        User newUser = User.builder()
                .id(request.getId())
                .name(request.getName())
                .surname(request.getSurname())
                .email(request.getEmail())
                .password(encodedPassword)
                .userType(request.getRole())
                .build();

        return userRepository.create(newUser);
    }


}
