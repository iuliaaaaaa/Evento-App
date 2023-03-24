package evento.business.RESTforUsers;

import evento.domain.User;
import evento.persistance.entity.UserEntity;

import java.util.Optional;

public interface GetUserUseCase {
    Optional<User>getUser(long id);
}
