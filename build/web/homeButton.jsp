<%-- 
    Document   : homeButton
    Created on : 05-Mar-2014, 21:41:36
    Author     : Girjesh
--%>

<%@page import="com.feedback.bean.LoginCredit"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <% LoginCredit lc = (LoginCredit)session.getAttribute("userData");
        String role = lc.getRole();
          if(role.equalsIgnoreCase("departmentAdmin")){
        %>
        <a href="deptAdminHome.jsp" style="font-size:22px; color:#006699;text-decoration: none;">Home</a>
        <%} else if(role.equalsIgnoreCase("coordinator")){%>
        <a href="coordinator.jsp" style="font-size:22px; color:#006699;text-decoration: none;">Home</a>
        <%} else if(role.equalsIgnoreCase("admin")){%>
        <a href="administrationHome.jsp" style="font-size:22px; color:#006699;text-decoration: none;">Home</a>
        <%} else if(role.equalsIgnoreCase("principal")){%> 
        <a href="principalHome.jsp" style="font-size:22px; color:#006699;text-decoration: none;">Home</a>
        <%}%>
    </body>
</html>
