package bouda.med.company.exception.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import bouda.med.company.exception.EntityAlreadyExistsException;
import bouda.med.company.exception.EntityNotFoundException;
import bouda.med.company.exception.InternalServerError;
import bouda.med.company.shared.ErrorMessage;

@RestControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(value = {EntityNotFoundException.class})

    public ResponseEntity<Object> entityNotFoundException(EntityNotFoundException exception){
        ErrorMessage errorMessage = ErrorMessage.builder()
                .message(exception.getMessage())
                .timestamp(new Date())
                .code(404)
                .build();
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {EntityAlreadyExistsException.class})
    public ResponseEntity<Object> entityAlreadyExistsException(EntityAlreadyExistsException ex) {
        ErrorMessage errorMessage = ErrorMessage.builder()
                .message(ex.getMessage())
                .timestamp(new Date())
                .code(409)
                .build();
        return new ResponseEntity<>(errorMessage, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = {InternalServerError.class})
    public ResponseEntity<Object> internalServerError(InternalServerError ex){
        ErrorMessage errorMessage = ErrorMessage.builder()
                    .message(ex.getMessage())
                    .timestamp(new Date())
                    .code(500)
                    .build();
        return new ResponseEntity<>(errorMessage,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
}
