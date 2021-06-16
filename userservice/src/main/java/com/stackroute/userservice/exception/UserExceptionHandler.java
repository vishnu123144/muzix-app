package com.stackroute.userservice.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import java.util.Date;
@ControllerAdvice
public class UserExceptionHandler {
    /*handling UserNotFoundException*/
    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<?> handleUserNotFoundException(Exception exception) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage()," ");
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    /*handling UserExistsException*/
    @ExceptionHandler(value = UserAlreadyExistsException.class)

    public ResponseEntity<?> handleUserExistsException(Exception exception) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), " ");
        return new ResponseEntity<>(errorDetails, HttpStatus.ALREADY_REPORTED);
    }

    /*handling Global Exception*/
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<?> handleException(Exception exception) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage()," ");
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /*handling IncorrectPasswordException*/
    @ExceptionHandler(value= IncorrectPasswordException.class)
    public ResponseEntity<?> handleIncorrectPasswordException(Exception exception) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), " ");
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
}
