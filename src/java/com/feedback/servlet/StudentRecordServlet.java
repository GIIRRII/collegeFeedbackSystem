
package com.feedback.servlet;

import com.feedback.bean.LoginCredit;
import com.feedback.bean.StudentRecord;
import com.feedback.manager.StudentRecordManager;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Girjesh
 */
public class StudentRecordServlet extends HttpServlet {
HttpSession session;
LoginCredit lc; 
String action, deptId,role, eno,code,attnd;
StudentRecord sr;
StudentRecordManager srm;
int noStudent,i=0;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       PrintWriter out = response.getWriter();
       session= request.getSession();
       lc=      (LoginCredit) session.getAttribute("userData");
       action = request.getParameter("action");
       
       role = lc.getRole();
       
        try {
            if(action.equalsIgnoreCase("filter"))
            {   noStudent= Integer.parseInt(request.getParameter("noStudent"));
                sr = new StudentRecord();
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
                }else{
                    sr.setDeptId(lc.getDeptId());
                }
                 sr.setSection(request.getParameter("section"));
                 sr.setSemId(request.getParameter("semId"));
                 sr.setYear(request.getParameter("year"));
                }
                out.println(sr.getDeptId());
                session.setAttribute("sr", sr);
                session.setAttribute("noStudent", noStudent);
               response.sendRedirect("fillStudentDetails.jsp");
            }
            if(action.equalsIgnoreCase("save"))
            {   i=0; 
              Integer no = (Integer)session.getAttribute("noStudent");
              noStudent = no.intValue();
                sr=(StudentRecord) session.getAttribute("sr");
                srm = new StudentRecordManager();
                while(i<noStudent) 
                 {
                    eno = request.getParameter("en_"+i);
                    out.println(eno);
                    if(eno==null||eno.isEmpty()){
                       break;}
                    else{
                        sr.setEnrollmentNo(eno);
                        code=request.getParameter("code_"+i);
                        out.println(code);
                        sr.setPassword(code);
                        attnd= request.getParameter("attn_"+i);
                        if(attnd.isEmpty())
                        {attnd=null;}
                        sr.setAttendence(attnd);
                        out.println(attnd);
                        out.println(sr.getDeptId());
                        out.println(sr.getEnrollmentNo());
                        srm.insertStudentRecord(sr);
                        
                      }
               i++;
              }
               response.sendRedirect("deptAdminHome.jsp");
            }
            else if(action.equalsIgnoreCase("clear")){
                String operation = request.getParameter("operation");
                if(operation.equalsIgnoreCase("all")){
                String year = request.getParameter("year");
                srm.deleteStudentDetails(year);
                }else{
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
                }else{
                    sr.setDeptId(lc.getDeptId());
                }
                 sr.setSection(request.getParameter("section"));
                 sr.setSemId(request.getParameter("semId"));
                 sr.setYear(request.getParameter("year"));
                 srm.deleteStudentDetails(sr);
                }
                }
                
            }
          
            
        } finally {            
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
