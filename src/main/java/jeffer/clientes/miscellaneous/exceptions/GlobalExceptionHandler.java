package jeffer.clientes.miscellaneous.exceptions;

import jakarta.annotation.Nullable;
import jeffer.clientes.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
      
      @ExceptionHandler(ValidationException.class)
      @ResponseStatus(HttpStatus.BAD_REQUEST)
      public ResponseEntity<ErrorResponse> handleValidationException(ValidationException ex) {
            ErrorResponse errorResponse = new ErrorResponse(ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
      }
      
      @ExceptionHandler(Exception.class)
      @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
      public ResponseEntity<ErrorResponse> handleException(Exception e) {
            String errorMessage = "Ocurrió un error inesperado. Por favor, inténtelo de nuevo más tarde.";
            ErrorResponse errorResponse = new ErrorResponse(errorMessage);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
      }
}

