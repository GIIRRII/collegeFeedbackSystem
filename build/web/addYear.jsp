<%-- 
    Document   : addYear
    Created on : 05-Mar-2014, 22:05:33
    Author     : Girjesh
--%>

<%@page import="com.feedback.manager.GeneralDataManager"%>
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
       <div style="float: right;">
                <%@include file="homeButton.jsp" %> &nbsp;
                <a href="logout.jsp" style="font-size:24px; color:#006699;text-decoration: none;">LogOut</a><br>
        </div>
            <form name="form1" action="">
                <h6>&nbsp;</h6>
                <div align="center" style="clear: both;">
                    <div style="">
                    <font style="font-size: 22px;"> Batch</font> &nbsp; &nbsp; 
               <input type="text" name="year" id="year" placeholder="1992" value=""> <br>
                    </div>
                    <h6>&nbsp;</h6> 
                    <input type="submit" name="" >
                </div>
           </form>
        </div>
        <div  style=" margin-left:auto; margin-right:auto; position: relative; margin-top: auto; width:1055px; clear: both;">
            <%@include file="footer.html" %>
        </div>
   </body>
</html>
<% String year= request.getParameter("year");
  if(year != null){
      GeneralDataManager gdm = new GeneralDataManager();
      int i =gdm.inserYear(year);
      if(i>0){
      response.sendRedirect("administrationHome.jsp"); }
  }
%>