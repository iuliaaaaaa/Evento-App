package evento.business.impl;

import evento.business.RESTforUsers.DeleteUserUseCase;

import evento.repository.JPA.UserRepositoryJPA;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class DeleteUserUseCaseImpl implements DeleteUserUseCase {

    private final UserRepositoryJPA userRepository;

//    public DeleteUserUseCaseImpl(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    @Override
    @Transactional
    public void deleteUser(long userId) {
        this.userRepository.deleteById(userId);
    }

    @Override
    public void deleteUserByEmail(String email) { this.userRepository.deleteByEmail(email);}
}
