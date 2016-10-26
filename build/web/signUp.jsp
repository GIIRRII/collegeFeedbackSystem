<%-- 
    Document   : signUp
    Created on : 08-Mar-2014, 13:32:49
    Author     : Girjesh
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reistration</title>
         <link href="IpsLogo.jpg" rel="shortcut icon" type="image/x-icon"/>
         
         
          <style>
        input[type="text"] {
                    -webkit-border-radius: 2px;
                     -moz-border-radius: 5px;
                      border-radius: 5px;
                      border-color: #005F9D;
                      width: 200px;
                      height:40px;
                      font-size: 20px;
                           }
            #fsignup {
                    
                    color: white;                  
                    border-radius: 8px;
                    border-color: #21b721;
                    background-color: #006699;
                    font-size: 20px;
                    margin-top: 20px;
   
                }  
                
            #cosignup {
                    
                    color: white;                  
                    border-radius: 8px;
                    border-color: #005F9D;
                    background-color: #006699;
                    font-size: 20px;
                    margin-top: 20px;
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
                     #depsignup{
                    
                    color: white;                  
                    border-radius: 8px;
                    border-color: #005F9D;
                    background-color:#006699;
                    font-size: 20px;
                    margin-top: 20px;
   
                }  
                 #presignup{
                    
                    color: white;                  
                    border-radius: 8px;
                    border-color: #005F9D;
                    background-color: #006699;
                    font-size: 20px;
                    margin-top: 40px;
                    align: center;
                } 
                
                    /* Set the size and font of the tab widget */
.tabGroup {
    font: 10pt arial, verdana;
    width: 600px;
    height: 400px;
}
 
/* Configure the radio buttons to hide off screen */
.tabGroup > input[type="radio"] {
    position: absolute;
    left:-100px;
    top:-100px;
}
 
/* Configure labels to look like tabs */
.tabGroup > input[type="radio"] + label {
    /* inline-block such that the label can be given dimensions */
    display: inline-block;
 
    /* A nice curved border around the tab */
    border: 1px solid black;
    border-radius: 5px 5px 0 0;
    -moz-border-radius: 5px 5px 0 0;
    -webkit-border-radius: 5px 5px 0 0;
     
    /* the bottom border is handled by the tab content div */
    border-bottom: 0;
 
    /* Padding around tab text */
    padding: 5px 10px;
 
    /* Set the background color to default gray (non-selected tab) */
    background-color:#ddd;
}
 
/* Focused tabs need to be highlighted as such */
.tabGroup > input[type="radio"]:focus + label {
    border:1px solid #005F9D;
}
 
/* Checked tabs must be white with the bottom border removed */
.tabGroup  input[type="radio"]:checked + label {
    background-color:white;
    font-weight: bold;
    border-bottom: 1px solid white;
    margin-bottom: -1px;
}
 
/* The tab content must fill the widgets size and have a nice border */
.tabGroup > div {
    display: none;
    border: 1px solid black;
    background-color: white;
    padding: 10px 10px;
    overflow: auto;
    height: 400px;
    width: 500px;
    box-shadow: 0 0 20px #444;
    -moz-box-shadow: 0 0 20px #444;
    -webkit-box-shadow: 0 0 20px #444;
     border-radius: 0 5px 5px 5px;
    -moz-border-radius: 0 5px 5px 5px;
    -webkit-border-radius: 0 5px 5px 5px;
}
 
/* This matchs tabs displaying to thier associated radio inputs */
.tab1:checked ~ .tab1, .tab2:checked ~ .tab2, .tab3:checked ~ .tab3,.tab4:checked ~ .tab4 {
    display: block;
}

                
       </style>       
        
        </head>
    <body>
          
<div  style=" margin-left:auto; margin-right:auto; width:1055px;">
            <%@include file="header.html" %>
            <h1> &nbsp;</h1>
            <center>
<div class="tabGroup">
        <input type="radio" name="tabGroup1" id="rad1" class="tab1" checked="checked"/>
        <label for="rad1">Co-ordinator</label>    
    <input type="radio" name="tabGroup1" id="rad3" class="tab3"/>
    <label for="rad3">Department Admin</label>
    <input type="radio" name="tabGroup1" id="rad4" class="tab4"/>
    <label for="rad4">Principal</label>

    <br>
    <%-- 
    co-ornator divison 
--%>

    <div class="tab1">
                      <h1>&nbsp;</h1>
              <form method="post" > 
                <table>
               <tr>
                   
                   <td colspan="2"><input type="text" name="eno" value="" autocomplete="off" Placeholder="User ID" /> </td>  </tr>
              <tr>
                  <td><input type="text" name="ccd" value="" autocomplete="off" placeholder="password"  /></td> 
                  <td>
                      <input type="text" name="ccd" value="" autocomplete="off" placeholder="Confirm password"  /></td>
              </tr>
               <tr>
                   <td colspan="2"><input type="text" name="" value="" autocomplete="off" Placeholder="Department" /> </td>
         </tr>
              <tr>
                     
                  <td colspan="2"><input type="text" name="eno" value="" autocomplete="off" Placeholder="Teching semester" /> </td>
                  </tr>
                 <tr>
                     
                     <td colspan="2"><input type="text" name="eno" value="" autocomplete="off" Placeholder="Batch/year" /> </td> 
                 </tr>
                 <tr>
                     
                     <td colspan="2"> <select id="slect">
                         <option>Section</option>
                             <option value="A">A</option>
                            <option value="B">B</option>                          
                         </select> 
                                    
                     </td>
                 </tr>
              <tr>
                  <td colspan="2" align="center"><button id="cosignup" type="submit" value="" name="cosignup" >sign up</button></td>
              </tr>
                                                                 
                              </table>
                          </form>
    
    </div>

   <%-- 
    Depatment Admin division 
--%>
    <div class="tab3">
    <h1>&nbsp;</h1>
    <form method="post" > 
       <table >
                           
           <tr><td></td>
               <td><input type="text" name="" value="" autocomplete="off" Placeholder="User ID" /></td> </tr>
           <tr><td></td>
              <td><input type="text" name="" value="" autocomplete="off" placeholder="password"/>
              <td><input type="text" name="" value="" autocomplete="off" placeholder="Confirm password"  /></td>
          </tr>
         <tr><td></td>
             <td><input type="text" name="" value="" autocomplete="off" Placeholder="Department" /> </td>
         </tr>
                                    
         <tr>
             <td colspan="3" align="center"><button id="depsignup" type="submit" value="LOG IN" name="login" >Sign Up</button></td></tr>
                                                                 
         </table>
    </form>
       
    
    
      
 </div>
<%-- 
    Principal Division 
--%>
    <div class="tab4">
        
     <h1>&nbsp;</h1>
    <form method="post" > 
        <table >
        <tr>
             <td></td>
             <td><input type="text" name="" value="" autocomplete="off" Placeholder="User ID" />
        <tr>
             <td ></td>
             <td><input type="text" name="" value="" autocomplete="off" placeholder="password"  /></td>
             <td ></td>
             <td><input type="text" name="" value="" autocomplete="off" placeholder="Confirm password"  /></td>
        </tr>
       
        <tr>
          <td></td>
          <td colspan="3" align="center"><button id="presignup" type="submit" value="" name="login" >Sign Up</button></td>
        </tr>
        </table>
   </form>
       
      
    </div>
</div>        
       
        <br>
        <div style="clear: both; margin-top: 80px;">
        <%@include file="footer.html" %>
        </div>
            </center>
</div>
        
    </body>
</html>

