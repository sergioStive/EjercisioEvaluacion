/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;


import controlador.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import model.UsuariosDAO;
import model.UsuariosDTO;
import model.librosDAO;
import model.librosDTO;

/**
 *
 * @author user
 */
public class prueba {
    
     public static void main(String[] args) throws SQLException {
    
     UsuariosDTO usu = new UsuariosDTO();
     UsuariosDAO usua= new UsuariosDAO();
     librosDTO lib = new librosDTO();
     librosDAO libros = new librosDAO();
     Scanner entrada = new Scanner(System.in);
        int respuesta;
        Scanner in = new Scanner(System.in);
        Connection conexion = Conexion.getInstance();
        if (conexion != null) {
            System.out.println("Conectado");
        }
        
        System.out.println("..bienvenidos..");
        System.out.println("(1) Insertar");
        
        respuesta = entrada.nextInt();
        
        
        switch (respuesta) {
        case 1:
                System.out.println("idUser");
                usu.setIdUser(in.nextInt());
                System.out.println("Nombres");
                usu.setNombres(in.next());
                System.out.println("Email");
                usu.setEmail(in.next());
                System.out.println("Contraseña");
                usu.setPass(in.next());
                System.out.println("userName");
                usu.setUserName(in.next());
                System.out.println(usua.InsertarUsuarios(usu));
                break;
        case 2:
                
                
                System.out.println("idlibro");
                lib.setIdLibro(in.nextInt());
                System.out.println("Isbm");
                lib.setIsbm(in.next());
                System.out.println("estado libro");
                lib.setEstadolibro(in.next());
                System.out.println("titulo");
                lib.setTitulo(in.next());
                
                System.out.println(libros.Insertarlibro(lib));
                break;
            
            
}
}
      }