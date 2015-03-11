/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import model.PrestamoDao;
import model.PrestamoDto;

/**
 *
 * @author admin
 */
public class Conectar extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /*
             * TODO output your page here. You may use following sample code.
             */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Conectar</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Conectar at " + request.getContextPath() + "</h1>");
            out.println("<h1>Resultado de la conexión " + getConnection() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    public static String getConnection() {
        Connection cnn = null;
        String salida = "inicio";
        Context ctx;
        try {
            ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("jdbc/cnnPrestamosDatasource");
            cnn = ds.getConnection();
            if (cnn != null) {

                PrestamoDao pdao = new PrestamoDao();
                PrestamoDto pdto = new PrestamoDto();
                pdto.setIdUsuario(3);
                pdto.setIdLibro(1);
                salida = pdao.registrarPrestamo(pdto, cnn);

            } else {
                salida = "LO siento hay un error";
            }
        } catch (NamingException ex) {
            salida += ex.getMessage();
        } catch (SQLException sqle) {
            salida += sqle.getMessage();
        }
        return salida;


    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
