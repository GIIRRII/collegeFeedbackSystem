<%-- 
    Document   : logout
    Created on : 04-Mar-2014, 11:12:58
    Author     : Girjesh
--%>

     <%
     session.removeAttribute("Username");
     session.invalidate();
     response.sendRedirect("index.jsp");

     %>
    