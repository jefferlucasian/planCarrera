package jeffer.clientes.service.validation;

import jeffer.clientes.request.ClienteRequest;

public interface ClienteValidation {

      void validacionGeneral (ClienteRequest cliente);
      void validarCorreo ( String correo );
      void validarNombre( String nombre );
      
}
