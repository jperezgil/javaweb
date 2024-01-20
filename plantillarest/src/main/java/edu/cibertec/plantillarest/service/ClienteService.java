/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.plantillarest.service;

import edu.cibertec.plantillarest.bean.Cliente;
import java.util.List;

/**
 *
 * @author jpere
 */
public interface ClienteService {
    public List<Cliente> listarCliente();
    public Cliente ObtenerCliente (Integer idcliente);
    public Cliente insertarCliente (Cliente cliente);
    public Cliente actualizarCliente (Cliente cliente);
    public Cliente eliminarCliente (Integer idcliente);
}
