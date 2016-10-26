package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.feedback.bean.LoginCredit;
import java.sql.ResultSet;
import com.feedback.manager.GeneralDataManager;
import com.feedback.bean.LoginCredit;

public final class feedbackReportFilter_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(3);
    _jspx_dependants.add("/header.html");
    _jspx_dependants.add("/homeButton.jsp");
    _jspx_dependants.add("/footer.html");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>IES IPS ACADEMY</title>\n");
      out.write("        <link href=\"images/IpsLogo.jpg\" rel=\"shortcut icon\" type=\"image/x-icon\" />\n");
      out.write("    </head>\n");
      out.write("    ");
  response.setHeader("cache-control", "no-cache");
                    response.setHeader("cache-control", "no-store");
                    String uname = (String) session.getAttribute("Username");
                    if (uname == null) {
                        response.sendRedirect("index.jsp");
                    }

        
      out.write("\n");
      out.write("    ");
 GeneralDataManager gdm = new GeneralDataManager();
    LoginCredit ud= (LoginCredit)session.getAttribute("userData");
     String deptId= ud.getDeptId();
       ResultSet rs;   
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <div  style=\" margin-left:auto; margin-right:auto; width:1055px;\">\n");
      out.write("        ");
      out.write("<!--\r\n");
      out.write("To change this template, choose Tools | Templates\r\n");
      out.write("and open the template in the editor.\r\n");
      out.write("-->\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <title></title>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("    <div style=\"position:relative; width: 1054px; height: 17px; background-color: #005F9D\"></div>\r\n");
      out.write("    <div style=\"float:left\"> <img id=\"IpsLogo\" src=\"images/IpsLogo.jpg\" style=\" position:relative;left: 14px; top: 5px; width: 113px; height: 116px\" > </div>\r\n");
      out.write("    <div><img id=\"IesBanner\" src=\"images/IESbanner.jpg\" style=\"position:relative; left: 15px; width: 892px; height: 93px;\"></div>\r\n");
      out.write("    <div style=\"float:left;\">\r\n");
      out.write("    <img id=\"Image2\" src=\"images/knowledgeskillvalue.jpg\" style=\"position:relative; left: 330px; width: 230px; height: 28px;\"></div>\r\n");
      out.write("    <div style=\"position:relative; top:28px; width: 1054px; height: 17px; background-color: #005F9D\"></div>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <h1>&nbsp;</h1>\n");
      out.write("        <div  style=\" margin-left:auto; margin-right:auto; margin-top: auto; width:1055px;\">\n");
      out.write("            <div style=\"float: right;\">\n");
      out.write("            ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
 LoginCredit lc = (LoginCredit)session.getAttribute("userData");
        String role = lc.getRole();
          if(role.equalsIgnoreCase("departmentAdmin")){
        
      out.write("\n");
      out.write("        <a href=\"deptAdminHome.jsp\" style=\"font-size:22px; color:#006699;text-decoration: none;\">Home</a>\n");
      out.write("        ");
} else if(role.equalsIgnoreCase("coordinator")){
      out.write("\n");
      out.write("        <a href=\"coordinator.jsp\" style=\"font-size:22px; color:#006699;text-decoration: none;\">Home</a>\n");
      out.write("        ");
} else if(role.equalsIgnoreCase("admin")){
      out.write("\n");
      out.write("        <a href=\"administrationHome.jsp\" style=\"font-size:22px; color:#006699;text-decoration: none;\">Home</a>\n");
      out.write("        ");
} else if(role.equalsIgnoreCase("principal")){
      out.write(" \n");
      out.write("        <a href=\"principalHome.jsp\" style=\"font-size:22px; color:#006699;text-decoration: none;\">Home</a>\n");
      out.write("        ");
}
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write(" &nbsp;\n");
      out.write("         <a href=\"logout.jsp\" style=\"font-size:24px; color:#006699;text-decoration: none;\">LogOut</a><br>\n");
      out.write("        </div>\n");
      out.write("         \n");
      out.write("         <div style=\"width:400px;position: relative; clear:both; margin-left: auto; margin-right: auto; margin-top: 40px;\">\n");
      out.write("            <form id=\"form1\" name=\"form1\" method=\"post\" action=\"FeedbackFilterServlet\">\n");
      out.write("                \n");
      out.write("                  <fieldset>  \n");
      out.write("                <legend style=\"color:#006699;font-size: 22px \" align=\"center\">Select Options </legend>\n");
      out.write("                 ");
   if(deptId== null)
                   {
      out.write("\n");
      out.write("                   <div style=\"position:relative; float: left;width: 180px; margin-top: 40px;\">\n");
      out.write("                       <font style=\"color:#006699;font-size: 18px\">Select Department</font>\n");
      out.write("                   </div>\n");
      out.write("                   <div style=\"position:relative; float: right;width: 220px; margin-top: 40px;\">\n");
      out.write("                 <select name=\"deptId\" id=\"deptId\" style=\"width:220px;\">\n");
      out.write("                        ");
 rs= gdm.getDepartment();
                            while (rs.next()) {
                                
      out.write("\n");
      out.write("                            <option value=\"");
      out.print( rs.getString(1) );
      out.write("\"> ");
      out.print( rs.getString(2) );
      out.write(" </option>\n");
      out.write("                             ");
}
                              
      out.write("\n");
      out.write("                        </select>\n");
      out.write("                   </div>&nbsp;\n");
      out.write("                 \n");
      out.write("               ");
}
      out.write("\n");
      out.write("               <br>\n");
      out.write("              <div style=\"float: left;width: 180px; clear: both;\">\n");
      out.write("                  <font style=\"position:relative;color:#006699; font-size: 18px; float: left\">Passout Batch</font> </div>\n");
      out.write("                  <div style=\"position:relative; float: right;width: 220px;\">\n");
      out.write("                <select name=\"batch\" id=\"year\" style=\"width:220px;\">\n");
      out.write("                           ");

                        rs= gdm.getBatch();
                        while (rs.next()) {
                            String s = rs.getString(1);
      out.write("\n");
      out.write("                        <option value=\"");
      out.print(s);
      out.write("\"> ");
      out.print(s);
      out.write(" </option>\n");
      out.write("                  ");

                        }
      out.write("\n");
      out.write("                        </select>\n");
      out.write("                  </div>&nbsp;\n");
      out.write("                        <br>\n");
      out.write("                        <div style=\"position:relative; float: left;width: 180px; clear: both;\">\n");
      out.write("                     <font style=\"color:#006699;font-size: 18px\">Select Semester</font>\n");
      out.write("                        </div>\n");
      out.write("                        <div style=\"position:relative; float: right;width: 220px;\">\n");
      out.write("                    <select name=\"semId\" id=\"semId\" style=\"width:220px;\">\n");
      out.write("                            \n");
      out.write("                        ");
 rs= gdm.getSemester();
                           while (rs.next()) {
                        
      out.write("\n");
      out.write("                        <option value=\"");
      out.print( rs.getString(1) );
      out.write("\"> ");
      out.print( rs.getString(2) );
      out.write(" </option>\n");
      out.write("                  ");

                        }
      out.write("\n");
      out.write("                        </select>\n");
      out.write("                        </div>&nbsp;\n");
      out.write("                        <br>\n");
      out.write("                        <div style=\"position:relative; float: left;width: 180px; clear : both;\">\n");
      out.write("                            <font style=\"color:#006699;font-size: 18px;\">Select Section</font> </div>\n");
      out.write("                            <div style=\"position:relative; float: right;width: 220px;\">\n");
      out.write("                                <select name=\"section\" id=\"section\" style=\"width:220px;\">\n");
      out.write("                            \n");
      out.write("                        ");
 rs= gdm.getSection();
                        while (rs.next()) {
                            String s = rs.getString(1);
                         
      out.write("\n");
      out.write("                        <option value=\"");
      out.print( s);
      out.write("\"> ");
      out.print( s);
      out.write(" </option>\n");
      out.write("                  ");

                        }
      out.write("\n");
      out.write("                        </select>\n");
      out.write("                            </div>\n");
      out.write("                        <br> &nbsp; <br> &nbsp; <br> &nbsp;\n");
      out.write("                        <div style=\"position:relative;width: 400px; \" align=\"center\">\n");
      out.write("                            <input type=\"submit\" name=\"button\" id=\"generateFeedback\" value=\"filter\" align=\"center\" />  \n");
      out.write("                        </div>             \n");
      out.write("            </fieldset>\n");
      out.write("                ");
      out.write("\n");
      out.write("                         \n");
      out.write("</form>\n");
      out.write("         </div>\n");
      out.write("        </div>\n");
      out.write("                         <h1>&nbsp;</h1>\n");
      out.write("        <div  style=\" margin-left:auto; margin-right:auto; width:1055px;\">\n");
      out.write("            ");
      out.write("<!--\r\n");
      out.write("To change this template, choose Tools | Templates\r\n");
      out.write("and open the template in the editor.\r\n");
      out.write("-->\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <title></title>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <pre style=\"text-align: center; color:#005F9D;\">\r\n");
      out.write("             \r\n");
      out.write("             \r\n");
      out.write("        &COPY; IES IPS Academy,Indore\r\n");
      out.write("        Design & Developed By GirohTechnocrats \r\n");
      out.write("      </pre>\r\n");
      out.write("       \r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
