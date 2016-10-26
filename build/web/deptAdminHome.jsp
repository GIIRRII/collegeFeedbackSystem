<%-- 
    Document   : deptAdminHome
    Created on : 11-Jan-2014, 00:09:25
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
        &nbsp; <br>
         <div  style=" margin-left:auto; margin-right:auto; width:1055px; margin-top: 20px; clear :both">
              <div style="float: right; ">
            <%@include file="homeButton.jsp" %> &nbsp;
         <a href="logout.jsp" style="font-size:24px; color:#006699;text-decoration: none;">LogOut</a><br>
        </div>
             <div style="float: left; clear: both;">
                <form id="form1" name="form1" method="post" action="">
                    <a  href="changePassword.jsp" style="color:#006699; font-size:22px ;text-decoration: none;">Change Password</a> <br>
                    <a href="ModificationDataServlet?action=faculty" style="color:#006699;font-size:22px;text-decoration: none;">Modify Faculty</a><br>
                    <a href="ModificationDataServlet?action=subject" style="color:#006699;font-size:22px;text-decoration: none;">Modify Subject</a><br>                                                  
                    <a href="studentRecordFilter.jsp" style="color:#006699;font-size:22px;text-decoration: none;">Add Student Record</a><br>
                    <a href="studentAttendanceFilter.jsp" style="color:#006699;font-size:22px;text-decoration: none;">Update Student Record </a><br>
                    <a href="feedbackFormToGenerate.jsp?action=generate" style="color:#006699;font-size:22px;text-decoration: none;"> Generate Feedback Form</a><br>
                    <a href="feedbackSubmit.jsp" style="color:#006699;font-size:22px;text-decoration: none;">Feedback Submit</a><br>
                    <a href="feedbackReportFilter.jsp" style="color:#006699;font-size:22px;text-decoration: none;"> Generate Report</a><br>
                </form>
             </div>
           
            </div>
         <h1>&nbsp;</h1>
        <div  style=" margin-left:auto; margin-right:auto; width:1055px; clear: both;">
            <%@include file="footer.html" %>
        </div>
    </body>
</html>
