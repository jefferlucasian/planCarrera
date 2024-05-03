package jeffer.clientes.miscellaneous.exceptions;

import jeffer.clientes.response.ErrorResponse;

public class ValidationException extends RuntimeException {
      public ValidationException(String message) {
            super(message);
      }
}


