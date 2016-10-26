/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feedback.manager;

import com.feedback.bean.LoginCredit;
import com.feedback.bean.StudentRecord;
import com.feedback.connection.DBconnection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Girjesh
 */
public class LoginManager {
    ResultSet rs;
    DBconnection db=DBconnection.getConnection();  
  public LoginCredit getLogin(LoginCredit lc) throws SQLException
    { rs=db.executeQuery("select * from logincredit where user_id='"+
            lc.getUserId()+"' and password ='"+lc.getPassword()
            +"'");
      lc.setUserId(null);   
      lc.setPassword(null); 
      lc.setRole(null);
      while(rs.next())
        {  lc.setRole(rs.getString("role"));
           lc.setUserId(rs.getString("user_id"));
           lc.setPassword(rs.getString("password"));
           lc.setDeptId(rs.getString("dept_id"));
           lc.setSemId(rs.getString("sem_id"));
           lc.setYear(rs.getString("year"));
           lc.setSection(rs.getString("section"));
        }
      return lc; 
    }
    
    public  StudentRecord getStudentLogin(StudentRecord sr) throws SQLException{
        rs= db.executeQuery("select * from studentrecord where enrollmentNo='"+sr.getEnrollmentNo()
                +"' and computerCode ='"+sr.getPassword()+"'");
        sr.setEnrollmentNo(null);
        sr.setPassword(null);
        while(rs.next())
       {  sr.setEnrollmentNo(rs.getString("enrollmentNo"));
          sr.setPassword(rs.getString("computerCode"));
          sr.setSection(rs.getString("section"));
          sr.setDeptId(rs.getString("dept_id"));
          sr.setSemId(rs.getString("sem_id"));
          sr.setYear(rs.getString("year"));
          sr.setAttendence(rs.getString("attendance"));
          sr.setStatus(rs.getBoolean("status"));
      }
      return sr; 
     }
    
}
