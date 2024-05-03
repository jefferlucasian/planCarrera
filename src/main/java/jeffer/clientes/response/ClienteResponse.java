package jeffer.clientes.response;

import lombok.Data;
import lombok.experimental.Accessors;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@Accessors(chain = true)
public class ClienteResponse {
      
      private Long id;
      private String nombre;
      private String correo;
      private LocalDateTime fechaRegistro;
}
