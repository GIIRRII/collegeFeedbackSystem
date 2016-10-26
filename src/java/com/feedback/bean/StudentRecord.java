/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feedback.bean;

/**
 *
 * @author Girjesh
 */
public class StudentRecord {
    String enrollmentNo;
    String password;
    String attendence;
    String section;
    String year;
    String deptId;
    String semId;
    boolean status;

    public String getEnrollmentNo() {
        return enrollmentNo;
    }

    public void setEnrollmentNo(String enrollmentNo) {
        this.enrollmentNo = enrollmentNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAttendence() {
        return attendence;
    }

    public void setAttendence(String attendence) {
        this.attendence = attendence;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getSemId() {
        return semId;
    }

    public void setSemId(String semId) {
        this.semId = semId;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
}
