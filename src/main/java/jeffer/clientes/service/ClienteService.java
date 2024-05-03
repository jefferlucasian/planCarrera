package jeffer.clientes.service;

import jeffer.clientes.dto.ClienteDto;
import jeffer.clientes.request.ClienteRequest;
import jeffer.clientes.response.ClienteResponse;
import jeffer.clientes.response.DeleteResponse;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
      
      
      // Metodos HTTP
      ClienteResponse guardarCliente (ClienteRequest clienteNuevo);
      
      ClienteResponse consultarPorId (Long id);
      
      List<ClienteResponse> listarClientes ();
      
      ClienteResponse actualizarCliente ( ClienteRequest cliente);
      
      DeleteResponse eliminarCliente (Long id );
      
      
      // Metodos para usar en otros servicios
      Optional<ClienteDto> findById (Long id);
      Boolean existByEmail (String email);
      
}
