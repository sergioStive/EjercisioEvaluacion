<%-- 
    Document   : prestamos
    Created on : 11/03/2015, 08:18:11 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Prestamos Libros</title>
    </head>
    <body>
        <h1>Registre su Prestamo</h1>
        <form action="Index" method="get">
           <label>UserID</label>
           <input type="text" name="userId" />
           <label>IDLibro</label>
           <input type="text" name="libroid" >
           <label>Fecha</label>
           <input type="date" name="fecha">
           <input type="submit" value="Hacer Prestamo"  name="registro"/>
        </form>
        
        
        
    </body>
</html>
