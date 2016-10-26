<%-- 
    Document   : studentRecordFilter
    Created on : 04-Feb-2014, 15:56:04
    Author     : Girjesh
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="com.feedback.bean.LoginCredit"%>
<%@page import="com.feedback.manager.GeneralDataManager"%>
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
        <title style="color: #005F9D;">IES IPS ACADEMY</title>
        <link href="images/IpsLogo.jpg" rel="shortcut icon" type="image/x-icon" />
    </head>
    <% GeneralDataManager gdm = new GeneralDataManager();
    LoginCredit ud= (LoginCredit)session.getAttribute("userData");
     String deptId= ud.getDeptId();
     String type = ud.getRole();
     String action = request.getParameter("action");
       ResultSet rs;   %>
    <body>
        <div  style=" margin-left:auto; margin-right:auto; width:1055px;">
        <%@include file="header.html" %>
        </div>
        <h1>&nbsp;</h1>
        <div  style=" margin-left:auto; margin-right:auto; width:1055px;">
            <div style="float: right;">
            <%@include file="homeButton.jsp" %> &nbsp;
         <a href="logout.jsp" style="font-size:24px; color:#006699;text-decoration: none;">LogOut</a><br>
        </div>
        
           <div style="width:400px;position: relative; clear:both; margin-left: auto; margin-right: auto; margin-top: 40px;">   
        <form id="form1" name="form1" method="post" action="StudentRecordServlet?action=filter">
            <fieldset>
                 <legend style="color:#006699;font-size: 22px " align="center">Select Options </legend>
      
        <%if(type.equalsIgnoreCase("coordinator")){%>
          <div style="position:relative; float: left;width: 180px; margin-top: 40px">
                <font style="color:#006699;font-size: 20px">No of records</font>
          </div>            
            <div style="position:relative; float: right;width: 180px; margin-top: 40px">
                <input type="text" name="noStudent" value="" style="width: 40px;">
            </div>
          
        <%} else {%>
       
           <div style="position:relative; float: left;width: 170px; margin-top: 40px;clear: both;">
                <font style="color:#006699;font-size: 20px">No of records</font>
           </div>            
            <div style="position:relative; float: right;width: 230px; margin-top: 40px">
                <input type="text" name="noStudent" value="" style="width: 210px">
            </div>
          &nbsp;
          <br>
           <%if(deptId==null)
                   {%>
                   <div style="position:relative; float: left;width: 170px;">
                       <font style="color:#006699;font-size: 20px">Select Department</font>
                   </div>
                   <div style="position:relative; float: right;width: 230px; ">
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
              
              <div style="float: left;width: 170px;">
                  <font style="position:relative;color:#006699; font-size: 20px; float: left;">Passout Batch</font>
              </div>
                  <div style="position:relative; float: right;width: 230px;">
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
                        <div style="position:relative; float: left;width: 170px;clear: both;">
                     <font style="color:#006699;font-size: 20px; ">Select Semester</font>
                        </div>
                        <div style="position:relative; float: right;width: 230px;">
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
                        <div style="position:relative; float: left; width: 170px;clear: both;">
                            <font style="color:#006699;font-size: 20px;">Select Section</font> 
                        </div>
                         <div style="position:relative; float: right;width: 230px;">
                                <select name="section" id="section" style="width:220px;">
                            
                        <% rs= gdm.getSection();
                        while (rs.next()) {
                            String s = rs.getString(1);
                         %>
                        <option value="<%= s%>"> <%= s%> </option>
                  <%
                                      }   }%>
                        </select>
                            </div>
                        <br> &nbsp; <br> &nbsp; <br> &nbsp;
                        <div style="position:relative;width: 400px; " align="center">
                            <input type="submit" name="button" id="generateFeedback" value="Get Sheet" align="center" />  
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
