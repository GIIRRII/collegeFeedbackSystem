<%-- 
    Document   : coordinatorHome
    Created on : 11-Jan-2014, 00:10:03
    Author     : Girjesh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title style="color: #005F9D;">IES IPS ACADEMY</title>
        <link href="images/IpsLogo.jpg" rel="shortcut icon" type="image/x-icon" />
    </head>
    <%  response.setHeader("cache-control", "no-cache");
                    response.setHeader("cache-control", "no-store");
                    String uname = (String) session.getAttribute("Username");
                    if (uname == null) {
                        response.sendRedirect("index.jsp");
                    }

        %>
    <body>
        <div  style=" margin-left:auto; margin-right:auto; width:1055px;">
        <%@include file="header.html" %>
        </div>
        <h1>&nbps;</h1>
        <div  style=" margin-left:auto; margin-right:auto; width:1055px;">
            <div style="float: left;">
                <a href="studentRecordFilter.jsp" style="color:#006699; font-size:22px ;text-decoration-line: none;">Student Enrollment Details</a> <br>
                <a href="StudentAttendanceServlet" style="color:#006699; font-size:22px ;text-decoration-line: none;">Students Attendance</a><br>
                <a href="changePassword.jsp" style="color:#006699; font-size:22px ;text-decoration-line: none;">Change Password</a><br>
            </div>
            <div style="float: right;">
                 <%@include file="homeButton.jsp" %> &nbsp;
                 <a href="logout.jsp" style="font-size:24px; color:#006699;text-decoration: none;">LogOut</a><br>
            </div>
      </div>
      <h1>&nbsp;</h1>
      <div  style=" margin-left:auto; margin-right:auto; width:1055px; clear: both;">
            <%@include file="footer.html" %>
      </div>
    </body>
</html>
