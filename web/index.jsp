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
        <h1>REGISTRO DE PRESTAMOS</h1>

        <form action="ControladorUsuarios" >
            
            <label>Contraseña</label> 
            
            <input type="password" name="pass" value="pass"/>
            <input type="submit" value="Ingresar" name="ingresar" />
            <br>
            <%
if(request.getParameter("no") != null  ) {
%>
<div>
<b div clas="valido"> sus datos no son validos. <a href="registro.jsp"> Registrese</a></b>
</div>
<%
}
%>
</form>

 

    </body>
</html>
