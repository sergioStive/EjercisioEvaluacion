<%--
    Document   : index
    Created on : 10-mar-2015, 21:44:04
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel ="stylesheet" type="text/css" href="dist/css/bootstrap.css">
        <title>Gestión de Prestamos </title>
    </head>
    <body>

        
        
        <form name="form1" action="ControladorUsuarios" method="post" id="form1"> 

                <table width="744" align="center">

                    <div class="ba">
                        <h1><center>Registro de Usuarios</center></h1>
                    </div>
              
                    <tr>

                        <td><label for="cor" class="labele"><strong>UserName<font color="#FF0000">*</strong></label></font></td>
                        <td><input name="name" type="text" style="width:250px; height:25px " autofocus id="cor" placeholder="UserName">
                        </td>
                        <td><label for="nombres" class="labele"><strong>Nombres<font color="#FF0000">*</strong></label></font></td>
                        <td><input name="nombres" type="text" style="width:250px; height:25px" autofocus id="nombres" placeholder="Nombres">
                        </td>
                    </tr>
                    <tr>
                        <td><label for="apellidos" class="labele"><strong>Email<font color="#FF0000">*</strong></label></font></td>
                        <td><input name="email" type="email" style="width:250px; height:30px" autofocus id="apellidos"></td>
                    </tr>
                    <tr>
                        <td><label for="date" class="labele"><strong>Contraseña<font color="#FF0000">*</strong></label></font></td>
                        <td><input name="pas" type="password" id="date" style="width:250px; height:25px" placeholder="Contraseña"></td>   
                        
                    </tr>    
                    
                    <tr>
                        <td><input type="submit" name="registro"  id="registro" value="Registrar">


                    </tr>
                </table>

                </fieldset>
            </form>
    </body>
</html>
