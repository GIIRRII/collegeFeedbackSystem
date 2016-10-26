/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feedback.manager;

import com.feedback.connection.DBconnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Girjesh
 */
public class GeneralDataManager {
    ResultSet rs;
    DBconnection db = DBconnection.getConnection();
    PreparedStatement pstmt;
    String deptName = null,semName= null;
    public ResultSet getBatch(){
        
       rs= db.executeQuery("select * from Year order by year");
        return rs;
    }
    public ResultSet getSection(){
           rs=db.executeQuery("select * from section");
        return rs;
    }
   
    public ResultSet getSemester(){
        
        rs= db.executeQuery("select * from semester order by sem_name");
        
        return rs;
    }
     
    public ResultSet getDepartment(){
       rs= db.executeQuery("select * from departments order by dept_name ");
   return rs;
   }
   
   public ResultSet getFaculty()
   {
        rs = db.executeQuery("select * from facultyrecord order by faculty_name");
        return rs;
   }
    public ResultSet getFaculty(String deptId)
    {  
        rs = db.executeQuery("select faculty_id ,"
                + " faculty_name from facultyrecord "
                + "where dept_id='"+deptId+"' order by faculty_name");
        return rs;
    }
    
    public ResultSet getSubject(String deptId)
    {  rs = db.executeQuery("select sub_id , sub_name "
            + "from subject where dept_id='"+deptId+"' "
            + "order by sub_id");
       return rs;
    }
    public ResultSet getSubject(){
       rs = db.executeQuery("select * from facultyrecord order by faculty_name");
        return rs;
    }
    
    public String getDepartmentName(String deptId) throws SQLException{
     rs = db.executeQuery("select dept_name from departments where dept_id='"+deptId+"'");
             if(rs.next()){
            deptName=rs.getString(1);
           }
       
     return deptName;
    }
    
     public String getSemName(String semId) throws SQLException{
     rs = db.executeQuery("select sem_name from semester where sem_id='"+semId+"'");
             if(rs.next()){
            semName=rs.getString(1);
            }
         return semName;
    }
     
     public int inserYear(String year){
   int i=  db.executeUpdate("insert into year values('"+year+"')");
   return i;
     }
  
}
