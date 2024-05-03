package jeffer.clientes.service.validation.iimpl;

import jeffer.clientes.miscellaneous.exceptions.ValidationException;
import jeffer.clientes.request.ClienteRequest;
import jeffer.clientes.service.validation.ClienteValidation;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ClienteValidationImpl implements ClienteValidation {
      
      private static final Logger logger = LoggerFactory.getLogger(ClienteValidationImpl.class);
      
      public void validarCorreo(String correo) {
            if (correo == null || !correo.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
                  log.error("El correo electrónico no es válido.");
                  log.error("LogBack");
                  logger.info("El correo electrónico no es válido.");
                  throw new ValidationException("El correo electrónico no es válido.");
            }
      }
      
      public void validarNombre(String nombre) {
            if (nombre == null || nombre.trim().isEmpty()) {
                  log.error("El nombre no puede estar vacío.");
                  throw new ValidationException("El nombre no puede estar vacío.");
            }
      }
      
      public void validacionGeneral(ClienteRequest cliente) {
            validarCorreo(cliente.getCorreo());
            validarNombre(cliente.getNombre());
      }
}
