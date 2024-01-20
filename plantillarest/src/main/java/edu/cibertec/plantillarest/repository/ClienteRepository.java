/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.cibertec.plantillarest.repository;

import edu.cibertec.plantillarest.bean.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author jpere
 */
public interface ClienteRepository  extends JpaRepository<Cliente, Integer>{    
    // Método personalizado para buscar un cliente por su ID utilizando una consulta SQL
    @Query(value = "SELECT * FROM cliente WHERE idcliente = :idcliente", nativeQuery = true)
    Cliente ObtenerCliente(@Param("idcliente") Integer idcliente);
}
