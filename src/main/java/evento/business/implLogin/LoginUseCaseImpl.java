package evento.business.implLogin;

import evento.business.AccessTokenEncoder;
import evento.business.LoginUseCase;
import evento.business.RESTforUsers.GetUsersUseCase;
import evento.business.exception.InvalidCredentialsException;
import evento.domain.AccessToken;
import evento.domain.User;
import evento.domain.loginActions.LoginRequest;
import evento.domain.loginActions.LoginResponse;
import evento.persistance.entity.UserEntity;
import evento.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor
public class LoginUseCaseImpl implements LoginUseCase {
    @Autowired
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;
    private final AccessTokenEncoder accessTokenEncoder;

    @Override
    public LoginResponse login(String email, String password){
        User user = userRepository.login(email, password);

        if(user == null || !matchesPassword(password, user.getPassword())) {
            throw new InvalidCredentialsException();
        }

        String accessToken = generateAccessToken(user);
        return LoginResponse.builder()
                .accessToken(accessToken)
                .role(user.getUserType())
                .build();
    }


    private boolean matchesPassword(String rawPassword, String encodedPassword) {

        return passwordEncoder.matches(rawPassword, encodedPassword);

    }

    private String generateAccessToken(User user) {
        Long userId = user.getId() != null ? Long.valueOf(user.getId()) : null;
       List<String> roles = new ArrayList<>();
       roles.add(user.getUserType());

       return accessTokenEncoder.encode(
                AccessToken.builder()
                        .subject(user.getName())
                        .roles(roles)
                        .userId(userId)
                        .build());
    }


}
