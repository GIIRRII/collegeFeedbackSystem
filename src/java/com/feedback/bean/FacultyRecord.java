/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feedback.bean;

import java.io.Serializable;

/**
 *
 * @author Girjesh
 */
public class FacultyRecord implements Serializable {
    private static final long serialversionUID=1;
    String facultyId;
    String facultyName;
    String deptId;

    public String getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(String facultyId) {
        this.facultyId = facultyId;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

  
    
    
}
