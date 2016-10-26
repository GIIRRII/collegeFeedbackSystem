<%-- 
    Document   : administrationHome
    Created on : 05-Feb-2014, 17:04:54
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
    <%              response.setHeader("cache-control", "no-cache");
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
        <h1> &nbsp; </h1>
        <div  style=" margin-left:auto; margin-right:auto; width:1055px;">
            <div style="margin-left: auto;float: left;">    
                    <a href="changePassword.jsp" style="color:#006699;font-size:22px;text-decoration: none;">Change Password</a> <br>
                    <a href="feedbackReportFilter.jsp" style="color:#006699;font-size:22px;text-decoration: none;"> Generate Report</a><br>
                    <a href="detailsToModify.jsp?action=faculty" style="color:#006699;font-size:22px;text-decoration: none">Manage Faculty</a><br>
                    <a href="detailsToModify.jsp?action=subject" style="color:#006699;font-size:22px;text-decoration: none">Manage Subject</a><br>                                                  
                    <a href="feedbackSubmit.jsp" style="color:#006699;font-size:22px;text-decoration: none">Feedback Submit</a><br>
                    <a href="selectFeedbackToClear.jsp" style="color:#006699;font-size:22px;text-decoration: none">Feedback Clear</a><br>
                    <a href="studentRecordFilter.jsp" style="color:#006699;font-size:22px;text-decoration: none">Add Student Details</a><br>
                    <a href="studentAttendanceFilter.jsp" style="color:#006699;font-size:22px;text-decoration: none"> Student Attendance</a><br>
                    <a href="modifyDepartment.jsp" style="color:#006699;font-size:22px;text-decoration: none">Manage Department</a><br>
                    <a href="selectStudentRecordToClear.jsp" style="color:#006699;font-size:22px;text-decoration: none">Clear student record</a><br>
                    <a href="feedbackFormToGenerate.jsp" style="color: #006699;font-size: 22px;text-decoration: none">Generate Feedback Form</a><br>
                    <a href="manageUser.jsp" style="color:#006699;font-size:22px;text-decoration: none">Manage User</a> <br> 
                    <a href="addYear.jsp" style="color:#006699;font-size:22px;text-decoration: none" >Add Batch</a>
            </div>
        <div style="float: right;">
            <%@include file="homeButton.jsp" %> &nbsp;
         <a href="logout.jsp" style="font-size:24px; color:#006699;text-decoration: none;">LogOut</a><br>
        
        </div>
        </div>
         
         <h1>&nbsp;</h1>
         
        <div  style=" margin-left:auto; margin-right:auto; position: relative; margin-top: auto; width:1055px; clear: both;">
            <%@include file="footer.html" %>
        </div>
    </body>
</html>
