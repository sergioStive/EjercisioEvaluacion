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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class UsuariosDAO {

    private Connection cnn = null;
    private PreparedStatement pstmt;
    ResultSet rs = null;
    String msgSalida;
    int per;

    public UsuariosDAO() {
        cnn = Conexion.getInstance();
    }

    public String InsertarUsuarios(UsuariosDTO newPersona) throws SQLException {
        String salida = "";
        try {

            int resultado = 0;
            pstmt = cnn.prepareStatement("INSERT INTO usuarios VALUES ( ?, ?, ?, ?, ?)");
            pstmt.setInt(1, newPersona.getIdUser());
            pstmt.setString(2, newPersona.getUserName());
            pstmt.setString(3, newPersona.getEmail());
            pstmt.setString(4, newPersona.getNombres());
            pstmt.setString(5, newPersona.getPass());

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
                Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex); // se deja por defecto en este caso
            }
        }

        return salida;

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

    public UsuariosDTO ListarUnaPersona(String userName) throws SQLException {
        UsuariosDTO Rdao = null;
        try {
            pstmt = cnn.prepareStatement("select idUser, email, NombreCompleto, pass, "
                    + " userName from usuarios where iduser=?;");
            pstmt.setString(1, userName);
            pstmt.executeQuery();

            rs = pstmt.executeQuery();

            while (rs.next()) {
                Rdao = new UsuariosDTO();
                Rdao.setIdUser(rs.getInt("iduser"));
                Rdao.setEmail(rs.getString("email"));
                Rdao.setNombres(rs.getString("NombreCompleto"));
                Rdao.setPass(rs.getString("pass"));
                Rdao.setUserName(rs.getString("userName"));

            }
        } catch (SQLException ex) {
            msgSalida = "Error " + ex.getMessage() + "Codigo de error" + ex.getErrorCode();
        }
        return Rdao;
    }

    public String validarUsuario(String pass) throws SQLException {

        String y = "";

        try {

            UsuariosDTO pde = new UsuariosDTO();

            String sql = "select pass from usuarios where pass =?";
            pstmt = cnn.prepareStatement(sql);
            pstmt.setString(1, pass);
            rs = pstmt.executeQuery();

            if (rs != null) {

                while (rs.next()) {

                    pde.setPass(rs.getString("pass"));

                }
                y = pde.getPass();
            } else {
                y = "";
            }

        } catch (SQLException ex) {

        }
        return y;
    }

    public boolean listarMultas(long id) throws SQLException {
        boolean multado = false;

        try {
            pstmt = cnn.prepareStatement("select usuario.userid, usuarios.NombreCompleto, usuarios.pass , usuarios.email,usuarios.userName"
                    + "from usuarios join prestamos on usuarios.iduser = prestamos.userid join multas on prestamos.idprestamo = multas.prestamoid"
                    + "where multas.estado=0 and prestamos.userId = ?;");

            pstmt.setLong(1, id);

            rs = pstmt.executeQuery();
            if (rs != null) {
                multado = true;

            }
        } catch (SQLException ex) {
            msgSalida = "ha Ocurrido un error " + ex.getMessage();
        }

        return multado;
    }

    public List<UsuariosDTO> listarTodo() {
        ArrayList<UsuariosDTO> usu = new ArrayList();
        try {
            pstmt = cnn.prepareStatement("select * from Usuarios");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                UsuariosDTO u = new UsuariosDTO();
                u.setIdUser(rs.getInt("iduser"));
                u.setNombres(rs.getString("NombresCompleto"));
                u.setEmail(rs.getString("email"));
                u.setUserName(rs.getString("userName"));
                u.setPass(rs.getString("pass"));
                usu.add(u);
            }
        } catch (SQLException ex) {
            msgSalida = "Ha ocurrido un error" + ex.getMessage();

        }
        return usu;
    }
}
