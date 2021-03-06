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
import model.PrestamoDao;
import model.PrestamoDto;
import model.UsuariosDAO;
import model.UsuariosDTO;

/**
 *
 * @author user
 */
@WebServlet(name = "Index", urlPatterns = {"/Index"})
public class Index extends HttpServlet {

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
        try{
        response.setContentType("text/html;charset=UTF-8");
        UsuariosDTO ususa = new UsuariosDTO();
        UsuariosDAO usuass = new UsuariosDAO();
        PrestamoDao usua = new PrestamoDao(); 
        PrestamoDto usuat = null;
        int nrPrestamos;
        ususa = usuass.ListarUnaPersona("cor");
        nrPrestamos = usuass.getCantidadPrestamos("cor");
        if( usuat != null && nrPrestamos < 2){
            response.sendRedirect("prestamos.jsp");
        }else if(nrPrestamos == 2) {
            response.sendRedirect("Index.jsp?msj=el usuario tiene dos prestamos no es posible realizarlo");
        }else{
            response.sendRedirect("RegistroUsuario.jsp");
        }
        } catch (SQLException ex) {
        }
    
       if (request.getParameter("registro") != null) {

            PrestamoDto pdto = new PrestamoDto();
            PrestamoDao pdao = new PrestamoDao();
            
            pdto.setIdUsuario(Integer.parseInt(request.getParameter("userId")));
            pdto.setIdLibro(Integer.parseInt(request.getParameter("libroid")));
            pdto.setFechaEntrega(request.getParameter("fecha"));
            pdto.setEstado(1);
            String mensaje = pdao.InsertarPrestamo(pdto);
            
            response.sendRedirect("prestamos.jsp?msg="+mensaje);
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
            Logger.getLogger(Index.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Index.class.getName()).log(Level.SEVERE, null, ex);
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
    