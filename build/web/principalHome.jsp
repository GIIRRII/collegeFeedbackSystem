<%-- 
    Document   : principalHome
    Created on : 11-Jan-2014, 00:07:06
    Author     : Girjesh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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

                response.setHeader("cache-control", "no-cache");
                response.setHeader("cache-control", "no-store");
        %>
        <div  style=" margin-left:auto; margin-right:auto; width:1055px;">
        <%@include file="header.html" %>
        </div>
        <h2>&nbsp;</h2>
        <center>
            <div>
            <h1 style="color:#006699">Head Activities</h1>
            </div>
        </center>
        <div  style=" margin-left:auto; margin-right:auto; width:1055px;">
            <div style="float: left;">     
                <a href="changePassword.jsp" style="color:#006699;text-decoration: none;font-size: 22px">Change Password</a>
                <a href="modifyDepartment.jsp" style="color:#006699;text-decoration: none;font-size: 22px"> Department</a>
                <a href="feedbackReportFilter.jsp" style="color:#006699;text-decoration: none;font-size: 22px">Generate Feedback Report</a>
                <a href="selectFeedbackToClear.jsp" style="color:#006699;text-decoration: none;font-size: 22px">Clear Feedback</a>
                   
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
