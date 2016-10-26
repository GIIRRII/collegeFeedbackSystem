<%-- 
    Document   : viewComment
    Created on : 02-Feb-2014, 12:07:55
    Author     : Girjesh
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%  response.setHeader("cache-control", "no-cache");
                    response.setHeader("cache-control", "no-store");
                    String uname = (String) session.getAttribute("Username");
                    if (uname == null) {
                        response.sendRedirect("index.jsp");
                    }

        %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IES IPS ACADEMY</title>
        <link href="images/IpsLogo.jpg" rel="shortcut icon" type="image/x-icon" />
    </head>
    <% ArrayList<String> list = (ArrayList<String>) session.getAttribute("comments");
    
    %>
    <jsp:useBean id="fb" class="com.feedback.bean.Feedback" scope="session"></jsp:useBean>
    <body>
        <div  style=" margin-left:auto; margin-right:auto; width:1055px;">
        <%@include file="header.html" %>
        </div>
        <div  style=" margin-left:auto; margin-right:auto; width:1055px;">
            <div style="float: right;">
            <%@include file="homeButton.jsp" %> &nbsp;
         <a href="logout.jsp" style="font-size:24px; color:#006699;text-decoration: none;">LogOut</a><br>
        </div>
         <form id="form1" name="form1" method="post" action="">`
  <table width="1016" border="1" >
    <tr>
      <td width="1006"><div align="center">
              <h2 style="color:#006699">Comments By Student of <jsp:getProperty name="fb" property="semId"></jsp:getProperty> of batch <%= fb.getYear()%> department <%=fb.getDeptId()%></h2>
      </div></td>
    </tr><%
     for (String s : list) {
                %>
    <tr>
      <h3 style="background: #FFFFFF"> <td><%=s%></td></h3>
      
    </tr>
    <%
     }
     %>
  </table>
   <label><a href="Head.jsp" style="font-size: 20px; color:#006699">Home</a></label><br>

   <br>
    <input type="button" value="Print" onclick="window.print();return false;"
</form>
        </div> 
   <h1>&nbsp;</h1>
        <div  style=" margin-left:auto; margin-right:auto; width:1055px;">
            <%@include file="footer.html" %>
        </div>
       
    </body>
</html>
