package jeffer.clientes.request;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Data
@Accessors(chain = true)
public class ClienteRequest {
      
      private Long id;
      private String nombre;
      private String correo;
      
}
