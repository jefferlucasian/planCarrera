package jeffer.clientes.dto;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class ClienteDto {
      
      private Long id;
      private String nombre;
      private String correo;
      private LocalDateTime fechaRegistro;
      private boolean activo;
      
}
