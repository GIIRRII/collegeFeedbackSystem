<%-- 
    Document   : feedbackForm
    Created on : 16-Jan-2014, 16:35:42
    Author     : Girjesh
--%>

<%@page import="com.feedback.bean.LoginCredit"%>
<%@page import="com.feedback.manager.GeneralDataManager"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
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
   <% GeneralDataManager gdm = new GeneralDataManager();
    LoginCredit ud= (LoginCredit)session.getAttribute("userData");
     String deptId= ud.getDeptId();
       ResultSet rs;   %>
    <body>
        <div  style=" margin-left:auto; margin-right:auto; width:1055px;">
        <%@include file="header.html" %>
        &nbsp;
        <div style="float: right; margin-top:20px; clear : both">
            <%@include file="homeButton.jsp" %> &nbsp;
         <a href="logout.jsp" style="font-size:24px; color:#006699;text-decoration: none;">LogOut</a><br>
        </div>
         <br> &nbsp;
         <div style="width:400px;position: relative; clear:both; margin-left: auto; margin-right: auto; margin-top: 40px;">
        <form id="form1" name="form1" method="post" action="FeedbackFormServlet">
            <fieldset>  
                <legend style="color:#006699;font-size: 20px " align="center">Select Options </legend>
                 <%   if(deptId== null)
                   {%>
                   <div style="position:relative; float: left;width: 180px; margin-top: 40px;">
                       <font style="color:#006699;font-size: 20px">Select Department</font>
                   </div>
                   <div style="position:relative; float: right;width: 220px; margin-top: 40px;">
                 <select name="deptId" id="deptId" style="width:220px;">
                        <% rs= gdm.getDepartment();
                            while (rs.next()) {
                                %>
                            <option value="<%= rs.getString(1) %>"> <%= rs.getString(2) %> </option>
                             <%}
                              %>
                        </select>
                   </div>&nbsp;
                 
               <%}%>
               <br>
              <div style="float: left;width: 180px; clear: both;">
                  <font style="position:relative;color:#006699; font-size: 20px; float: left">Passout Batch</font> </div>
                  <div style="position:relative; float: right;width: 220px;">
                <select name="batch" id="year" style="width:220px;">
                           <%
                        rs= gdm.getBatch();
                        while (rs.next()) {
                            String s = rs.getString(1);%>
                        <option value="<%=s%>"> <%=s%> </option>
                  <%
                        }%>
                        </select>
                  </div>&nbsp;
                        <br>
                        <div style="position:relative; float: left;width: 180px; clear: both;">
                     <font style="color:#006699;font-size: 20px">Select Semester</font>
                        </div>
                        <div style="position:relative; float: right;width: 220px;">
                    <select name="semId" id="semId" style="width:220px;">
                            
                        <% rs= gdm.getSemester();
                           while (rs.next()) {
                        %>
                        <option value="<%= rs.getString(1) %>"> <%= rs.getString(2) %> </option>
                  <%
                        }%>
                        </select>
                        </div>&nbsp;
                        <br>
                        <div style="position:relative; float: left;width: 180px; clear : both;">
                            <font style="color:#006699;font-size: 20px;">Select Section</font> </div>
                            <div style="position:relative; float: right;width: 220px;">
                                <select name="section" id="section" style="width:220px;">
                            
                        <% rs= gdm.getSection();
                        while (rs.next()) {
                            String s = rs.getString(1);
                         %>
                        <option value="<%= s%>"> <%= s%> </option>
                  <%
                        }%>
                        </select>
                            </div>
                        <br> &nbsp; <br> &nbsp; <br> &nbsp;
                        <div style="position:relative;width: 400px; " align="center">
                            <input type="submit" name="action" id="generateFeedback" value="generate" align="center" />  
                        </div>             
            </fieldset>
   
            </form>
         </div>
            </div>
                 <h1>&nbsp;</h1>
        <div  style=" margin-left:auto; margin-right:auto; width:1055px;">
            <%@include file="footer.html" %>
        </div>
    </body>
</html>
