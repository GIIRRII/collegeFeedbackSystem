<%-- 
    Document   : modifyDepartment
    Created on : 02-Feb-2014, 15:43:11
    Author     : Girjesh
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="com.feedback.manager.GeneralDataManager"%>
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
       ResultSet rs=  gdm.getDepartment();
    %>
    <body>
     <div  style=" margin-left:auto; margin-right:auto; width:1055px;">
        <%@include file="header.html" %>
       
        <div style="float: right;">
            <%@include file="homeButton.jsp" %> &nbsp;
         <a href="logout.jsp" style="font-size:24px; color:#006699;text-decoration: none;">LogOut</a><br>
        </div>
         <center>
             
        <form id="form1" method="post" action="ModificationServlet?action=department">
  <div style="width: 500px; margin-top: 40px; ">
  <fieldset>
    <legend>Option:</legend>
    
     <div style="position:relative ; width: 300px;">
         <div style="position:relative ; float: left; ">  <input type="radio" name="operation" value="new"></div>
         <div style="position:relative ; float: left ;"> <label>Add Department</label> </div>
         
         <table style="border: 0; width: 100px;float: left; margin-left: 30px;">
             <tr>
                 <td style=" width: 20px;">Department Id </td>
                <td ><input type="text" name="deptId" placeholder="CS" /> </td>
             </tr>
             <tr>  
                <td> Department Name </td> 
                <td><input  type="text" name="deptName" placeholder="Computer Science Engineering"/>  </td> 
             </tr>
             
         </table>
        
         <div style="float: left;  position: relative;">  <input type="radio" name="operation" value="delete"> </div>
         <div style="position:relative; float: left;">  <label>Delete</label> </div>
         <div style="position:relative ; float: left;">
        <label style="float:left; margin-left: 30px;"> Existing Department</label>
        <select id="deptId" name="ddeptId" >    
        <%  while(rs.next()){%>
        <option value="<%=rs.getString(1)%>"> <%out.print(rs.getString(2));%> </option>
         <%}%>
      </select>
          
    </div>
              <div style="float: left;margin-left: 50%;  position: relative; margin-top: 10%">
                  <input type="submit" name="submit" value="submit"/></div>
    </div>
  
  </fieldset>
  </div>
</form>
</center>
     </div>
         <h1>&nbsp;</h1>
        <div  style=" margin-left:auto; margin-right:auto; width:1055px;">
            <%@include file="footer.html" %>
        </div>
    </body>
</html>
