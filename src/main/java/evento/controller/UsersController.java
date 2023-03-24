package evento.controller;

import evento.business.RESTforUsers.*;
import evento.controller.DTOs.UserDTO;
import evento.controller.DTOs.users.CreateUserResponseDTO;
import evento.controller.DTOs.users.GetAllUsersResponseDTO;
import evento.controller.converters.UserDTOConverter;
import evento.controller.converters.users.CreateUsersResponseDTOConverter;
import evento.controller.converters.users.GetAllUsersResponseDTOConverter;
import evento.domain.*;

import evento.domain.userActions.*;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;


@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@AllArgsConstructor
public class UsersController {

    @Autowired
    private GetUsersUseCase getUsersUseCase;
    @Autowired
    private CreateUserUseCase createUserUseCase;

    @Autowired
    private GetUserUseCase getUserUseCase;

    @Autowired
    private UpdateUserUseCase updateUserUseCase;

    @Autowired
    private DeleteUserUseCase deleteUserUseCase;


    @GetMapping()
    public ResponseEntity<GetAllUsersResponseDTO> getAllUsers() {
        GetAllUsersRequest request = new GetAllUsersRequest();
        return ResponseEntity.ok(GetAllUsersResponseDTOConverter.convert(getUsersUseCase.getUsers(request)));
    }

    @GetMapping({"/role/{role}"})
    public ResponseEntity<GetAllUsersResponseDTO> getAllUsers(@PathVariable(value = "role", required = false) String role) {
        GetAllUsersRequest request = new GetAllUsersRequest();
        request.setRole(role);
        return ResponseEntity.ok(GetAllUsersResponseDTOConverter.convert(getUsersUseCase.getUsers(request)));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable(value = "id") final long id) {
        final Optional<User> userOptional = getUserUseCase.getUser(id);
        if (userOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(UserDTOConverter.convert(userOptional.get()));
    }
    @PostMapping()
    public ResponseEntity<CreateUserResponseDTO> createUser(
           @RequestBody @Valid CreateUserRequest createUserRequest) {
        CreateUserResponseDTO response = CreateUsersResponseDTOConverter.convert(createUserUseCase.createUser(createUserRequest));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

   }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable long userId) {
        deleteUserUseCase.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable("id") long id, @RequestBody @Valid UpdateUserRequest request) {
        request.setId(id);
        updateUserUseCase.updateUser(request);
        return ResponseEntity.noContent().build();
    }

}
