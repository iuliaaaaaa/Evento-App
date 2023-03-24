package evento.controller.converters;

import evento.controller.DTOs.LoginResponseDTO;
import evento.domain.loginActions.LoginResponse;

public class LoginResponseDTOConverter {
    private LoginResponseDTOConverter(){}

    public static LoginResponseDTO convert(LoginResponse loginResponse) {
        return LoginResponseDTO.builder()
                .accessToken(loginResponse.getAccessToken())
                .role(loginResponse.getRole())
                .build();
    }
}
