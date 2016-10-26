/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feedback.servlet;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.feedback.bean.LoginCredit;
import com.feedback.bean.StudentRecord;
import com.feedback.manager.LoginManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * @author Girjesh
 */

public class CheckUser extends HttpServlet {
    String action;
    String userId, password;
    ResultSet rs;
    LoginManager lm = new LoginManager();
    HttpSession session;
    private String userType;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
            PrintWriter out = response.getWriter();
            session = request.getSession();
            action=request.getParameter("action");
           // out.println(action);
            userId=request.getParameter("userId");
           // out.println(userId);
            password=request.getParameter("password");
           // out.println(password);
             try{
                if(action.equalsIgnoreCase("Student"))
                  { 
                   StudentRecord sr = new StudentRecord();   
                   sr.setEnrollmentNo(userId);
                   sr.setPassword(password);
                   sr=lm.getStudentLogin(sr);
                   if (sr.getStatus())
                   {  
                       response.sendRedirect("index.jsp");
                   }
                   else
                   if(sr.getEnrollmentNo()==null||sr.getPassword()==null )
                   {  
                       response.sendRedirect("studentLogin.jsp");
                   }
                   else{
                      session.setAttribute("studentData", sr);
                      session.setAttribute("Username", sr.getEnrollmentNo());
                      response.sendRedirect("GetFeedbackFormServlet");
                   }   
                   
           } else
           if(action.equalsIgnoreCase("admin"))
            {
                LoginCredit lc = new LoginCredit();
                lc.setUserId(userId);
                lc.setPassword(password);
                lc= lm.getLogin(lc);
                if(lc.getRole()== null)
                {   response.sendRedirect("index.jsp");
                }
                else
                {   session.setAttribute("userData", lc);
                    session.setAttribute("Username", lc.getUserId());
                    if(lc.getRole().equalsIgnoreCase("departmentAdmin"))
                        { 
                            response.sendRedirect("deptAdminHome.jsp");
                        }
                    if(lc.getRole().equalsIgnoreCase("coordinator"))
                        { 
                            response.sendRedirect("coordinatorHome.jsp");  
                        }            
                  
                    if(lc.getRole().equalsIgnoreCase("principal"))
                    {    response.sendRedirect("principalHome.jsp");}
                } 
            }
             if(action.equalsIgnoreCase("administration"))
            {
                LoginCredit lc = new LoginCredit();
                lc.setUserId(userId);
                lc.setPassword(password);
                lc.setRole("admin");
                lc= lm.getLogin(lc);
                if(lc.getRole()== null)
                {   response.sendRedirect("index.jsp");
                }else
                {   session.setAttribute("Username", lc.getUserId());
                    session.setAttribute("userData", lc); 
                    response.sendRedirect("administrationHome.jsp");
                }
              }
   }    
       
finally {            
            out.close();
        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CheckUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CheckUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
