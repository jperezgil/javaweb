<%-- 
    Document   : resultado
    Created on : 22 jul. 2023, 16:17:33
    Author     : jpere
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p><b>Request:</b>${obj_request}</p>
        <p><b>Sesion:</b>${ob_session}</p>
        <p><b>Aplicacion:</b>${obj_application}</p>
        <p><b>Parametro de otra pagina:</b><%= (request.getParameter("nombre")==null)?"":request.getParameter("nombre") %></p>
        <a href="resultado.jsp">Volver a llamar</a>
    </body>
</html>
