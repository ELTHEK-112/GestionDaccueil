/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelsDbUtil;
import java.sql.*;

import jdk.internal.dynalink.beans.StaticClass;

/**
 *
 * @author Karim_Med_3L9aoui
 */
public class SingleConnection {
    private static Connection connector = null;
    //public static SingleConnect dbConnectoin;
    
     
     private SingleConnection(){
    	 try {
    		             Class.forName("com.mysql.jdbc.Driver");
                         connector = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectstage","root","");
		} catch (Exception e) {
			e.printStackTrace();
		}
     }
     
     public static Connection getDbConnction(){
    	 if(connector == null)  new SingleConnection();
    	 return connector;
     }
     public static ResultSet readQury(String req) {
    	     try {
    	    	 Statement st = getDbConnction().createStatement();
    	    	 return st.executeQuery(req);
    	    	 
				
			} catch (SQLException e) {
				return null;
			}
    	 
    	 
     }
     
     
}
