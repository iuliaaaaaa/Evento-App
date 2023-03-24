package evento.business.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class InvalidUserException extends ResponseStatusException {
    public InvalidUserException(String error){
        super(HttpStatus.BAD_REQUEST, error);
    }
}
