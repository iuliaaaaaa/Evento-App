package evento.business.impl;

import evento.business.RESTforUsers.GetUserUseCase;
import evento.domain.User;
import evento.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
@AllArgsConstructor
public class GetUserUseCaseImpl implements GetUserUseCase {
    private UserRepository userRepository;
    @Override
    public Optional<User> getUser(long id) {
        return userRepository.findById(id);
    }
}
