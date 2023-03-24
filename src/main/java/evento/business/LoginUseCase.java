package evento.business;

import evento.domain.loginActions.LoginRequest;
import evento.domain.loginActions.LoginResponse;

public interface LoginUseCase {
   // LoginResponse login(LoginRequest loginRequest);

    LoginResponse login(String email, String password);
}
