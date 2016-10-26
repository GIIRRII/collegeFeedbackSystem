<%-- 
    Document   : feedback
    Created on : 01-Feb-2014, 17:33:28
    Author     : Girjesh
--%>

<%@page import="com.feedback.bean.FeedbackFormDesign"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.feedback.bean.StudentRecord"%>
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
    <body>
        <div  style=" margin-left:auto; margin-right:auto; width:1055px;">
        <%@include file="header.html" %>
        </div>
         <div  style=" margin-left:auto; margin-right:auto; width:1055px;">
        <form id="form1" name="form1" method="post" action="FeedbackDataServlet?action=saveFeedback">
         <h3 align="right"> <a href="logout2.jsp" style="color:#006699; font-size:20px">Logout</a></h3>
            <table  border="1" align="center" >
                <thead>
                     <th width="127" >Subject Code</th>
                     <th width="127">Subject Name</th>
                     <th width="127">Faculty Name</th>
                     <th width="127">Personality</th>
                     <th width="127">Method of Teaching</th>
                     <th width="134">Knowledge of Subject</th>
                     <th width="134">Communication</th>
            </thead>
                     <% StudentRecord sr=  (StudentRecord)session.getAttribute("studentData");
                            String sid= sr.getSemId();
                         ArrayList <String> grade = (ArrayList)session.getAttribute("grade");
                         ArrayList <FeedbackFormDesign>  list= (ArrayList<FeedbackFormDesign>)session.getAttribute("formData");
                         int l = 0;
                         for(FeedbackFormDesign ffd:list) {

                     %>
                 <tr>
                    <td style="color:#006699"> 
                        <%=ffd.getSubCode()%>
                        <input type="hidden" name="sc_<%=l%>" value="<%=ffd.getSubCode()%>"/>
                    </td>
                    <td style="color:#006699">
                        <%=ffd.getSubName()%>
                        <input type="hidden" name="sn_<%=l%>" value="<%=ffd.getSubName()%>"/>
                    </td>
                    <td style="color:#006699">
                        <%=ffd.getFacultyName()%> 
                        <input type="hidden" name="f_<%=l%>" value="<%=ffd.getFacultyName()%>"/>
                    </td>
                    <td align="center">
                        <label>
                             <select name="cb2_<%=l%>" id="cb2">
                                <% for (String s:grade) {%>
                                <option value="<%=s%>"> <%out.print(s);%> </option>
                                <%}%>
                             </select>
                        </label>
                    </td>
                    <td align="center">
                        <label>
                             <select name="cb3_<%=l%>" id="cb3">
                                <% for (String s:grade) {%>
                                <option value="<%=s%>"> <%out.print(s);%> </option>
                                <%}%>
                             </select>
                        </label>
                    </td>
                    <td align="center">
                        <label>
                             <select name="cb4_<%=l%>" id="cb4">
                                <% for (String s:grade) {%>
                                <option value="<%=s%>"> <%out.print(s);%> </option>
                                <%}%>
                             </select>
                        </label></td>
                    <td align="center">
                        <label>
                             <select name="cb5_<%=l%>" id="cb5">
                                <% for (String s:grade) {%>
                                <option value="<%=s%>"> <%out.print(s);%> </option>
                                <%}%>
                             </select>
                        </label>
                    </td>
                    
                </tr>
        <% l++;
         }
           if(!(sid.equals("1")||sid.equals("2")||sid.equals("3")||sid.equals("4")))
              {  
                  ArrayList <String> list1 = (ArrayList<String>)session.getAttribute("faculty") ;
             %>
              <tr>
                    <td style="color:#006699">
                      * Your Project
                    </td>
                    <td> 
                     <input type="text" name="pro_name" id="pro_name" value=" Enter Project Name" />
                     </td>
               <td>
                 <select name="pro_faculty" id="pro_faculty"> 
                     <option value="None">None</option>
                      <% for (String fac:list1)
                            {%>
                            <option value="<%=fac%>" > <%out.print(fac);%> </option>
                         <%
                            }
                         %>
                        </select>
               </td>
               <td align="center">
                   <label>
                            <select name="pro_P" id="pro_P">
                               <% for (String s:grade) {%>
                                <option value="<%=s%>"> <%out.print(s);%> </option>
                                <%}%>  
                            </select>
                        </label>
               </td>
               <td align="center">
                   <label>
                        <select name="pro_M" id="pro_M">
                            <% for (String s:grade) {%>
                                <option value="<%=s%>"> <%out.print(s);%> </option>
                                <%}%>
                        </select>
                   </label>
               </td>
               <td align="center">
                   <label>
                            <select name="pro_K" id="pro_K">
                                <% for (String s:grade) {%>
                                <option value="<%=s%>"> <%out.print(s);%> </option>
                                <%}%>
                            </select>
                   </label>
               </td>
               <td align="center">
                   <label>
                         <select name="pro_C" id="pro_C">
                           <% for (String s:grade) {%>
                                <option value="<%=s%>"> <%out.print(s);%> </option>
                           <%}%> 
                         </select>
                   </label>
               </td>
             </tr>
             <tr><td colspan=15 align="center"><input type="submit" name="save" id="save" value="Save" /></td></tr>
                   
          <%}%>
       </table> 
      </form>
         </div>
        <h1>&nbsp;</h1>
        <div  style=" margin-left:auto; margin-right:auto; width:1055px;">
            <%@include file="footer.html" %>
        </div>
    </body>
</html>
