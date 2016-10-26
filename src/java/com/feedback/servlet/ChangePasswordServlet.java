/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feedback.servlet;

import com.feedback.bean.LoginCredit;
import com.feedback.manager.PasswordManager;
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
public class ChangePasswordServlet extends HttpServlet {
    String newpass;
    int i=0;
    LoginCredit lc;
    HttpSession session;
    PasswordManager pm;
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
            session= request.getSession();
            lc=(LoginCredit) session.getAttribute("userData");
            pm=new PasswordManager();
            newpass= request.getParameter("newPassword");
            PrintWriter out = response.getWriter();
            out.println(newpass);
            out.println(lc.getDeptId());
            out.println(lc.getRole());
            try {
                 
                i= pm.updatePassword(lc, newpass);
                if(i==0)
                { 
                 response.sendRedirect("changePassword.jsp");
                }
                 else
                {   response.sendRedirect("adminLogin.jsp");
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
