/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.UsuariosDAO;
import model.UsuariosDTO;

/**
 *
 * @author user
 */
@WebServlet(name = "ControladorUsuarios", urlPatterns = {"/ControladorUsuarios"})
public class ControladorUsuarios extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

         if (request.getParameter("registro") != null) {

            UsuariosDTO pdto = new UsuariosDTO();
            UsuariosDAO pdao = new UsuariosDAO();
            
           
            pdto.setUserName(request.getParameter("name"));
            pdto.setNombres(request.getParameter("nombres"));
            pdto.setEmail(request.getParameter("email"));
            pdto.setPass(request.getParameter("pas"));
            
            
           
  
            
            String mensaje = pdao.InsertarUsuarios(pdto);
            HttpSession misesion = request.getSession(true);
            misesion.setAttribute("logueado", pdto);
            response.sendRedirect("index.jsp?msg="+mensaje);
        }
    
         else if(request.getParameter("ingresar") != null){
            UsuariosDTO pdto = new UsuariosDTO();
            UsuariosDAO pdao = new UsuariosDAO();
            
          
        String va= pdao.validarUsuario(request.getParameter("pass"));
        if(va ==""){
            
               response.sendRedirect("index.jsp?no="+ va);
            }
           
            else if(va !=""){
                response.sendRedirect("prestamos.jsp");
            }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ControladorUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ControladorUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
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
