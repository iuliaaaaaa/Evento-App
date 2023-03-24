package evento.business.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class InvalidEventException extends ResponseStatusException {
    public InvalidEventException(String error){
        super(HttpStatus.BAD_REQUEST, error);
    }
}
