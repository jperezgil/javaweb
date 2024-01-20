/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.plantillarest.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

import java.text.SimpleDateFormat;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author jpere
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "cliente") //Si el nombre de la clase es igual al de la tabla en la base de datos no es necesario usar esta anotacion
public class Cliente {
    @Id
    @Column(name = "idcliente") //Si el nombre del atributo es igual al del atributo de la table en la base de datos no es necesario usar esta anotacion
    private Integer idcliente;
    private String appaterno;
    private String apmaterno;
    private String nombres;
    private Date nacimiento;
    private String direccion;
    private String referencia;
    private String genero;
    private String estado;
    @Transient  
    private String nacimientoTexto; 

    public String getNacimientoTexto(){
        SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
        String fechaFormateada = sf.format(nacimiento);
        return  fechaFormateada;
    }
}
