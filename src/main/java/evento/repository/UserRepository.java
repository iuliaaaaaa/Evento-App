package evento.repository;

import evento.domain.User;
import evento.persistance.entity.UserEntity;

import java.util.List;
import java.util.Optional;


public interface UserRepository {
    User login(String email, String password);

    User create(User user);
    List<User> findAllByRole(String role);

    Optional<User> findById(Long id);


    Boolean existsBySurname(String surname);

    List<User> findAll();
    void deleteById(long userId);

    void deleteByEmail(String email);
}
