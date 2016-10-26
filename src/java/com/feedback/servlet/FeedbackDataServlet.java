package com.feedback.servlet;

import com.feedback.bean.Feedback;
import com.feedback.bean.FeedbackFormDesign;
import com.feedback.bean.StudentRecord;
import com.feedback.manager.FeedbackDataManager;
import com.feedback.manager.StudentRecordManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class FeedbackDataServlet extends HttpServlet {
String action, comment;
HttpSession session; 
StudentRecord sr;
StudentRecordManager srm;
Feedback fb;
ArrayList<FeedbackFormDesign> list1;
FeedbackDataManager fdm;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        session= request.getSession();
        fb= new Feedback();
        PrintWriter out = response.getWriter();
        action= request.getParameter("action");
        System.out.println(action);
        fdm= new FeedbackDataManager();
        try {
            if(action.equalsIgnoreCase("saveFeedback")||action.equalsIgnoreCase("saveComment"))
            {
                sr = (StudentRecord) session.getAttribute("studentData");
                list1 = (ArrayList<FeedbackFormDesign>) session.getAttribute("formData");
                fb.setDeptId(sr.getDeptId());
                fb.setSection(sr.getSection());
                fb.setSemId(sr.getSemId());
                fb.setYear(sr.getYear());
                if(action.equalsIgnoreCase("saveComment"))
                { comment = (String) request.getParameter("comment");
                  fdm.insertComment(fb, comment);
                  response.sendRedirect("index.jsp");
                }
                else
                 if(action.equalsIgnoreCase("saveFeedback"))
                 {   int k=0; 
                     float attnd= Integer.parseInt(sr.getAttendence());
                     attnd=attnd/100;
                     srm= new StudentRecordManager();
                     for(FeedbackFormDesign ffd: list1)
                     {      String sName = request.getParameter("sn_" + k);
                            String sCode = request.getParameter("sc_" + k);
                            String f1 = request.getParameter("f_" + k);
                            String c1;
                            int c2, c3, c4, c5;
                            c2 = Integer.parseInt(request.getParameter("cb2_" + k));
                            c3 = Integer.parseInt(request.getParameter("cb3_" + k));
                            c4 = Integer.parseInt(request.getParameter("cb4_" + k));
                            c5 = Integer.parseInt(request.getParameter("cb5_" + k));
                            fb.setSubCode(sCode);
                            fb.setSubName(sName);
                            fb.setFacultyName(f1);
                            fb.setPersonality(""+(c2*attnd));
                            fb.setMethodOfTeaching(""+(c3*attnd));
                            fb.setKnowledgeOfSubject(""+(c4*attnd));
                            fb.setCommunicationSkills(""+(c5*attnd));
                            fdm.insertFeedback(fb);
                            k++;
                     }
                     String semId=sr.getSemId();
                     int i = Integer.parseInt(semId); /*---- To Save Project Data---*/
                     if(i>4){
                            String sName = request.getParameter("pro_name");
                            if(sName!=null)
                            {
                                sName=sName.trim();
                            String sCode = request.getParameter("Project");
                            String f1 = request.getParameter("pro_faculty");
                            String c1;
                            int c2, c3, c4, c5;
                            c2 = Integer.parseInt(request.getParameter("pro_P"));
                            c3 = Integer.parseInt(request.getParameter("pro_M"));
                            c4 = Integer.parseInt(request.getParameter("pro_K"));
                            c5 = Integer.parseInt(request.getParameter("pro_C"));
                            fb.setSubCode(sCode);
                            fb.setSubName(sName);
                            fb.setFacultyName(f1);
                            fb.setPersonality(""+(c2*attnd));
                            fb.setMethodOfTeaching(""+(c3*attnd));
                            fb.setKnowledgeOfSubject(""+(c4*attnd));
                            fb.setCommunicationSkills(""+(c5*attnd));
                            fdm.insertFeedback(fb);
                            }
                     }
                     srm.setStatus(sr);
                     response.sendRedirect("comment.jsp");
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
