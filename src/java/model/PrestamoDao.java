/*
 * To change this template, choose Tools | Templates
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
 * @author PrestamoDao
 * @author Rodrigo Aranda Fernandez
 */
public class PrestamoDao {

    private Connection cnn = null;
    private PreparedStatement pstmt;
    ResultSet rs = null;
    String msgSalida;
    int per;
    
    
    public PrestamoDao() {
        cnn = Conexion.getInstance();
    }

    public String InsertarPrestamo(PrestamoDto newLinea) throws SQLException {
        String salida = "";
        try {

           int resultado = 0;
            pstmt = cnn.prepareStatement("INSERT INTO prestamos VALUES (?,?,?,?,?)");

            pstmt.setInt(1, newLinea.getIdPrestamo());
            pstmt.setInt(2, newLinea.getIdUsuario());
            pstmt.setInt(3, newLinea.getIdLibro());
            pstmt.setInt(4, newLinea.getEstado());
            pstmt.setString(5, newLinea.getFechaEntrega());

            resultado = pstmt.executeUpdate();
            if (resultado != 0) {
                salida = "El usuario a sido registrado exitosamente. ";
            } else {
                // salida = "Ha ocurrido un problema al crear el profesor. Contacte al administrador";

            }
        } catch (SQLException sqle) {
            salida = "Ocurrió la siguiente exception : " + sqle.getMessage();
        } finally {
            try {
                pstmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(PrestamoDao.class.getName()).log(Level.SEVERE, null, ex); // se deja por defecto en este caso
            }
        }

        return salida;

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

    public int getCantidadPrestamos(String idUser) {
        int retorno = 0;
        try {
            pstmt = cnn.prepareStatement("Select Count(1) Cantidad From usuarios u inner Join prestamos p ON u.iduser = p.userId Where u.userName = ? ;");
            pstmt.setString(1, idUser);
            pstmt.executeQuery();

            rs = pstmt.executeQuery();

            while (rs.next()) {
                retorno = rs.getInt("Cantidad");
            }

        } catch (SQLException ex) {
            retorno = 0;
        } finally {
            return retorno;
        }
    }

    public int ContarPrestamos(long id) {
        int cantidad = 0;
        try {
            pstmt = cnn.prepareStatement("select count(prestamos.userid) as cantidad from prestamos where userId=?;");
            pstmt.setLong(1, id);
            pstmt.executeQuery();
            while (rs.next()) {
                cantidad = rs.getInt("cantidad");
            }
        } catch (SQLException ex) {
            msgSalida = "Ha ocurrido un error " + ex.getMessage();
        }
        return cantidad;

    }

}
