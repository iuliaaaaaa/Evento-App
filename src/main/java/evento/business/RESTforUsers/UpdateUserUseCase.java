package evento.business.RESTforUsers;

import evento.domain.eventActions.UpdateEventRequest;
import evento.domain.eventActions.UpdateEventResponse;
import evento.domain.userActions.UpdateUserRequest;
import evento.domain.userActions.UpdateUserResponse;

public interface UpdateUserUseCase {
    UpdateUserResponse updateUser(UpdateUserRequest request);
}
