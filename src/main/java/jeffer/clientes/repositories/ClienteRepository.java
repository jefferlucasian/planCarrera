package jeffer.clientes.repositories;

import jeffer.clientes.models.entities.Cliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClienteRepository extends CrudRepository<Cliente, Long>  {
      
      Cliente findByCorreo( String correo );
      
      @Query( value = "SELECT p FROM clientes as  p" )
      List<Cliente> all();
      
      @Query( value = "SELECT * FROM clientes WHERE id =:id AND  activo = true", nativeQuery = true )
      Cliente findByIdCliente(@Param("id")  Long id );
      
      
}
