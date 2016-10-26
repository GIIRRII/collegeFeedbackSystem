<%-- 
    Document   : generateFeedbackForm
    Created on : 30-Jan-2014, 11:39:41
    Author     : Girjesh
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.feedback.bean.Subject" %>
<%@page import="com.feedback.bean.FacultyRecord" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% ArrayList <Subject> list1 = (ArrayList)session.getAttribute("subject");
   ArrayList <FacultyRecord>list2 = (ArrayList)session.getAttribute("faculty");
   String sid = (String)session.getAttribute("semester");
%>
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
        <h1>&nbsp;</h1>
        <div style="float: right;">
            <%@include file="homeButton.jsp" %> &nbsp;
         <a href="logout.jsp" style="font-size:24px; color:#006699;text-decoration: none;">LogOut</a><br>
        </div>
        <form id="frmId" name="frmID" onsubmit="" method="post" action="FeedbackFormServlet?action=save">
            <div align="center">
                    <label style="color:#006699; font-size: 22px">Batch Strength:</label>

                    <input type="text" name="no_stud" id="no_stud" value="" />
            </div>
               <br></br>

            <table width="859" border="1" align="center">
                <tr >
                    <td width="170" style="color:#006699;font-size: 22px" align="center">Subject Id</td>
                    <td width="170" style="color:#006699;font-size: 22px" align="center">Subject Name</td>
                    <td width="170" style="color:#006699;font-size: 22px" align="center">Faculty1</td>
                    <td width="170" style="color:#006699;font-size: 22px" align="center">Faculty2</td>
                    <td width="170" style="color:#006699;font-size: 22px" align="center">Faculty3</td>
                </tr>
                <%
                 int l = 0;
                 for (Subject t1 : list1) {
                %>
                <tr>
                    <td style="color:#006699" align="center">
                        <%=t1.getSubId()%><input type="hidden" name="subid_<%=l%>" value="<%=t1.getSubId()%>"/>
                    </td>
                    <td style="color:#006699" align="center">
                        <%=t1.getSubName()%>
                </td>
                      <td align="center">
                        <label>
                            <select name="f1_<%=l%>" id="f1">  <%--Faculty 1 --%>
                                <option value="None">None</option>
                                <% for (FacultyRecord fr:list2) {%>
                                <option value="<%=fr.getFacultyName()%>"> <%out.print(fr.getFacultyName());%> </option>
                                <%}%>
                            </select>
                        </label>
                    </td>
                    <td align="center">
                        <select name="f2_<%=l%>" id="f2">   <%--Faculty 2 --%>
                            <option value="None">None</option>
                             <% for (FacultyRecord fr:list2) {%>
                                <option value="<%=fr.getFacultyName()%>"> <%out.print(fr.getFacultyName());%> </option>
                                <%}%>
                        </select>
                    </td>
                    <td align="center">
                        <select name="f3_<%=l%>" id="f3">   <%--Faculty 3 --%>
                            <option value="None">None</option>
                             <% for (FacultyRecord fr:list2) {%>
                                <option value="<%=fr.getFacultyName()%>"> <%out.print(fr.getFacultyName());%> </option>
                                <%}%>
                        </select>
                    </td>
                </tr>
                <%
                                l++;
                            }
                %>
                       <tr>
                    <td colspan=5 align="center">
                        <input type="submit" name="save" id="save" value="Save" />
                    </td>
                </tr>
            </table>
        </form>
        </div>
 <h1>&nbsp;</h1>
        <div  style=" margin-left:auto; margin-right:auto; width:1055px;">
            <%@include file="footer.html" %>
        </div>
    </body>
</html>
