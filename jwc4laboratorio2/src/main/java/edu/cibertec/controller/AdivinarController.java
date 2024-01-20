/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package edu.cibertec.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jpere
 */
@WebServlet(name = "AdivinarController", urlPatterns = {"/Adivinar"}, initParams = {
    @WebInitParam(name = "rptCorrecta", value = "C")})
public class AdivinarController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private String rptaCorrecta;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //LEER LOS PARAMETRO DE ENTRADA
        String listaRpta[] = request.getParameterValues("chkRpta");
        String mensaje = "No adivinó la respuesta";
        //PROCESAR LA INFORMACION
        for(String rpta: listaRpta){
            if(rpta.equals(rptaCorrecta)){
                mensaje="Felicitaciones!!";
            }
        }
        //DEVOLVIENDO UNA RESPUESTA HTML
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>ADIVINANZA</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>"+mensaje+"</h1>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
      rptaCorrecta = config.getInitParameter("rptCorrecta");
      ServletContext ctx = config.getServletContext();
      ctx.setAttribute("valor", "DATO VALIDO");
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
        processRequest(request, response);
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
        processRequest(request, response);
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
