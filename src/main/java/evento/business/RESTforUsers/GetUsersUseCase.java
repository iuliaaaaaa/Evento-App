package evento.business.RESTforUsers;

import evento.domain.User;
import evento.domain.userActions.GetAllUsersRequest;
import evento.domain.userActions.GetAllUsersResponse;

public interface GetUsersUseCase {
    GetAllUsersResponse getUsers(GetAllUsersRequest request);
    //List<User> getUsers();

}
