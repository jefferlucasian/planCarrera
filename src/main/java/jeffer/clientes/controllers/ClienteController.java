package jeffer.clientes.controllers;


import jeffer.clientes.request.ClienteRequest;
import jeffer.clientes.response.ClienteResponse;
import jeffer.clientes.response.DeleteResponse;
import jeffer.clientes.service.ClienteService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
      
      
      @Autowired
      ClienteService clienteService;
      
      @PostMapping("/guardar")
      public ResponseEntity<ClienteResponse> guardarCliente(@RequestBody ClienteRequest cliente) {
            
            return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.guardarCliente(cliente));
      }
      
      @GetMapping("/todos")
      public ResponseEntity<List<ClienteResponse>> listarClientes (){
            
            return ResponseEntity.ok().body(clienteService.listarClientes());
      }
      
      
      @GetMapping("/{id}")
      public ResponseEntity<ClienteResponse> consultarPorId (@PathVariable("id") Long id ){
            
            return ResponseEntity.ok().body(clienteService.consultarPorId( id ));
      }
      
      
      @PutMapping("/actualizar")
      public ResponseEntity<ClienteResponse> actualizar (@RequestBody ClienteRequest cliente ){
            
            return ResponseEntity.ok().body(clienteService.actualizarCliente( cliente ));
      }
      
      
      @DeleteMapping("/eliminar/{id}")
      public ResponseEntity<DeleteResponse> eliminar (@PathVariable Long id ){
            
            return ResponseEntity.ok().body(clienteService.eliminarCliente( id ));
      }
      
      
      @GetMapping("/error")
      public void testException() {
            throw new RuntimeException("¡Esta es una excepción de prueba!");
      }
      
      
}
