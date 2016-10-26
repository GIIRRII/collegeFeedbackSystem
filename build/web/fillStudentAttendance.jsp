<%-- 
    Document   : fillStudentAttendance
    Created on : 03-Feb-2014, 23:22:20
    Author     : Girjesh
--%>

<%@page import="com.feedback.manager.StudentRecordManager"%>
<%@page import="java.sql.ResultSet"%>
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
                    ResultSet rs = (ResultSet)session.getAttribute("rs");
    %>
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
         <form method="post" action="StudentAttendanceServlet" id="form1">
            <div>
              <table align="center" border="0.5">
                  <tr>
                      <th>Sr No.</th>
                      <th>Enrollment No</th>
                      <th>Attendance</th>
                      <th>semester</th>
                   </tr>
             <% int i = 1;
               while(rs.next())
                {%>
               <tr>
                    <td>
                       <label>
                           <input type="text" value="<%=i%>" readonly="" > 
                       </label>
                       
                   </td>
                   <td>
                       <label>
                           <input type="text" value="<%=rs.getString(1)%>" readonly="" name="en_<%=i%>" > 
                       </label>
                       
                   </td>
                   <td>
                       <input type="text" value="<%=rs.getString(2)%>" name="attn_<%=i%>">
                   </td>
                   <td>
                       <input type="text" value="<%=rs.getString(3)%>" name="semId_<%=i%>"> 
                   </td>
               </tr>
               <% i++;}%>
               <tr>
                   <td>
                       <label>
                           <input type="hidden"  value="<%=--i%>" name="count">  
                       </label>
                   </td>
                   <td colspan="2">
                       <input type="submit" name="action" value="save" >
                   </td>
               </tr>
              </table>
          </div>
              
      </form> 
        </div>
                        <h1>&nbsp;</h1>
        <div  style=" margin-left:auto; margin-right:auto; width:1055px;">
            <%@include file="footer.html" %>
        </div>
    </body>
</html>
