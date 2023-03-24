package evento.controller;

import evento.business.LoginUseCase;
import evento.controller.DTOs.LoginResponseDTO;
import evento.controller.converters.LoginResponseDTOConverter;
import evento.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:3000/"})
@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {
    private final LoginUseCase loginUseCase;

    @PostMapping()
//    public ResponseEntity<LoginResponse> login(@RequestBody @Valid LoginRequest loginRequest) {
//        LoginResponse loginResponse = loginUseCase.login(loginRequest);
//        return ResponseEntity.ok(loginResponse);
//    }
    public ResponseEntity<LoginResponseDTO> login(@RequestBody User user){
        return ResponseEntity.ok(LoginResponseDTOConverter.convert(loginUseCase.login(user.getEmail(), user.getPassword())));
    }
}
