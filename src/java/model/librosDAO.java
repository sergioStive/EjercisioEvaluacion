/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controlador.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class librosDAO {
    
    private Connection cnn = null;
    private PreparedStatement pstmt;
    ResultSet rs = null;
    String msgSalida;
    int per;
    
    
    public librosDAO() {
        cnn = Conexion.getInstance();
}
    
    public String crearLibro(librosDTO newLinea){
       String salida = "";
       try {

           int resultado = 0;
           pstmt = cnn.prepareStatement("INSERT INTO libros VALUES ( ?, ?, ?, ?)");
           pstmt.setLong(1, newLinea.getIdLibro());
           pstmt.setString(2, newLinea.getIsbm());
           pstmt.setString(3, newLinea.getTitulo());
           pstmt.setInt(4, newLinea.getEstadolibro());
         
           resultado = pstmt.executeUpdate();

           if (resultado != 0) {
               salida = "su linea ha sido registrada. ";
           } else {            
               
           }
       } catch (SQLException sqle) {
           salida = "Ocurrió la siguiente exception : " + sqle.getMessage();
       } finally {
           try {
               pstmt.close();
           } catch (SQLException ex) {
               Logger.getLogger(librosDAO.class.getName()).log(Level.SEVERE, null, ex);
           }
       }

       return salida;

   }
    
    
}
