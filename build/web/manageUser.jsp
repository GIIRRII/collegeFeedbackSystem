<%-- 
    Document   : manageUser
    Created on : 20-Feb-2014, 09:31:55
    Author     : Girjesh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%  response.setHeader("cache-control", "no-cache");
                    response.setHeader("cache-control", "no-store");
                    String uname = (String) session.getAttribute("Username");
                    if (uname == null) {
                        response.sendRedirect("index.jsp");
                    }

        %>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
