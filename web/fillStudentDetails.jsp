<%-- 
    Document   : fillStudentDetails
    Created on : 03-Feb-2014, 23:20:49
    Author     : Girjesh
--%>

<%@page import="com.feedback.bean.LoginCredit"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% LoginCredit ud = (LoginCredit)session.getAttribute("userData");
   Integer s = (Integer)session.getAttribute("noStudent");
   int noStudent= s.intValue();
   %>
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
        <h1>&nbsp;</h1>
        <div  style=" margin-left:auto; margin-right:auto; width:1055px;">
            <div style="float: right;">
            <%@include file="homeButton.jsp" %> &nbsp;
         <a href="logout.jsp" style="font-size:24px; color:#006699;text-decoration: none;">LogOut</a><br>
        </div>
           <form method="post" action="StudentRecordServlet" id="form1" onsubmit="">
            
              <table width="200" align="center">
                  <tr>
                      <th width="20">Sr No.</th>
                      <th width="80">Enrollment No</th>
                      <th width="60">Computer Code</th>
                      <th width="40">Attendance</th>
                   </tr>
             <% int i = 0;
               while(i<noStudent)
                {%>
               <tr>
                   <td width="20">
                       <label>
                           <input type="text" readonly="" value="<%=i%>" > 
                       </label>
                       
                   </td>
                   <td width="80">
                       <input type="text" value="" name="en_<%=i%>" >
                   </td>
                   <td width="60">
                       <input type="text" value="" name="code_<%=i%>">
                   </td>
                   <td width="40">
                       <input type="text" value="" name="attn_<%=i%>">
                   </td>
               </tr>
               <% i++;}%>
               <tr>
                   <td colspan="4" align="center">
               <input type="submit" name="action" value="save" >
                   </td>
               </tr>
              </table>
           </form>
            </div>
                
               <h1>&nbsp;</h1>
        <div  style=" margin-left:auto; margin-right:auto; width:1055px;">
            <%@include file="footer.html" %>
        </div>
    </body>
</html>
