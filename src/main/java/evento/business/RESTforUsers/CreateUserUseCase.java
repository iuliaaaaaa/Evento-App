package evento.business.RESTforUsers;

import evento.domain.User;
import evento.domain.userActions.CreateUserRequest;
import evento.domain.userActions.CreateUserResponse;

public interface CreateUserUseCase {
    CreateUserResponse createUser(CreateUserRequest request);
  //  User createUser(User user);
}
