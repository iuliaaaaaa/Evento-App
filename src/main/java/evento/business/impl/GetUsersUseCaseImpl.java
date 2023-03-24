package evento.business.impl;

import evento.persistance.converters.UserConverter;
import evento.business.RESTforUsers.GetUsersUseCase;
import evento.domain.userActions.GetAllUsersRequest;
import evento.domain.userActions.GetAllUsersResponse;
import evento.domain.User;
import evento.persistance.entity.UserEntity;
import evento.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GetUsersUseCaseImpl implements GetUsersUseCase {
    private UserRepository userRepository;
    @Override
    public GetAllUsersResponse getUsers(final GetAllUsersRequest request) {
        List<User> results;

        if(request.getRole() != null) {
            results = userRepository.findAllByRole(request.getRole());
        } else {
            results = userRepository.findAll();
        }

        final GetAllUsersResponse response = new GetAllUsersResponse();
        List<User> users = results;

        response.setUsers(users);

        return response;
    }
}
