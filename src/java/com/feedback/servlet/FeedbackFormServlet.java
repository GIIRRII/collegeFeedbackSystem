/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feedback.servlet;

import com.feedback.bean.FacultyRecord;
import com.feedback.bean.Feedback;
import com.feedback.bean.FeedbackFormDesign;
import com.feedback.bean.LoginCredit;
import com.feedback.bean.StudentRecord;
import com.feedback.bean.Subject;
import com.feedback.manager.FeedbackDataManager;
import com.feedback.manager.GeneralDataManager;
import com.feedback.manager.ModificationManager;
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

/**
 *
 * @author Girjesh
 */
public class FeedbackFormServlet extends HttpServlet {
    HttpSession session;
    GeneralDataManager gdm;
    LoginCredit lc;
    String action, operation,batch,section,semId,deptId;
    Subject sub;
    ResultSet rs;
    FeedbackDataManager fdm;
    Feedback fb;
    StudentRecordManager srm;
    ArrayList<String> list1,list2,list3;
    ArrayList<Subject> subject;
    ArrayList<FacultyRecord> faculty;
    FacultyRecord fr;
    FeedbackFormDesign ffd;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        session = request.getSession();
        lc =(LoginCredit) session.getAttribute("userData");
        action = request.getParameter("action");
        PrintWriter out = response.getWriter();
        try {  
               batch= request.getParameter("batch");
               section= request.getParameter("section");
               String semester= request.getParameter("semId");
               deptId = lc.getDeptId();
               if(deptId==null)
               {
                   deptId= request.getParameter("deptId");
               }  
               fdm = new FeedbackDataManager();
               if(action.equalsIgnoreCase("generate"))   /*------To genetate FeedbackForm------*/
               {       faculty= new ArrayList();
                       subject= new ArrayList();
                       rs = fdm.getFaculty(deptId);
                       while(rs.next())
                         {   fr= new FacultyRecord();  
                             fr.setFacultyName(rs.getString("faculty_name"));
                             fr.setFacultyId(rs.getString("faculty_id"));
                             faculty.add(fr);
                         }
                       
                       rs =fdm.getSubject(deptId,semester);
                       while(rs.next()){
                                sub = new Subject();  
                                sub.setSubId(rs.getString("sub_id"));
                                sub.setSubName(rs.getString("sub_name"));
                                subject.add(sub);
                            }
                        session.setAttribute("faculty", faculty);
                        session.setAttribute("subject", subject);
                        session.setAttribute("batch", batch);
                        session.setAttribute("section", section);
                        session.setAttribute("semester", semester);
                        session.setAttribute("department", deptId);
                        response.sendRedirect("generateFeedbackForm.jsp");
               
                        }
              
           
          else        /*-------------------------- TO save Design--------------------------*/
           {          
               if (action.equalsIgnoreCase("save")){
                   String noStudent =  request.getParameter("no_stud");
                   subject = new ArrayList();
                   fb= new Feedback();
                   fdm.insertNoStudent(batch,deptId,semId,section,noStudent);
                   subject = (ArrayList<Subject>) session.getAttribute("subject");
                   int k=0;
                   for(Subject sub:subject)
                   {   ffd= new FeedbackFormDesign();
                       String sName = sub.getSubName(); 
                       String sCode =sub.getSubId();   
                       String f1, f2 , f3 ;
                       f1 = request.getParameter("f1_"+k+"");   //for faculty 1
                       f2 = request.getParameter("f2_"+k+"");   
                       f3 = request.getParameter("f3_"+k+"");   //for faculty 3
                       ffd.setDeptId(deptId);
                       ffd.setSection(section);
                       ffd.setSemId(semId);
                       ffd.setSubCode(sCode);
                       ffd.setSubName(sName);
                       ffd.setFacultyName(f1);
                       ffd.setYear(batch);
                       if(!f1.equalsIgnoreCase("none"))
                       {
                           fdm.insertFeedbackDesign(ffd);
                       }
                       if(!f2.equalsIgnoreCase("none"))
                       {
                           ffd.setFacultyName(f2);
                           fdm.insertFeedbackDesign(ffd);
                       }
                       if(!f3.equalsIgnoreCase("none"))
                       {
                        ffd.setFacultyName(f3);
                        fdm.insertFeedbackDesign(ffd);
                       }   
                       k++;
                   }
                   srm=new StudentRecordManager();
                   fb.setDeptId(deptId);
                   fb.setSection(section);
                   fb.setSemId(semId);
                   fb.setYear(batch);
                   srm.clearStatus(fb);
                   response.sendRedirect("feedbackFormToGenerate.jsp"); 
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
            throws ServletException, IOException{
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(FeedbackFormServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(FeedbackFormServlet.class.getName()).log(Level.SEVERE, null, ex);
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
