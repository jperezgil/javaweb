package edu.cibertec.plantillarest.controller;
/**
 *
 * @author jpere
 */
import edu.cibertec.plantillarest.bean.Cliente;
import edu.cibertec.plantillarest.service.ClienteService;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
@Tag(name = "ClienteBasico", description = "Api Cliente bajo un estandar basico")
public class ClienteBasicoController {
    @Autowired
    ClienteService clienteService;
    
    @GetMapping
    public List<Cliente> listarClientes(){
        return clienteService.listarCliente();
    }
    
    @GetMapping(value="/{id}")
    public Cliente obtenerCliente(@PathVariable("id") Integer idcliente){
        return clienteService.ObtenerCliente(idcliente);
    }
    
    @PostMapping
    public Cliente insetarCliente(@RequestBody Cliente cliente){
        return clienteService.insertarCliente(cliente);
    }
    
    @PutMapping
    public Cliente actualizarCliente(@RequestBody Cliente cliente){
        return clienteService.insertarCliente(cliente);
    }
    
    @DeleteMapping(value="/{id}")
    public Cliente actualizarCliente(@PathVariable("id") Integer idcliente){
        return clienteService.eliminarCliente(idcliente);
    }
    
}
