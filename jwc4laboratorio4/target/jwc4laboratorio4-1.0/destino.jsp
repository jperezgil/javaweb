<%-- 
    Document   : destino
    Created on : 22 jul. 2023, 17:22:11
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
        <h3 style="text-align: center">
            El usuario inicial es: <%=request.getParameter("user") %>   <br>
            El usuario final es:  ${userFinal} <br>
        </h3>
        <p style="text-align: center">
            <a href="index.html">regresar</a>
        </p>
    </body>
</html>
