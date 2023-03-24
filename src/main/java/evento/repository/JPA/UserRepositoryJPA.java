package evento.repository.JPA;

import evento.persistance.entity.UserEntity;
import evento.repository.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepositoryJPA extends JpaRepository<UserEntity, Long> {
    UserEntity findByName(String name);

    UserEntity findByEmail(String email);

    List<UserEntity> findAllByRole(String role);

    void deleteByName(String name);

    Boolean findBySurname(String surname);

    void deleteByEmail(String email);
}
