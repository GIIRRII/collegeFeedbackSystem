/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feedback.manager;

import com.feedback.bean.LoginCredit;
import com.feedback.connection.DBconnection;

/**
 *
 * @author Girjesh
 */
public class PasswordManager {
    DBconnection db = DBconnection.getConnection();
    int i=0;
    public int updatePassword(LoginCredit lc,String newpass){
        i=db.executeUpdate("update logincredit set password='"+
                newpass+"' where user_id='"+lc.getUserId()+"' and role='"+lc.getRole()+"'");
        return i;
    }
    
}
