package co.hadwen.web;

import co.hadwen.web.exception.NotFoundException;
import co.hadwen.web.exception.ValidationException;
import co.hadwen.web.exception.dto.ValidationErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({ ValidationException.class })
    ResponseEntity<ValidationErrorDTO> validationError(ValidationException e) {
        System.err.println(e.getMessage());
        return ResponseEntity.badRequest().body(e.getErrorDTO());
    }

    @ExceptionHandler({ NotFoundException.class })
    ResponseEntity<ValidationErrorDTO> notFound(NotFoundException e) {
        System.err.println(e.getMessage());
        return ResponseEntity.notFound().build();
    }
}
