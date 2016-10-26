/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feedback.servlet;

import com.feedback.bean.Departments;
import com.feedback.bean.FacultyRecord;
import com.feedback.bean.LoginCredit;
import com.feedback.bean.Subject;
import com.feedback.manager.ModificationManager;
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
public class ModificationServlet extends HttpServlet {
    HttpSession session;
    Subject sub;
    LoginCredit lc;
    String action,operation,role,deptId;
    FacultyRecord fr;
    ModificationManager mm = new ModificationManager();
    int i=0;
    Departments dept;

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        session = request.getSession();
        action = request.getParameter("action");
        lc= (LoginCredit) session.getAttribute("userData");
        operation = request.getParameter("operation") ;
        role= lc.getRole();
        try {
          if (action.equalsIgnoreCase("faculty")) /*------------ For Faculty-------------*/
          {  if(role.equalsIgnoreCase("departmentadmin"))
             {
               fr.setDeptId(lc.getDeptId());
             }
              else
               if(role.equalsIgnoreCase("admin"))
               {
                deptId= request.getParameter("deptId");
                fr.setDeptId(deptId);
               }
              fr.setFacultyId(request.getParameter("facultyId"));
              if(operation.equalsIgnoreCase("new"))
              {    fr.setFacultyName(request.getParameter("facultyName"));
                   i= mm.insertFaculty(fr);
              }
              else 
              if(operation.equalsIgnoreCase("delete"))
              {   i= mm.deleteFaculty(request.getParameter("dfacultyId"));
              }
              if(i!=0){
                  response.sendRedirect("modifyFaculty.jsp");
              } else{
                       response.sendRedirect("index.jsp");
              }
              
              
          }
          else 
          if(action.equalsIgnoreCase("subject"))  /*--------- For Subject-----------*/
          {   sub.setSubId(request.getParameter("subId"));
              if(role.equalsIgnoreCase("departmentAdmin"))
              {
               sub.setDeptId(lc.getDeptId()); 
              }
              else if(role.equalsIgnoreCase("admin"))
              {   deptId= request.getParameter("deptId");
                  sub.setDeptId(deptId);
              }
              
              if(operation.equalsIgnoreCase("new"))
              { sub.setSubName(request.getParameter("subName"));
                sub.setSemId(request.getParameter("semId"));
                i= mm.insertSubject(sub);
              }
              else if(operation.equalsIgnoreCase("delete"))
              {
                  i= mm.deleteSubject(request.getParameter("dsubId"), lc.getDeptId());
              }
              if (i!=0){
              response.sendRedirect("modifySubject.jsp");
              }
              else{
              response.sendRedirect("index.jsp");
              }
              
          }
          if(action.equalsIgnoreCase("department"))  /*--------- For Department-----------*/
          {   dept= new Departments();
              dept.setDeptId(request.getParameter("deptId"));
              if(operation.equalsIgnoreCase("new"))
              { 
                  dept.setDeptName(request.getParameter("deptId"));
                  i= mm.insertDepartment(dept);
              }
              else if(operation.equalsIgnoreCase("delete"))
              {    
                  i=mm.deleteDepartment(request.getParameter("ddeptId"));
              }
              if (i!=0){
              response.sendRedirect("modifyDepartment.jsp");
              }
              else{
              response.sendRedirect("index.jsp");
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
