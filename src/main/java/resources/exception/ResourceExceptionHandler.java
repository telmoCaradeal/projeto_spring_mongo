package resources.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import service.exceptions.ObjectNotFoundException;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException ex, HttpServletRequest request) {
        String error = "Dados não Localizado";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError standardError = new StandardError(System.currentTimeMillis(), status.value(), error, ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(standardError);
    }


}
