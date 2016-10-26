
package com.feedback.servlet;

import com.feedback.bean.LoginCredit;
import com.feedback.bean.StudentRecord;
import com.feedback.manager.StudentRecordManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Girjesh
 */
public class StudentAttendanceServlet extends HttpServlet {
    
    StudentRecordManager srm;
    StudentRecord sr;
    HttpSession session;
    LoginCredit lc; 
    String action, deptId,role, eno,code,attnd,semId;
    int noStudent,i=0;
    ResultSet rs;

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        session= request.getSession();
        lc=(LoginCredit) session.getAttribute("userData");
        action = request.getParameter("action");
        role = lc.getRole();
      srm = new StudentRecordManager();
        try {
            
            if((action.equalsIgnoreCase("save"))){
               
                i=1; 
                noStudent = Integer.parseInt(request.getParameter("count"));
                sr= (StudentRecord) session.getAttribute("sr");
                 
                 while(i<=noStudent) 
                    {
                      eno = request.getParameter("en_"+i+"");
                      if(eno!=null){
                        sr.setEnrollmentNo(eno);
                        attnd= request.getParameter("attn_"+i+"");
                        semId=request.getParameter("semId_"+i+"");
                        sr.setAttendence(attnd);
                        sr.setSemId(semId);
                        srm.insertAttendence(sr);
                      } 
                      else{
                      }
               i++;
              }
                 if(role.equalsIgnoreCase("coordinator"))
                 { response.sendRedirect("coordinatorHome.jsp");}
                 if(role.equalsIgnoreCase("admin")){
                 response.sendRedirect("administrationHome.jsp");}
                 else
                 { response.sendRedirect("deptAdminHome.jsp");
                     
                 }
            
           } 
            
            else{  sr = new StudentRecord();
                   if(role.equalsIgnoreCase("coordinator")){
                    sr.setDeptId(lc.getDeptId());
                    sr.setSection(lc.getSection());
                    sr.setYear(lc.getYear());
                    sr.setSemId(lc.getSemId());
                    }
                else{
                if(lc.getDeptId()==null){
                    deptId= request.getParameter("deptId");
                    sr.setDeptId(deptId);
                 } 
                else{
                    sr.setDeptId(lc.getDeptId());
                }
                 sr.setSection(request.getParameter("section"));
                 sr.setSemId(request.getParameter("semId"));
                 sr.setYear(request.getParameter("batch"));
               }
                rs=srm.getStudentDetailsForAttendance(sr);
                session.setAttribute("rs", rs);
                session.setAttribute("sr", sr);
                response.sendRedirect("fillStudentAttendance.jsp");
            
            }
           
        }
        finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
        processRequest(request, response);
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
