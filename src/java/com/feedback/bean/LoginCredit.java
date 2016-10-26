/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feedback.bean;

/**
 *
 * @author Girjesh
 */
public class LoginCredit {
    String userId;
    String password;
    String role;
    String deptId;
    String semId;
    String year;
    String section;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDeptId() {
        return deptId;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
    
    
}
