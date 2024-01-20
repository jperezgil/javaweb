/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package edu.cibertec.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jpere
 */
@WebServlet(name = "LlamadaController", urlPatterns = {"/Llamada"})
public class LlamadaController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       Integer tipo = Integer.parseInt(request.getParameter("tipo"));
       String user = request.getParameter("user");
       request.setAttribute("userFinal", user+"->"+tipo);
        switch (tipo) {
            case 1:
                //RequestDispatcher despachador = request.getRequestDispatcher("destino.jsp");
                RequestDispatcher despachador1 = getServletContext().getRequestDispatcher("/destino.jsp");
                despachador1.forward(request, response);
            break;
            case 2:
                //AGREGAMOS INFORMACION A LA RESPUESTA
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();
                out.print("<p style=\"text-align: center\">");
                out.print("***********<br/>");
                out.print("*"+user+"*<br/>");
                out.print("***********<br/>");
                out.print("</p>");
                RequestDispatcher despachador2 = getServletContext().getRequestDispatcher("/destino.jsp");
                despachador2.include(request, response);
            break;
            case 3:
               response.sendRedirect("destino.jsp");
            break;
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
