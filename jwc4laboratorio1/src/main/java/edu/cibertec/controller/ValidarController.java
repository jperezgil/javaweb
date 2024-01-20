/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package edu.cibertec.controller;

import com.google.gson.Gson;
import edu.cibertec.bean.Contenido;
import edu.cibertec.bean.Respuesta;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jpere
 */
@WebServlet(name = "ValidarController", urlPatterns = {"/Validar"})
public class ValidarController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequestGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //VARMOS A RECIBIR LOS DATOS
        String nombre = request.getParameter("nombre");
        String nacimiento = request.getParameter("nacimiento");
        String sueldo = request.getParameter("sueldo");
        Respuesta respuesta= new Respuesta();
        respuesta.setRespuesta("OK");
        Contenido contenido = new Contenido();        
        contenido.setRespuestaNombre("");
        contenido.setRespuestaNacimiento("");
        contenido.setRespuestaSueldo("");
        respuesta.setContenido(contenido);
        try {
            //VALIDACION DE LOS DATOS           
            if (nombre.trim().length() > 0) {
                respuesta.getContenido().setRespuestaNombre(nombre+"(OK)");
            } else {
                respuesta.getContenido().setRespuestaNombre("NO INGRESADO!");
            }
            
            if (nacimiento.trim().length() > 0) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                sdf.setLenient(false);
                try {
                    Date fecha = sdf.parse(nacimiento);
                    respuesta.getContenido().setRespuestaNacimiento(nacimiento+"(OK)");
                } catch (Exception ex) {
                   respuesta.getContenido().setRespuestaNacimiento("ERRADO!");
                }
            } else {
                respuesta.getContenido().setRespuestaNacimiento("NO INGRESADO!");
            }            
           
            if (sueldo.trim().length() > 0) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                sdf.setLenient(false);
                try {
                    Double sueldoDouble = Double.valueOf(sueldo);
                    respuesta.getContenido().setRespuestaSueldo(sueldo+"(OK)");
                } catch (Exception ex) {
                   respuesta.getContenido().setRespuestaSueldo("ERRADO!");
                }
            } else {
                respuesta.getContenido().setRespuestaSueldo("NO INGRESADO!");
            }
            
        } catch (Exception ex) {
            respuesta.setRespuesta("OCURRIO UN ERROR");
        }

        //DEVOLVIENDO UNA RESPUESTA JSON
        response.setContentType("text/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //String json = "{\"respuesta\":\""+respuesta+"\",\"contenido\":{\"respuestaNombre\":\""+respuestaNombre+"\",\"respuestaNacimiento\":\""+respuestaNacimiento+"\",\"respuestaSueldo\":\""+respuestaSueldo+"\" }}";
        String json = new Gson().toJson(respuesta);
        out.print(json);

    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequestPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ValidarController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ValidarController at " + request.getContextPath() + " desde un post</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequestGet(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequestPost(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
