<%-- 
    Document   : registroLibro
    Created on : 11/03/2015, 10:01:01 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form name="form1" action="Registrolibros" method="post" id="form1"> 

                <table width="744" align="center">

                    <div class="ba">
                        <h1><center>Registro de Libros</center></h1>
                    </div>
              
                    <tr>
                        <td><label for="cor" class="labele"><strong>Editorial Isbm<font color="#FF0000">*</strong></label></font></td>
                        <td><input name="cor" type="text" style="width:250px; height:25px " autofocus id="cor" placeholder="editorial">
                        </td>
                        <td><label for="date" class="labele"><strong>Titulo<font color="#FF0000">*</strong></label></font></td>
                        <td><input name="date" type="text" style="width:250px; height:25px" autofocus id="date" placeholder="Titulo del libro">
                        </td>
                    </tr>
                    <tr>
                        <td><label for="nombres" class="labele"><strong>Estado libros<font color="#FF0000">* </strong></label></font>
                            <select name="nombres">
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                            </select>
                        </td>
                    </tr>
                     <tr>
                        <td><input type="submit" name="registro"  id="registro" value="Registrar">


                    </tr>
                    </table> 
            
            </form>
    </body>
</html>
