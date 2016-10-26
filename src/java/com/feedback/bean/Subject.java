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
public class Subject implements Serializable {
    String subId;
    String subName;
    String deptId;

    public String getSemId() {
        return semId;
    }

    public void setSemId(String semId) {
        this.semId = semId;
    }
    String semId;

    public String getSubId() {
        return subId;
    }

    public void setSubId(String subId) {
        this.subId = subId;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }
    
}
