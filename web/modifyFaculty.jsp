<%-- 
    Document   : modifyFaculty
    Created on : 16-Jan-2014, 16:34:43
    Author     : Girjesh
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.feedback.bean.FacultyRecord"%>
<%@page import="com.feedback.manager.GeneralDataManager"%>
<%@page import="com.feedback.bean.LoginCredit"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%   response.setHeader("cache-control", "no-cache");
     response.setHeader("cache-control", "no-store");
    if ((String) session.getAttribute("Username") == null) {
        response.sendRedirect("index.jsp");}
                    
    ArrayList<FacultyRecord> list = (ArrayList<FacultyRecord>)session.getAttribute("facultySet");
    
 %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IES IPS ACADEMY</title>
        <link href="images/IpsLogo.jpg" rel="shortcut icon" type="image/x-icon" />
    </head>
    <body>
        <div  style=" margin-left:auto; margin-right:auto; width:1055px;">
        <%@include file="header.html" %>
        </div>
  <div  style=" margin-left:auto; margin-right:auto; width:1055px;">
      <div style="float: right;">
            <%@include file="homeButton.jsp" %> &nbsp;
         <a href="logout.jsp" style="font-size:24px; color:#006699;text-decoration: none;">LogOut</a><br>
        </div>
  <center>
      <div style="width: 500px; margin-top: 40px; ">
  <form id="form1" method="post" action="ModificationServlet?action=faculty">
   
  <fieldset>
    <legend>Option:</legend>
    <div style="width: 300px;">
    <div style="float:left; width: 300px;">  
        <input type="radio" name="operation" value="new" style="float: left">
         <label style="position:relative; float: left;">Add Faculty</label>
         </div>
         <div style="float: left; width: 300px; margin-top: 10px; margin-left: 30px;">
         <table style="border: 0; width: 100px;float: left;">
             <tr>
                 <td style=" width: 20px;">Faculty Id </td>
                <td ><input type="text" name="facultyId" placeholder="1" /> </td>
             </tr>
             <tr>  
                <td> Faculty Name </td> 
                <td><input  type="text" name="facultyName" placeholder="Mr.Abc"/>  </td> 
             </tr>
          </table>
         </div>
         <div style="float: left; position: relative; width: 300px;margin-top: 20px;">  
         <input type="radio" name="operation" value="delete" style="float: left; position: relative;"> 
         <label style="float: left; position: relative;">Delete</label>
         </div>
         <div style="position:relative ; float: left; margin-top: 10px;">
        <label style="float:left; margin-left: 30px;"> Existing Faculty</label>
        <select id="facultyId" name="dfacultyId">    
           <%  for(FacultyRecord fr:list){%>
         <option value="<%=fr.getFacultyId()%>"> <%out.print(fr.getFacultyName());  out.print(fr.getFacultyId());%> </option>
              <%}%>
        </select>
        </div>
        <div style="float: left;position: relative; margin-top: 20%">
           <input type="submit" name="submit" value="submit"/>
        </div>
    </div>
  </fieldset>

    </form>
      </div>
  </center>
  </div>
 <h1>&nbsp;</h1>
        <div  style=" margin-left:auto; margin-right:auto; width:1055px;">
            <%@include file="footer.html" %>
        </div>
    </body>
    
</html>
