<%-- 
    Document   : modifySubject
    Created on : 16-Jan-2014, 16:35:12
    Author     : Girjesh
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.feedback.bean.Subject"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
  <%
                    response.setHeader("cache-control", "no-cache");
                    response.setHeader("cache-control", "no-store");
                    String un=(String) session.getAttribute("Username");
                  if (un== null) {
                        response.sendRedirect("index.jsp");
                    }
              ArrayList<Subject> list = (ArrayList<Subject>)session.getAttribute("subjectSet");
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
                  <form id="form1" method="post" action="ModificationServlet?action=subject">
  <div style="width: 500px; margin-top: 40px; ">
  <fieldset>
    <legend>Option:</legend>
    <div style="width: 300px;">
    <div style="position:relative ; width: 300px;">
         <div style="position:relative ; float: left; ">  
             <input type="radio" name="opration" value="new">
         </div>
         <div style="position:relative; float:left;"> 
             <label>Add Subject</label> 
         </div>
         <div>
         <table style="border: 0; width: 100px;float: left; margin-left: 30px;">
             <tr>
                 <td style=" width: 20px;">Subject Code </td>
                <td ><input type="text" name="subId" placeholder="BE101" /> </td>
             </tr>
             <tr>  
                <td> Subject Name </td> 
                <td><input  type="text" name="subName" placeholder="Subject Name"/>  </td> 
             </tr>
             <tr> 
                <td>  Semester </td> 
                <td>  <input type="text" name="semId" placeholder="1,2,3..."/>  </td>
             </tr>
         </table>
         </div>
         <div style="margin-top:30px; float: left; width: 300px;">  
             <input type="radio" name="opration" value="delete" style="float:left;">
             <label style="position:relative; float: left;">Delete</label> 
         </div>
         <div style="float: left; position: relative;">
            <label style="float:left; margin-left: 30px;"> Existing Subject</label>
        <select id="subId" name="dsubId">    
            <%  for(Subject sub:list){%>
            <option value="<%=sub.getSubId()%>"> <%out.print(sub.getSubId()+"  ");  out.print(sub.getSubName());%> </option>
            <%}%>
        </select>
          
    </div>
   <div style="float: left;margin-left: 50%;  position: relative; margin-top: 10%">
           <input type="submit" name="submit" value="submit"/></div>
    </div>
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
