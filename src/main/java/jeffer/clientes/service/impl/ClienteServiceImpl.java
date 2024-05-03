package jeffer.clientes.service.impl;

import jeffer.clientes.dto.ClienteDto;
import jeffer.clientes.mappers.ClienteMapper;
import jeffer.clientes.miscellaneous.exceptions.ValidationException;
import jeffer.clientes.repositories.ClienteRepository;
import jeffer.clientes.request.ClienteRequest;
import jeffer.clientes.response.ClienteResponse;
import jeffer.clientes.response.DeleteResponse;
import jeffer.clientes.service.ClienteService;
import jeffer.clientes.service.validation.ClienteValidation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Log4j2
@Service
public class ClienteServiceImpl implements ClienteService {
      
      @Autowired
      ClienteValidation clienteValidation;
      
      @Autowired
      ClienteRepository clienteRepository;
      
      @Override
      public ClienteResponse guardarCliente(ClienteRequest clienteNuevo) {
            
            // Validaciones
            clienteValidation.validacionGeneral(clienteNuevo);
            existByEmail(clienteNuevo.getCorreo()) ;
            
            ClienteDto clienteDto = new ClienteMapper().mapRequestToDto( clienteNuevo );
            
            // Establecimiento de datos
            clienteDto.setActivo(true);
            clienteDto.setFechaRegistro(LocalDateTime.now());
            
            
            // Registro en bd
            clienteDto = new ClienteMapper().mapEntityToDto( clienteRepository.save( new ClienteMapper().mapDtoToEntity( clienteDto )) );
            log.info("Se gurado un nuevo cliente.");
            return  new ClienteMapper().mapDtoToResponse( clienteDto );
      }
      
      @Override
      public ClienteResponse consultarPorId(Long id) {
            ClienteDto clienteDto = findById(id).get();
            return new ClienteMapper().mapDtoToResponse(clienteDto);
      }

      
      
      @Override
      public List<ClienteResponse> listarClientes() {
            
            log.info("Todos los usuarios");
            return clienteRepository.all().stream()
                .map( cliente -> {
                      
                      ClienteResponse response  = new ClienteMapper().mapDtoToResponse( new ClienteMapper().mapEntityToDto( cliente ));
                      return response;
                }).collect( Collectors.toList() );
      }
      
      
      @Override
      public ClienteResponse actualizarCliente(ClienteRequest cliente) {
            
            ClienteDto clienteDto = findById( cliente.getId() ).get();
            clienteDto.setNombre(cliente.getNombre());
            clienteDto = new  ClienteMapper().mapEntityToDto(clienteRepository.save(new ClienteMapper().mapDtoToEntity(clienteDto)));
            log.info("Se actualizó el cliente con id "+ cliente.getId());
            return new ClienteMapper().mapDtoToResponse(clienteDto);
      }
      
      @Override
      public DeleteResponse eliminarCliente(Long id) {
            
            ClienteDto clienteDto = findById( id ).get();
            clienteDto.setActivo(false);
            clienteDto = new  ClienteMapper().mapEntityToDto(clienteRepository.save(new ClienteMapper().mapDtoToEntity(clienteDto)));
            DeleteResponse response = new DeleteResponse();
            log.info("Se eliminó el cliente con id "+ id);
            response.setMensaje("Cliente Eliminado con exito.");
            return  response;
      }
      
      @Override
      public Optional<ClienteDto> findById(Long id) {
            
            var cliente = Optional.ofNullable( clienteRepository.findByIdCliente(id))
                .orElseThrow(() -> {
                      
                      log.info("Usuario no encontrado con id " + id);
                      throw  new ValidationException("Cliente no encontrado.");
                });
            
            return Optional.of( new ClienteMapper().mapEntityToDto( cliente ));
      }
      
      
      @Override
      public Boolean existByEmail(String email) {
            Optional.ofNullable(clienteRepository.findByCorreo(email))
                .ifPresent(cliente -> {
                      log.info("Ya existe un usuario registrado con el correo " + email);
                      throw new ValidationException("Este correo ya está registrado.");
                });
            
            return false;
      }
      
}