/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.bean;

/**
 *
 * @author jpere
 */
public class Contenido {
    private String respuestaNombre;
    private String respuestaNacimiento;
    private String respuestaSueldo;

    public Contenido() {
    }

    public Contenido(String respuestaNombre, String respuestaNacimiento, String respuestaSueldo) {
        this.respuestaNombre = respuestaNombre;
        this.respuestaNacimiento = respuestaNacimiento;
        this.respuestaSueldo = respuestaSueldo;
    }

    public String getRespuestaNombre() {
        return respuestaNombre;
    }

    public void setRespuestaNombre(String respuestaNombre) {
        this.respuestaNombre = respuestaNombre;
    }

    public String getRespuestaNacimiento() {
        return respuestaNacimiento;
    }

    public void setRespuestaNacimiento(String respuestaNacimiento) {
        this.respuestaNacimiento = respuestaNacimiento;
    }

    public String getRespuestaSueldo() {
        return respuestaSueldo;
    }

    public void setRespuestaSueldo(String respuestaSueldo) {
        this.respuestaSueldo = respuestaSueldo;
    }
    
}
