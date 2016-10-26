<%-- 
    Document   : adminLogin
    Created on : 20-Jan-2014, 01:32:32
    Author     : Girjesh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title style="color: #005F9D;">IES IPS ACADEMY</title>
        <link href="images/IpsLogo.jpg" rel="shortcut icon" type="image/x-icon" />
    </head>
   <body>
        <div  style=" margin-left:auto; margin-right:auto; width:1055px;">
        <%@include file="header.html" %>
        </div>
       <div  style=" margin-left:auto; margin-right:auto; margin-top:40px ;width:1055px;">
        <center>                                    
           <h1>
                     <label style="color: #006699">!!!WELCOME!!!</label><br>
                     <label  style="color: #006699" > ADMIN </label><br>
                </h1>
            
            <div>             
            <form action ="CheckUser?action=admin" method="post"> 
                <table id="tbl" min-width="10">
                   
                    <tr>
                        <td width="10px"></td>
                    </tr>
                    
                 <tr> <td  style="color:#006699 ;size:10px" ></td><td><input type="text" autocomplete="on" placeholder="User Id "  name="userId" value="" /></tr>
                 <tr>
                        <td width="10px"></td>
                    </tr> 
                    <tr></tr>
                 <tr><td style="color:#006699 "></td>
                     <td><input type="password" autocomplete="on" name="password" placeholder="password" value=""  /></tr>
                  <tr>
                        <td width="10px"></td>
                    </tr> 
                    <tr></tr>
                 </table>
                <div style=" margin-top: 5px">
                 <button  id="badminlog" type="submit" value=" " name="submit" >login</button>
                </div>
                          
                </form>
            </div>
            <div style=" margin-top: 40px">
          <h>For Registration?? Click Here </h>
                <div>
                    <a href="signUp.jsp">
                        <div>
                            <img src="images/signup.jpg">
                        </div>
                    </a>
                </div>
      </div>
             </center>
       </div>
        <div  style="position: relative; margin-left:auto; margin-right:auto;margin-top: 20px; width:1055px;">
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
                           
                       input[type="password"] {
                      -webkit-border-radius: 2px;
                     -moz-border-radius: 5px;
                      border-radius: 5px;
                      border-color: #005F9D;
                      width: 200px;height:40px;
                      font-size: 20px;
                     
                       }
                 #badminlog {
                                         
                    color: white;                  
                    border-radius: 8px;
                    border-color: #005F9D;
                    background-color:#005F9D; 
                     font-size: 20px;
                 }
                  #slect{
                      color: #005F9D;
                           border-radius: 5px;
                           border-color: #005F9D;
                           width: 200px;
                           height:40px;
                           font-size: 18px;
                           border :0;
                       }
                                      
            </style>
                 
               
       
    </body>
</html>
