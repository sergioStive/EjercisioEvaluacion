/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author user
 */
public class UsuariosDTO {
    
    private int idUser;
    private String Nombres;
    private String Email;
    private String userName;
    private String Pass;

    @Override
    public String toString() {
        return "UsuariosDTO{" + "idUser=" + idUser + ", Nombres=" + Nombres 
                + ", Email=" + Email + ", userName=" + userName + ", Pass=" 
                + Pass + '}';
    }

  
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
    }
    
    
    
}
