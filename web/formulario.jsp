<%-- 
    Document   : formulario
    Created on : 06/04/2016, 14:05:05
    Author     : Administrador
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form name="form1" method="post" action="relatoriodependencia.jsp">
      <table width="487" align="center">
        <tr>
          <td colspan="2" align="center"><strong>RELATORIO POR DEPENDENCIA </strong></td>
        </tr>
        <tr>
          <td width="168">DEPENDENCIA:</td>
          <td width="415"><label for="txtdependencia"></label>
          <input type="text" name="txtdependencia" id="txtdependencia"></td>
        </tr>
        <tr>
          <td><input type="submit" name="button" id="button" value="Generar Reporte"></td>
        </tr>
      </table>
    </form>
    </body>
</html>
