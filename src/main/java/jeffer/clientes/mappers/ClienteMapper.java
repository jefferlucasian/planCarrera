package jeffer.clientes.mappers;

import jeffer.clientes.dto.ClienteDto;
import jeffer.clientes.models.entities.Cliente;
import jeffer.clientes.request.ClienteRequest;
import jeffer.clientes.response.ClienteResponse;

public class ClienteMapper {
      
      
      public ClienteDto mapEntityToDto ( Cliente cliente ){
            
            return new ClienteDto()
                .setId( cliente.getId() )
                .setNombre(cliente.getNombre() )
                .setCorreo(cliente.getCorreo() )
                .setFechaRegistro( cliente.getFechaRegistro() )
                .setActivo( cliente.isActivo() );
      }
      
      
      public Cliente mapDtoToEntity ( ClienteDto cliente ){
            
            return new Cliente()
                .setId( cliente.getId() )
                .setNombre(cliente.getNombre() )
                .setCorreo(cliente.getCorreo() )
                .setFechaRegistro( cliente.getFechaRegistro() )
                .setActivo( cliente.isActivo() );
      }
      
      
      public ClienteDto mapRequestToDto ( ClienteRequest cliente ){
            
            return new ClienteDto()
                .setId( cliente.getId() )
                .setNombre(cliente.getNombre() )
                .setCorreo(cliente.getCorreo() );
      }
      
      public ClienteResponse mapDtoToResponse (ClienteDto cliente ){
            
            return new ClienteResponse()
                .setId( cliente.getId() )
                .setNombre(cliente.getNombre() )
                .setCorreo(cliente.getCorreo() )
                .setFechaRegistro( cliente.getFechaRegistro() );
      }
      
}
