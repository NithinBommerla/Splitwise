package dev.nithin.Splitwise.exception;

import dev.nithin.Splitwise.DTO.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    // Handle exceptions globally
    // You can define methods here to handle specific exceptions
    // and return appropriate responses to the client.

     @ExceptionHandler(GroupNotFoundException.class)
     public ResponseEntity<ErrorDTO> handleGroupNotFound(GroupNotFoundException ex) {
         ErrorDTO errorDto = new ErrorDTO();
         errorDto.setMessage(ex.getMessage());
         errorDto.setStatus("Failure");
         return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
     }

     @ExceptionHandler(UserAlreadyExistsInGroupException.class)
     public ResponseEntity<ErrorDTO> handleUserAlreadyExistsInGroup(UserAlreadyExistsInGroupException ex) {
         ErrorDTO errorDto = new ErrorDTO();
         errorDto.setMessage(ex.getMessage());
         errorDto.setStatus("Failure");
         return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
     }

     @ExceptionHandler(UserNotFoundException.class)
     public ResponseEntity<ErrorDTO> handleUserNotFound(UserNotFoundException ex) {
         ErrorDTO errorDto = new ErrorDTO();
         errorDto.setMessage(ex.getMessage());
         errorDto.setStatus("Failure");
         return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
     }
}
