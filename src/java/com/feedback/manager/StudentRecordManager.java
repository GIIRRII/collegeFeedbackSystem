/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feedback.manager;

import com.feedback.bean.Feedback;
import com.feedback.bean.StudentRecord;
import com.feedback.connection.DBconnection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Girjesh
 */
public class StudentRecordManager {
    DBconnection db = DBconnection.getConnection();
    int i=0;
    ResultSet rs;
    
     public int getAppearedStudent(Feedback feedback) throws SQLException
    { rs= db.executeQuery("select count(status) from studentrecord "
            + " where year='"+feedback.getYear()
            +"' and section='"+feedback.getSection()
            +"' and dept_id='"+feedback.getDeptId()
            +"' and sem_id='"+feedback.getSemId()
            +"' and status = 1");
    if (rs.next()) 
     i=rs.getInt(1);
    return i;  
    }
    
     
      public float getTotalattendence(Feedback feedback) throws SQLException{
          float i=0f;
           rs= db.executeQuery("select avg(attendance) from studentrecord"
            + " where year='"+feedback.getYear()
            +"' and section='"+feedback.getSection()
            +"' and dept_id='"+feedback.getDeptId()
            +"' and sem_id='"+feedback.getSemId()
            +"' and status = 1");
    if(rs.next())
    {  i= rs.getInt(1);
      i=i*0.01f;
    }
    return i;
    }
      
      
      
      public int setStatus(StudentRecord sr){
        i= db.executeUpdate("update studentrecord set status=1 "
                + "where dept_id='"+sr.getDeptId()+"' "
                + "and sem_id='"+sr.getSemId()+"' "
                + "and year='"+sr.getYear()+"' "
                + "and section='"+sr.getSection()+"' and enrollmentno='"+sr.getEnrollmentNo()+"'");
           return i;
      }
      
      public int clearStatus(Feedback fb){
        i= db.executeUpdate("update studentrecord set status=0 "
                + "where dept_id='"+fb.getDeptId()+"' "
                + "and sem_id='"+fb.getSemId()+"' "
                + "and year='"+fb.getYear()+"' "
                + "and section='"+fb.getSection()+"'");
           return i;
      }
      
      public void insertStudentRecord(StudentRecord sr){
          db.executeUpdate("insert into studentrecord "
          + "values('"+sr.getEnrollmentNo()+"',"
          + "'"+sr.getPassword()+"',"
          + "'"+sr.getAttendence()+"',"
          +sr.getStatus()+","
          + "'"+sr.getSection()+"',"
          + "'"+sr.getYear()+"',"
          + "'"+sr.getSemId()+"',"
          + "'"+sr.getDeptId()+"')");
      }
    
     public void insertAttendence(StudentRecord sr){
         db.executeUpdate("update studentrecord "
         + "set attendance='"+sr.getAttendence()+"' "
         + ",sem_id='"+sr.getSemId()+"'"
         + "where enrollmentno='"+sr.getEnrollmentNo()+"'");
     }
     
     public ResultSet getStudentDetailsForAttendance(StudentRecord sr){
          rs=db.executeQuery("select enrollmentno,attendance ,sem_id from studentrecord "
             + "where sem_id='"+sr.getSemId()+"' "
             + "and year = '"+sr.getYear()+"' "
             + "and section = '"+sr.getSection()+"'"
             + "and dept_id='"+sr.getDeptId()+"'");
         return rs;}
    
     
    public void deleteStudentDetails(String year){
         db.executeUpdate("delete from studentrecord where year='"+year+"'");
     }
     
    public ResultSet getStudentCount(StudentRecord sr){
        rs= db.executeQuery("select totalstu from nostudent"
                + " where dept_id='"+sr.getDeptId()+"' "
                + "and sem_id='"+sr.getSemId()+"' "
                + "and section='"+sr.getSection()+"'"
                + "and year='"+sr.getYear()+"'");
        return rs;
    }
    
    
    public void deleteStudentDetails(StudentRecord sr){
         db.executeUpdate("delete from studentrecord "
                 + "where year='"+sr.getYear()+"' "
                 + "and sem_id='"+sr.getSemId()+"' "
                 + "and dept_id='"+sr.getDeptId()+"' "
                 + "and section='"+sr.getSection()+"'");
     }
     public void updateSemester(StudentRecord sr){
         db.executeUpdate("update studentrecord "
                 + "set sem_id=sem_id+1 "
                 + "where dept_id='"+sr.getDeptId()+"' "
                 + "and Year='"+sr.getYear()+"' "
                 + "and section='"+sr.getSection()+"' "
                 + "and sem_id='"+sr.getSemId()+"'");
     }
}
