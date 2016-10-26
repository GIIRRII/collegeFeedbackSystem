/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feedback.servlet;

import com.feedback.bean.FacultyRecord;
import com.feedback.bean.LoginCredit;
import com.feedback.bean.Subject;
import com.feedback.manager.GeneralDataManager;
import com.feedback.manager.ModificationManager;
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
public class ModificationDataServlet extends HttpServlet {
    HttpSession session;
    String action;
    LoginCredit lc;
    String role;
    ModificationManager mm;
    GeneralDataManager gdm;
    ResultSet rs;
    ArrayList <FacultyRecord> list1;
    ArrayList <Subject> list2;
    FacultyRecord fr;
    Subject sub;
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException, SQLException {
        session = request.getSession();
        action = request.getParameter("action");
        PrintWriter out = response.getWriter();
        lc =    (LoginCredit) session.getAttribute("userData");
        gdm = new GeneralDataManager();
        mm= new ModificationManager();
        role= lc.getRole();
        try {
               if(action.equalsIgnoreCase("faculty")){
                     list1=new ArrayList();
                    if(role.equalsIgnoreCase("departmentAdmin"))
                    {
                        rs=gdm.getFaculty(lc.getDeptId());
                        while(rs.next())
                        { fr= new FacultyRecord();
                          fr.setFacultyId(rs.getString("faculty_id"));
                          fr.setFacultyName(rs.getString("faculty_name"));
                          list1.add(fr);
                          
                        }
                    }
                    else if(role.equalsIgnoreCase("admin"))
                    { 
                        rs=gdm.getFaculty();
                        
                    }
               session.setAttribute("facultySet",list1 );
               response.sendRedirect("modifyFaculty.jsp");
                
               }
               else if(action.equalsIgnoreCase("subject"))
               {   list2 = new ArrayList();
                   if(role.equalsIgnoreCase("departmentAdmin"))
                   {
                     rs=gdm.getSubject(lc.getDeptId());
                     while(rs.next()){
                       sub=new Subject()  ;
                       sub.setSubId(rs.getString("sub_id"));
                       sub.setSubName(rs.getString("sub_name"));
                       
                       list2.add(sub);
                     }
                   }
                   if(role.equalsIgnoreCase("admin"))
                   {
                       
                   }
                 
                 session.setAttribute("subjectSet", list2);
                 response.sendRedirect("modifySubject.jsp");
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
            Logger.getLogger(ModificationDataServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ModificationDataServlet.class.getName()).log(Level.SEVERE, null, ex);
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
