package edu.cibertec.plantillarest.controller;
/**
 *
 * @author jpere
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import edu.cibertec.plantillarest.bean.Cliente;
import edu.cibertec.plantillarest.service.impl.ClienteServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;

@RestController
@RequestMapping("api/cliente")
@Tag(name = "Cliente", description = "Api Cliente")
public class ClienteController {

    @Autowired
    ClienteServiceImpl clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes() {
        List<Cliente> clientes = clienteService.listarCliente();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Cliente> obtenerCliente(@PathVariable("id") Integer idcliente) {
        Cliente cliente = clienteService.ObtenerCliente(idcliente);
        if (cliente != null) {
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Cliente> insertarCliente(@RequestBody Cliente cliente) {
        Cliente nuevoCliente = clienteService.insertarCliente(cliente);
        return new ResponseEntity<>(nuevoCliente, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Cliente> actualizarCliente(@RequestBody Cliente cliente) {
        Cliente clienteActualizado = clienteService.actualizarCliente(cliente);
        if (clienteActualizado != null) {
            return new ResponseEntity<>(clienteActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable("id") Integer idcliente) {
        Cliente clienteEliminado = clienteService.eliminarCliente(idcliente);
        if (clienteEliminado!=null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
