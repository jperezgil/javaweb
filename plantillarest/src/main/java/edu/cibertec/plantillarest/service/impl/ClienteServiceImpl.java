/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.plantillarest.service.impl;

import edu.cibertec.plantillarest.bean.Cliente;
import edu.cibertec.plantillarest.repository.ClienteRepository;
import edu.cibertec.plantillarest.service.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jpere
 */
@Service
public class ClienteServiceImpl  implements ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;
    @Override
    public List<Cliente> listarCliente() {
        return clienteRepository.findAll();
    }
    @Override
    public Cliente ObtenerCliente (Integer idcliente){
        return clienteRepository.ObtenerCliente(idcliente);
    }

    @Override
    public Cliente insertarCliente(Cliente cliente) {
      return clienteRepository.save(cliente);
    }

    @Override
    public Cliente actualizarCliente(Cliente cliente) {
      return clienteRepository.save(cliente);
    }

    @Override
    public Cliente eliminarCliente(Integer idcliente) {
       Cliente cliente = clienteRepository.ObtenerCliente(idcliente);
       cliente.setEstado("0");
       return clienteRepository.save(cliente);
    }
    
}
