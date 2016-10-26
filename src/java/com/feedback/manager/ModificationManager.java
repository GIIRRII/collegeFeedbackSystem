/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feedback.manager;

import com.feedback.bean.Departments;
import com.feedback.bean.FacultyRecord;
import com.feedback.bean.Subject;
import com.feedback.connection.DBconnection;
import java.sql.ResultSet;

/**
 *
 * @author Girjesh
 */
public class ModificationManager {
    DBconnection db = DBconnection.getConnection();
    ResultSet rs;
    int i=0;
   
    public int deleteFaculty(String facultyId)
    {   i = db.executeUpdate("delete from facultyrecord "
            + "where faculty_id='"+facultyId +"'");
        return i;
    }
    public int deleteSubject(String subId,String deptId)
    {   i = db.executeUpdate("delete from subject "
            + "where sub_id='"+subId +"' "
            + "and dept_id='"+deptId+"'");
        return i;
    }
    public int insertFaculty(FacultyRecord fr ){
        i= db.executeUpdate("insert into facultyrecord "
                + "values('"+fr.getFacultyId()+"', "
                + "'"+fr.getFacultyName()+"',"
                + "'"+fr.getDeptId()+"' )");
        return i;
    }
    public int insertSubject(Subject sub){
        i= db.executeUpdate( "insert into subject "
                + "values('"+sub.getSubId()+"',"
                + "'"+sub.getSubName()+"',"
                + "'"+sub.getDeptId()+"',"
                + "'"+sub.getSemId()+"')");
        return i;
    }
    
    public int insertDepartment(Departments dept){
        i= db.executeUpdate("insert into departments "
                + "values('"+dept.getDeptId()+"',"
                + "'"+dept.getDeptName()+"')");
    return i;}
    public int deleteDepartment(String deptId){
        i= db.executeUpdate("delete from departments "
                + "where dept_id='"+deptId+"'");
    return i;}
    
}
