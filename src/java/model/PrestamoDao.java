/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controlador.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author PrestamoDao
 * @author Rodrigo Aranda Fernandez
 */
public class PrestamoDao {

    private Connection cnn = null;

    private PreparedStatement pstmt;

    public String registrarPrestamo(PrestamoDto p, Connection cnn) throws SQLException {

        this.cnn = cnn;
        String msgSalida;   // almacena el msg de salida al usuario
        int rtdo;   // almacena el resultado de la ejecución en la BD
        pstmt = cnn.prepareStatement("INSERT INTO prestamos VALUES (NULL, ?,?, 1) ");

        pstmt.setInt(1, p.getIdUsuario());
        pstmt.setInt(2, p.getIdLibro());

        rtdo = pstmt.executeUpdate();
        if (rtdo > 0) {
            msgSalida = "se modificaron (" + rtdo + ") registros";
        } else {
            msgSalida = "NO se pudo actualizar el registro";
        }

        return msgSalida;
    }
    
    
    public String registrarModificar(PrestamoDto p, Connection cnn) throws SQLException {

        this.cnn = cnn;
        String msgSalida;   // almacena el msg de salida al usuario
        int rtdo;   // almacena el resultado de la ejecución en la BD
        pstmt = cnn.prepareStatement("UPDATE prestamos SET userId = ?, libroId=? estado =  where idprestamo = ?  bbv                                                                ");

        pstmt.setInt(1, p.getIdUsuario());
        pstmt.setInt(2, p.getIdLibro());
        pstmt.setInt(3, p.getIdPrestamo());
        

        rtdo = pstmt.executeUpdate();
        if (rtdo > 0) {
            msgSalida = "se modificaron (" + rtdo + ") registros";
        } else {
            msgSalida = "NO se pudo actualizar el registro";
        }

        return msgSalida;
    }
    
}
