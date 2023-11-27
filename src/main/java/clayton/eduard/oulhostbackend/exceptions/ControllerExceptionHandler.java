package clayton.eduard.oulhostbackend.exceptions;

import java.util.NoSuchElementException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity threatNoSuchElementException(NoSuchElementException exception) {
        ExceptionDto dto = new ExceptionDto("Essa lista não possui mais usuarios disponiveis", "400");
        return ResponseEntity.badRequest().body(dto);
    }
}
