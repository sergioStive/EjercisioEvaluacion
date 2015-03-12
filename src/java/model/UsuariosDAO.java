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
            pstmt.setString(2, newPersona.getEmail());
            pstmt.setString(3, newPersona.getNombres());
            pstmt.setString(4, newPersona.getPass());
            pstmt.setString(5, newPersona.getUserName());

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

    public int validarUsuario(int iduser) throws SQLException {
       
       int y = 1;
       
       try {

           UsuariosDTO pde = new UsuariosDTO();        
        
           
           String sql = "select iduser from usuarios where iduser = ?";        
           pstmt = cnn.prepareStatement(sql);           
           pstmt.setInt(1, iduser);           
           rs = pstmt.executeQuery();
           
          
           if (rs != null) {
               
               while (rs.next()) {

                   pde.setIdUser(rs.getInt("iduser"));
                  
                 }
               y = pde.getIdUser();
           }
           else {
               y = 0;
           }
       
       
       } catch (SQLException ex) {

          
           
           
       }
return y;
   }  
 
    public int getCantidadPrestamos(String idUser){
        int retorno = 0;
        try{
            pstmt = cnn.prepareStatement("Select Count(1) Cantidad From usuarios u inner Join prestamos p ON u.iduser = p.userId Where u.userName = ? ;");
            pstmt.setString(1, idUser);
            pstmt.executeQuery();

            rs = pstmt.executeQuery();
            
            while (rs.next()) {
                retorno = rs.getInt("Cantidad");
            }
            
        }catch(SQLException ex){
            retorno=0;
        }finally{
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
    
}
