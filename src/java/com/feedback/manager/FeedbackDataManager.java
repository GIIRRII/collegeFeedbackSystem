/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feedback.manager;

import com.feedback.bean.Feedback;
import com.feedback.bean.FeedbackFormDesign;
import com.feedback.bean.StudentRecord;
import com.feedback.connection.DBconnection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Girjesh
 */
public class FeedbackDataManager {
    ResultSet rs;
    DBconnection db = DBconnection.getConnection();
    int i=0;
    
    
    public ResultSet getFaculty(String deptId)
    {  rs = db.executeQuery("select faculty_id , "
            + "faculty_name from facultyrecord "
            + "where dept_id='"+deptId
            +"' order by faculty_name");
        return rs;
    }
    
    
    public ResultSet getSubject(String deptId,String semId)
    { 
        rs = db.executeQuery("select sub_id, "
                + "sub_name from subject "
                + "where dept_id='"+deptId
                +"' and sem_id='"+semId
                + "' order by sub_id");
      return rs;
    }
    
    
    public ResultSet getIndividualFeedback(Feedback fb,float i)
    {
      rs= db.executeQuery("select sub_id, "
              + "sub_name, faculty_name,"
              + "truncate(avg(per)*20/"+i+",2) per,"
              + "truncate(avg(M_O_T)*20/"+i+",2) M_O_T,"
              + "truncate(avg(K_O_S)*20/"+i+",2) K_O_S,"
              + "truncate(avg(COM_SKILL)*20/"+i+",2) COM_SKILL "
              + "from tempfeedback1 where year='"+fb.getYear()
              +"' and section='"+fb.getSection()
              +"' and sem_id='"+fb.getSemId()
              +"' and dept_id='"+fb.getDeptId()
              +"' group by sub_id,sub_name,faculty_name");
      return rs;
    }
    
    
    
    public int insertAppearedstudent(Feedback fb, int i)
    { i= db.executeUpdate("update nostudent "
            + "set appeared = '"+i
            +"' where dept_id='"+fb.getDeptId()
            +"' and sem_id='"+fb.getSemId()
            +"' and section='"+fb.getSection()
            +"'and year='"+fb.getYear()+"'");
       return i;
     }
    
    public int insertNoStudent(String batch,String deptId, String semId, String section, String nostud){
    i= db.executeUpdate("insert into nostudent values('"+
            semId+"','"+batch+"','"+nostud+"','0','"+deptId+"','"+section+"')");
    return i;}
   
    
    
    public int insertFeedbackFinal(Feedback fb) throws SQLException
    {  String query = "insert into finalfeedback1 values (?,?,?,?,?,?,?,?,?,?,?,?)";
         db.executeQuery(query, fb);
            /*insert into finalfeedback1 values('"+fb.getSubCode()
            +"','"+fb.getSubName()+"','"+fb.getFacultyName()+"','"+fb.getSemId()
            +"','"+fb.getDeptId()+"','"+fb.getYear()+"','"+ fb.getUnableToJudge()
            +"','"+fb.getPersonality()+"','"+ fb.getMethodOfTeaching()+"','"+
            fb.getKnowledgeOfSubject()+"','"+ fb.getCommunicationSkills()+"','"+
            fb.getSection()+"')" );*/
        return i;
    }
    
    
    
    
    public int deleteTempData(Feedback fb){
        i=db.executeUpdate("delete from tempfeedback1 where dept_id='"+
                fb.getDeptId()+"' and sem_id='"+fb.getSemId()
                +"' and year='"+fb.getYear()+"' and section='"+
                fb.getSection()+"'");
        return i;
        
    }
    
    public int insertFeedbackDesign(FeedbackFormDesign ffd){
        i=db.executeUpdate("insert into feedbackformdesign values('"+
             ffd.getSubCode()+"','"+ ffd.getSubName()+"','"+
             ffd.getFacultyName()+"','"+ ffd.getSemId()+"','"+ 
             ffd.getDeptId()+"','"+ ffd.getYear()+"','"+ ffd.getSection()+"')");
    return i;}
    
    
    public void deleteFeedbackDesign(Feedback fb){
        i=db.executeUpdate("delete from feedbackformdesign where dept_id='"+
                fb.getDeptId()+"' and sem_id='"+fb.getSemId()
                +"' and year='"+fb.getYear()+"' and section='"+
                fb.getSection()+"'");
    }
    
    public ResultSet getFeedbackForm(StudentRecord sr){
      rs= db.executeQuery("select * from feedbackformdesign"
              + " where dept_id='"+sr.getDeptId()
              +"' and sem_id='"+sr.getSemId()+"' "
              + "and section='"+sr.getSection()+"' "
              + "and year='"+sr.getYear()+"'");
      return rs;
    }
    
    public int insertFeedback(Feedback fb)
    { i= db.executeUpdate("insert into tempfeedback1 values('"+fb.getSubCode()
            +"','"+fb.getSubName()+"','"+fb.getFacultyName()+"','"+fb.getSemId()
            +"','"+fb.getDeptId()+"','"+fb.getYear()+"','"+ fb.getUnableToJudge()
            +"','"+fb.getPersonality()+"','"+ fb.getMethodOfTeaching()+"','"+
            fb.getKnowledgeOfSubject()+"','"+ fb.getCommunicationSkills()+"','"+
            fb.getSection()+"')" );
        return i;
    
    }
    
    public int insertComment(Feedback fb , String comment)
    {
        i= db.executeUpdate("insert into comments values("
                + "'"+fb.getDeptId()+"',"
                + "'"+fb.getSemId()+"',"
                + "'"+fb.getYear()+"',"
                +"'"+comment+"',"
                + "'"+fb.getSection()+"')" );
        return i;
    }
    
    public ResultSet getGrade()
    {
        rs= db.executeQuery("select * from grading");
        return rs;
    }
    
    public ResultSet getFeedback(Feedback fb){
        rs= db.executeQuery("select * from finalfeedback1 "
                + "where dept_id='"+fb.getDeptId()+"' "
                + "and year='"+fb.getYear()+"' "
                + "and section='"+fb.getSection()+"' "
                + "and sem_id='"+fb.getSemId()+"'");
       return rs;}
    
    public ResultSet getComment(Feedback fb){
         rs= db.executeQuery("select comments from comments "
                + "where dept_id='"+fb.getDeptId()+"' "
                + "and year='"+fb.getYear()+"' "
                + "and section='"+fb.getSection()+"' "
                + "and sem_id='"+fb.getSemId()+"'");
       return rs;
    }
    
    public ResultSet getStudentCount(Feedback fb){
        rs= db.executeQuery("select totalstu,appeared from nostudent"
                + " where dept_id='"+fb.getDeptId()+"' "
                + "and sem_id='"+fb.getSemId()+"' "
                + "and section='"+fb.getSection()+"'"
                + "and year='"+fb.getYear()+"'");
        return rs;
    }
    
    public int deleteFeedbackData(Feedback fb){
        
         i=db.executeUpdate("delete from finalfeedback1 where dept_id='"+
                fb.getDeptId()+"' and sem_id='"+fb.getSemId()
                +"' and year='"+fb.getYear()+"' and section='"+
                fb.getSection()+"'");
        return i;
    }
}
