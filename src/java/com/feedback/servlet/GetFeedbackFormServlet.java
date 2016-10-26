/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feedback.servlet;

import com.feedback.bean.FeedbackFormDesign;
import com.feedback.bean.Grades;
import com.feedback.bean.StudentRecord;
import com.feedback.manager.FeedbackDataManager;
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

/**
 *
 * @author Girjesh
 */
public class GetFeedbackFormServlet extends HttpServlet {
StudentRecord sr;
HttpSession session;
ResultSet rs;
FeedbackDataManager fdm;
FeedbackFormDesign ffd;
String grade;
ArrayList<FeedbackFormDesign> list1;
ArrayList<String> list2;
String deptId,semId;
ArrayList<String> faculty;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
       PrintWriter out = response.getWriter();
       session= request.getSession();
       sr = (StudentRecord) session.getAttribute("studentData");
       fdm= new FeedbackDataManager();
       list1= new ArrayList();
       list2= new ArrayList();
       deptId= sr.getDeptId();
       semId= sr.getSemId();
        try {
             rs = fdm.getFeedbackForm(sr);
             while(rs.next())
             {   ffd= new FeedbackFormDesign();
                 ffd.setSubCode(rs.getString("sub_id"));
                 ffd.setSubName(rs.getString("sub_name"));
                 ffd.setFacultyName(rs.getString("faculty_name"));
                 list1.add(ffd);
             }
             session.setAttribute("formData", list1);
             rs = fdm.getGrade();
             while(rs.next()){
                
                 grade=rs.getString("grade");
                 list2.add(grade);
             }
             session.setAttribute("grade", list2);
             if(!(semId.equals("1")||semId.equals("2")||semId.equals("3")||semId.equals("4")||semId.equals("5"))){
                rs= fdm.getFaculty(deptId);
                faculty= new ArrayList();
                out.print("upper");
                while(rs.next())
                {   
                    faculty.add(rs.getString("faculty_name"));  
                }
                session.setAttribute("faculty", faculty);
             }
             
           response.sendRedirect("giveFeedback.jsp");
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
            Logger.getLogger(GetFeedbackFormServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(GetFeedbackFormServlet.class.getName()).log(Level.SEVERE, null, ex);
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
