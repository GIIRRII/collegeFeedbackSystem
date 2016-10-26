<%-- 
    Document   : generateFeedbackReport
    Created on : 02-Feb-2014, 12:07:32
    Author     : Girjesh
--%>

<%@page import="com.feedback.manager.GeneralDataManager"%>
<%@page import="com.feedback.manager.FeedbackDataManager"%>
<%@page import="com.feedback.bean.Feedback"%>
<%@page import="java.sql.ResultSet"%>
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
        <%
        Feedback fb= (Feedback)session.getAttribute("fb");
         
        GeneralDataManager gdm = new GeneralDataManager();
        String tot = (String) session.getAttribute("totalStud");
        String app = (String) session.getAttribute("appearedStud");
        String deptName = gdm.getDepartmentName(fb.getDeptId());
        String semName = gdm.getSemName(fb.getSemId());
        
        %>
        <div  style=" margin-left:auto; margin-right:auto; width:1055px;">
        <%@include file="header.html" %>
        </div>
        <h1> &nbsp; </h1>
        <div  style=" margin-left:auto; margin-right:auto; width:1055px;">
            <div style="float: right;">
            <%@include file="homeButton.jsp" %> &nbsp;
         <a href="logout.jsp" style="font-size:24px; color:#006699;text-decoration: none;">LogOut</a><br>
        </div>
        <form id="form1" name="form1"  method="post">
        <input type="button" value="Print" onclick="window.print();return false;">
        <center>
          <table border="1" >
              <tr> <label style="color:#006699"> <h2>Report generated by <%=deptName%>
             <%= semName%> for Passout Batch<%=fb.getYear()%> Section <%=fb.getSection()%></h2></label>
             </tr>
            <tr> 
            <label style="color:#006699;font-size:25px">
            	Total Students <input type="text" name="total" id="total" value="<%=tot%>"readonly/> 
            </label>
            <label style="color:#006699;font-size:25px">
            	Students Appeared<input type="text" name="appear" id="appear" value="<%=app%>"readonly/>
            </label>
            <p></p>
            </tr>
                <tr style="background-color: gray">
                    <th>
                        Subject Code
                    </th>
                    <th>
                        Subject Name
                    </th>
                    <th>
                        Faculty Name
                    </th>
                    <th>
                        Personality
                    </th>
                    <th>
                        Method Of Teaching
                    </th>
                    <th>
                        Knowledge of Subject
                    </th>
                    <th>
                        Communication
                    </th>
                    
                </tr>
                <% FeedbackDataManager fdm = new FeedbackDataManager();
                   ResultSet RS = fdm.getFeedback(fb);
                while(RS.next()) 
                {
                %><tr>
                    <td>
                        <% out.println(RS.getString(1));%>
                    </td>
                    <td>
                        <% out.println(RS.getString(2));%>
                    </td>
                    <td>
                        <% out.println(RS.getString(3));%>
                    </td>
                    <td>
                        <% out.println(RS.getString(8));%>
                    </td>
                    <td>
                        <% out.println(RS.getString(9));%>
                    </td>
                    <td>
                        <% out.println(RS.getString(10));%>
                    </td>
                    <td>
                        <% out.println(RS.getString(11));%>
                    </td>
               
                </tr>
                <%
                            }
                %>
            </table>
        </form>
       
              <p>
                <label>
                    <a href="viewComment.jsp" style="font-size: 22px;color:#006699">View comments by student of corresponding batch</a>
                </label>
                <br>
              </p>
        </div>
        </center>
        <h1>&nbsp;</h1>
        <div  style=" margin-left:auto; margin-right:auto; width:1055px;">
            <%@include file="footer.html" %>
        </div>
    </body>
</html>