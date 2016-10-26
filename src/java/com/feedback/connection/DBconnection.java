/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feedback.connection;

import com.feedback.bean.Feedback;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Girjesh
 */
   public  class DBconnection{
   private static String driver="com.mysql.jdbc.Driver";
   private static String url="jdbc:mysql://localhost:3306/feedbackdata";
   private static String uname="root";
   private static String psw="root";
   private  ResultSet rs;
   private static Statement st;
   static Connection con;
   static PreparedStatement prs;
   private static DBconnection connl=null;
   private DBconnection()
   {  
       try{ 
         Class.forName(driver);
         con=DriverManager.getConnection(url,uname,psw);
         st=con.createStatement();
         }
      catch(Exception ex)
      {ex.printStackTrace();
     }
  }
   /* This Method Is Used to Get Connection To MySqlDataBase */
   public static DBconnection getConnection()
   {  if(connl== null)
       { connl=new DBconnection();
       }
      return connl;
   }
   /* This Method Is Used For Insert,Update,Delete Statement or Query */
   public int executeUpdate(String query) 
   {  int i = 0;
        try {
            i=st.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE, null, ex);
        }
      return i;
   }
   /* This Method Is Used For Select Statement or Query */
   public  ResultSet executeQuery(String query)
   {    try {
            rs = st.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
   }
   
   public void executeQuery(String query, Feedback fb ) throws SQLException{
       
       prs = con.prepareStatement(query);
       prs.setString(1, fb.getSubCode());
       prs.setString(2, fb.getSubName());
       prs.setString(3, fb.getFacultyName());
       prs.setString(4, fb.getSemId());
       prs.setString(5, fb.getDeptId());
       prs.setString(6, fb.getYear());
       prs.setString(7, fb.getUnableToJudge());
       prs.setString(8, fb.getPersonality());
       prs.setString(9, fb.getMethodOfTeaching());
       prs.setString(10, fb.getKnowledgeOfSubject());
       prs.setString(11, fb.getCommunicationSkills());
       prs.setString(12, fb.getSection());
       prs.executeUpdate();
}
   }
