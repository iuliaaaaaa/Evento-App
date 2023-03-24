package evento.business;

import evento.domain.AccessToken;

public interface AccessTokenEncoder {
    String encode(AccessToken accessToken);
}
