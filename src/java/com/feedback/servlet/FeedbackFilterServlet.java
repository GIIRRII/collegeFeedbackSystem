/**
 *
 * @author Girjesh
 */
package com.feedback.servlet;
import com.feedback.bean.Feedback;
import com.feedback.bean.LoginCredit;
import com.feedback.manager.FeedbackDataManager;
import com.feedback.manager.StudentRecordManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class FeedbackFilterServlet extends HttpServlet {
HttpSession session ;
String section, semId, deptId,year,action;
LoginCredit lc;
ResultSet rs,comment,RS; 
FeedbackDataManager fdm;
Feedback fb;
StudentRecordManager srm;
ArrayList<String> list1;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        session = request.getSession();
        PrintWriter out = response.getWriter();
        section= request.getParameter("section");
        semId= request.getParameter("semId");
        year = request.getParameter("year");
        lc = (LoginCredit) session.getAttribute("userData");
        deptId= lc.getDeptId();
        fdm= new FeedbackDataManager();
        fb= new Feedback();
        list1= new ArrayList();
        action= request.getParameter("button");
        try {   
                if(deptId== null)
                { 
                    deptId= request.getParameter("deptId");
                }
                fb.setDeptId(deptId);
                fb.setSection(section);
                fb.setSemId(semId);
                fb.setYear(year);
                if(action.equalsIgnoreCase("filter"))
                { 
                  session.setAttribute("fb", fb);
                 // rs= fdm.getFeedback(fb);
                 // session.setAttribute("feedbackData", rs);
                 // rs.close();
                  comment = fdm.getComment(fb);
                  while(comment.next())
                  { out.println(comment.getString(1));
                     list1.add(comment.getString(1));
                  }
                  session.setAttribute("comments", list1);
                  rs= fdm.getStudentCount(fb);
                  if(rs.next())
                        {   
                            session.setAttribute("totalStud", rs.getString(1));
                            session.setAttribute("appearedStud", rs.getString(2));
                        }
                 response.sendRedirect("generateFeedbackReport.jsp");
                }
        else 
         if(action.equalsIgnoreCase("clear"))
                {                
                    int i=fdm.deleteFeedbackData(fb);
                    if(i!=0){
                        response.sendRedirect("selectFeedbackToClear.jsp");
                        }
                 }
                
        else
               if(action.equalsIgnoreCase("submit"))
                  {     srm = new StudentRecordManager();
                        int appearedStudent = srm.getAppearedStudent(fb);
                        out.println(appearedStudent);
                        float attendance = srm.getTotalattendence(fb);
                        out.println(attendance);
                        fdm=new FeedbackDataManager();
                        fdm.insertAppearedstudent(fb, appearedStudent);
                        rs= fdm.getIndividualFeedback(fb, attendance);
                        while(rs.next())
                        {   out.println("hello");
                            fb.setKnowledgeOfSubject(rs.getString("K_O_S"));
                            fb.setMethodOfTeaching(rs.getString("M_O_T"));
                            fb.setPersonality(rs.getString("per"));
                            fb.setCommunicationSkills(rs.getString("COM_SKILL"));
                            fb.setSubCode(rs.getString("sub_id"));
                            fb.setFacultyName(rs.getString("faculty_name"));
                            fb.setSubName(rs.getString("sub_name"));
                            fb.setUnableToJudge(null);
                            int k =fdm.insertFeedbackFinal(fb);
                            out.println("bye");
                        }
                        fb.setDeptId(deptId);
                        fb.setSection(section);
                        fb.setSemId(semId);
                        fb.setYear(year);
                        fdm.deleteTempData(fb);
                        fdm.deleteFeedbackDesign(fb);
                        response.sendRedirect("index.jsp");
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(FeedbackFilterServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(FeedbackFilterServlet.class.getName()).log(Level.SEVERE, null, ex);
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