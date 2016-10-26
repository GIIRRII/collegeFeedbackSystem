<%-- 
    Document   : changePassword
    Created on : 16-Jan-2014, 16:31:08
    Author     : Girjesh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<jsp:useBean id="userData" scope="session" class="com.feedback.bean.LoginCredit">
</jsp:useBean>

<%

     response.setHeader("cache-control", "no-cache");
     response.setHeader("cache-control", "no-store");
     String uname = (String) session.getAttribute("Username");
     if (uname == null) {
       response.sendRedirect("index.jsp");
     }
     if(session.isNew())
    { session.invalidate();
      response.sendRedirect("index.jsp");
  return;}

    %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title style="color: #005F9D;">IES IPS ACADEMY</title>
        <link href="images/IpsLogo.jpg" rel="shortcut icon" type="image/x-icon" />
        <script language="javascript" type="text/Javascript">
         function hello()
         {
    	  var np=document.forms["form1"]["newPassword"].value;
          var cnp=document.forms["form1"]["confirmNewPassword"].value;
          var cp=document.forms["form1"]["currentPass"].value;
	     if (np==null || np==""||cnp==null || cnp==""||cp==null||cp==null)
  	     {
  		alert("password must be filled out....!!!!");
  		return false;
  	     }
              else 
              if(cnp!=np)
                  {
                    alert("password not matched....!!!!");
  		return false;
                  }
               else{ //alert("please enter correct, current password");
                        return true;
                     }
         }
	
</script>

    </head>
    
    <body>
        <div  style=" margin-left:auto; margin-right:auto; width:1055px;">
        <%@include file="header.html" %>
        <div style="float: right; clear : both; margin-top: 40px;">
            <%@include file="homeButton.jsp" %> &nbsp;
         <a href="logout.jsp" style="font-size:24px; color:#006699;text-decoration: none;">LogOut</a><br>
        </div>
         &nbsp;
        <div style="width:400px;margin-left: auto; margin-right: auto; clear: both; position: relative;">
        <form id="form1" name="form1" method="post" onsubmit="return hello();" action="ChangePasswordServlet" >
            <fieldset>
                 <legend style="color:#006699;font-size: 22px " align="center">Change Password </legend>
                 &nbsp;
                 <table>
                     <tr>
                         <td style="width:160px">
             <label style="color:#006699; font-size:18px;">Current Password</label>
                         </td>
                         <td>
  
                 <input type="password" name="currentPass" id="currentPass" style="width:160px" />
                         </td>
                     </tr>
                     <tr> 
                         <td style="width:160px">
                 <font style="color:#006699; font-size:18px">New Password</font>
                         </td>
                         <td>
          <input type="password" name="newPassword" id="newPassword" style="width:160px" />
      </td>
        </tr>
        <tr>
            <td style="width:160px">
      <font  style="color:#006699; font-size:18px">Confirm Password</font>
            </td> <td>
          <input type="password" name="confirmNewPassword" id="confirmNewPass" style="width:160px"/>
            </td>
                 </tr>
                 <tr > <td style="width:160px" align="center" colspan="2">
            <input type="submit" name="button" id="button" value="Save" align="center" />
                 
            <input type="reset" value="Reset" align="center" />
            
                     </td>
                 </tr>
                 </table>
            </fieldset>
        </form> 
  </div>
        </div> 
        <div  style=" margin-left:auto; margin-right:auto; width:1055px; clear: both">
            <%@include file="footer.html" %>
        </div>
    </body>
</html>
