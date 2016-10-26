<%-- 
    Document   : comments
    Created on : 26 November, 2013, 12:47:47 PM
    Author     : Girjesh
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <title>IES IPS ACADEMY</title>
        <link href="images/IpsLogo.jpg" rel="shortcut icon" type="image/x-icon" />
    </head>
  <body>
         <%
                    response.setHeader("cache-control", "no-cache");
                    response.setHeader("cache-control", "no-store");
                   if ((String) session.getAttribute("Username") == null) {
                        response.sendRedirect("index.jsp");
                    }
        
        %>
        <div  style=" margin-left:auto; margin-right:auto; width:1055px;">
        <%@include file="header.html" %>
        </div>
        <h1>  <&nbsp;> </h1>
        <div  style=" margin-left:auto; margin-right:auto; width:1055px;">
        <form id="form1" name="form1" method="post" action="FeedbackDataServlet?action=saveComment">
            <h3 style="color:#006699; font-size:23px">Please enter your comments:</h3>
            <textarea NAME="comment"  rows="5" cols="50">
            </textarea>
            <br>
            <INPUT TYPE="submit" VALUE="submit" name="submit"/>
             
        </form>
        </div>
         <h1>&nbsp;</h1>
        <div  style=" margin-left:auto; margin-right:auto; width:1055px;">
            <%@include file="footer.html" %>
        </div>
    </body>
</html>

