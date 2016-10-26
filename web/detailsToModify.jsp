<%-- 
    Document   : detailsToModify
    Created on : 05-Mar-2014, 00:56:12
    Author     : Girjesh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="com.feedback.manager.GeneralDataManager"%>
<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <title style="color: #005F9D;">IES IPS ACADEMY</title>
        <link href="images/IpsLogo.jpg" rel="shortcut icon" type="image/x-icon" />
    </head>
     <%             response.setHeader("cache-control", "no-cache");
                    response.setHeader("cache-control", "no-store");
                    String uname = (String) session.getAttribute("Username");
                    if (uname == null) {
                        response.sendRedirect("index.jsp");
                    }
           String action = request.getParameter("action");
 GeneralDataManager gdm = new GeneralDataManager();
       ResultSet rs=  gdm.getDepartment();
    %>
    <body>
        <div  style=" margin-left:auto; margin-right:auto; width:1055px;">
        <%@include file="header.html" %>
        </div>
        <h1> &nbsp; </h1>
        <div  style=" margin-left:auto; margin-right:auto; width:1055px;">
            <div style="margin-left: auto;float: left;"> 
        <%if(action.equalsIgnoreCase("subject")){%>
        <form name="form1"  method="post" action="ModificationDataServlet?action=subject">
         <select id="deptId" name="deptId" >    
        <%  while(rs.next()){%>
        <option value="<%=rs.getString(1)%>"> <%out.print(rs.getString(2));%> </option>
         <%}%>
      </select> <br>
      <input  type="submit" name="submit" value="submit">
        </form>
         <%} else if(action.equalsIgnoreCase("faculty")){%>  
          <form name="form1"  method="post" action="ModificationDataServlet?action=faculty">
         <select id="deptId" name="deptId" >        
        <%  while(rs.next()){%>
        <option value="<%=rs.getString(1)%>"> <%out.print(rs.getString(2));%> </option>
         <%}%>
         </select> <br>
      <input  type="submit" name="submit" value="submit">
        </form>
      <%}%>
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
