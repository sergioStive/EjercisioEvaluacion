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
    
    public String Insertarlibro(librosDTO newPersona) throws SQLException {
        String salida = "";
        try {

            int resultado = 0;
            pstmt = cnn.prepareStatement("INSERT INTO libros VALUES ( ?, ?, ?, ?)");
           
            pstmt.setInt(1 , newPersona.getIdLibro());
            pstmt.setString(2, newPersona.getIsbm());
            pstmt.setString(3, newPersona.getTitulo());
            pstmt.setString(4, newPersona.getEstadolibro());
            

            resultado = pstmt.executeUpdate();

            if (resultado != 0) {
                salida = "El libro se Registro Existosamente ";
            } else {
                // salida = "Ha ocurrido un problema al crear el profesor. Contacte al administrador";

            }
        } catch (SQLException sqle) {
            salida = "Ocurrió la siguiente exception : " + sqle.getMessage();
        } finally {
            try {
                pstmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex); // se deja por defecto en este caso
            }
        }

        return salida;

    }
    
    
}
