<%-- 
    Document   : studentLogin
    Created on : 11-Jan-2014, 00:00:12
    Author     : Girjesh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title style="color: #005F9D;">IES IPS ACADEMY</title>
        <link href="images/IpsLogo.jpg" rel="shortcut icon" type="image/x-icon" />
    <script language="javascript">
     function hello()
         {

    	 var password=document.forms["form1"]["password"].value;
         var userId=document.forms["form1"]["userId"].value;
	 if (y==null || y=="")
  		{
  		alert("password please");
  		return false;
  		}
         if(userId==null || userId=="")
             {
                 alert("userId can't be left blank");
                 return false;
             }
	}
       </script>
    </head>
    <body>  
        <div  style=" margin-left:auto; margin-right:auto; width:1055px;">
        <%@include file="header.html" %>
        </div>
       <h1>&nbsp;</h1>
       <div  style=" margin-left:auto; margin-right:auto; width:1055px;">
        <form name="form1" method="post" onSubmit="return hello();" action="CheckUser?action=student" >
            <table align="center">
                  <tr>
                      <td></td>
                      <td><input type="text" name="userId" value="" autocomplete="off" Placeholder="Enrollment Number" /></td>
                  </tr>
                  <tr>
                      <td height="20px"></td>
                      
                  </tr>
                  <tr>
                   <td ></td>
                   <td><input type="text" name="password" value="" autocomplete="off" placeholder="Computer Code"  /> </td>
                  </tr>
                  <tr>
                      <td height="20px"></td>
                      
                  </tr>
                 <tr>
                   <td></td>
                    <td align="center"><button id="studlog" type="submit" value="LOG IN" name="login" >login</button></td></tr>
                                            
                               </table>
                          </form>
       </div>
       
            <h1>&nbsp;</h1>
        <div  style=" margin-left:auto; margin-right:auto; width:1055px;">
            <%@include file="footer.html" %>
        </div>
  <style>
                     input[type="text"] {
                    -webkit-border-radius: 2px;
                     -moz-border-radius: 5px;
                      border-radius: 5px;
                      border-color: #005F9D;
                      width: 200px;height:40px;
                      font-size: 20px;
                     
                }
                #studlog {
                    
                    color: white;                  
                    border-radius: 8px;
                    border-color: #005F9D;
                    background-color:#005F9D; 
                     font-size: 20px;
                     
                   
                }  
                
            </style>
    </body>
</html>
