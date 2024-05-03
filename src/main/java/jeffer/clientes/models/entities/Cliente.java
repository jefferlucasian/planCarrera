package jeffer.clientes.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Accessors( chain = true)
@Entity(name = "clientes")
public class Cliente {
      
      
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      @Column(name = "id")
      private Long id;
      
      @Column(name = "nombre")
      private String nombre;
      
      @Column(name = "correo", unique=true)
      private String correo;
      
      @Column(name = "fecha_registro")
      private LocalDateTime fechaRegistro;
      
      @Column(name = "activo")
      private boolean activo;
      
}