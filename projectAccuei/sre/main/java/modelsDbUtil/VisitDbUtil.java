/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelsDbUtil;
import models.*
;
import java.util.*;

import java.sql.*;
import java.sql.Date;
/**
 *
 * @author Karim_Med_3L9aoui
 */
public class VisitDbUtil {
    public static boolean addVisit(Visit v,Visitor vstr,Division s){
        try {
            PreparedStatement st = SingleConnection.getDbConnction().prepareStatement("INSERT INTO `visit`(`ID`, `DivisionID`, `VisitorID`, `Etat`, `Date`) VALUES (?,?,?,?,?)");
            st.setInt(1, v.getID());
            st.setInt(2, s.getID());
            st.setInt(3, vstr.getID());
            st.setString(4, v.getEtat());
            java.sql.Date date = new java.sql.Date(v.getDate().getTime());
            
            st.setDate(5,date);
            
            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();
            return false;
        }
    }
    
   public static Visit getVisitByID(int id){
       Visit vs = null;
       try {
           PreparedStatement st = SingleConnection.getDbConnction().prepareStatement("select * from visit v,visitor vs,division s where v.VisitorID = vs.ID and v.DivisionID = s.ID and v.ID = ?");
           st.setInt(1, id);
           ResultSet rs = st.executeQuery();
           while(rs.next()){
            vs = new Visit(rs.getInt(1), rs.getString(4), rs.getDate(5));
            vs.setDivision(new Division(rs.getInt(10),rs.getString(12)));
            vs.setVisitor(new Visitor(rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9)));
           }
           return vs;
           
       } catch (SQLException e) {
           return null;   
       }   
   }
    public static ArrayList<Visit> getAll(){
      ArrayList<Visit> listVisit = new ArrayList<Visit>();
              try {
           PreparedStatement st = SingleConnection.getDbConnction().prepareStatement("select * from visit v,visitor vs,division s where v.VisitorID = vs.ID and v.DivisionID = s.ID");
          
           ResultSet rs = st.executeQuery();
           while(rs.next()){
          Visit   vs = new Visit(rs.getInt(1), rs.getString(4), rs.getDate(5));
            vs.setDivision(new Division(rs.getInt(10),rs.getString(12)));
            vs.setVisitor(new Visitor(rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9)));
            listVisit.add(vs);
           }
           return listVisit;
           
       } catch (SQLException e) {
           return null;   
       }   
    }
    public static boolean deleteVisit(int id){
     try {
           PreparedStatement st = SingleConnection.getDbConnction().prepareStatement("DELETE FROM `visit` WHERE  ID = ?");
           st.setInt(1, id);
            st.executeUpdate();
            return true;
            } catch (SQLException e) {
                return false;
       }  
    }
    public static boolean updteVisit(Visit vst , int id,Visitor v,Division div){
    	
    	
    	try {
            PreparedStatement st = SingleConnection.getDbConnction().prepareStatement("UPDATE `visit` SET `DivisionID`=?,`VisitorID`=?,`Etat`=?,`Date`=? WHERE ID = ? ");
            st.setInt(5, id);
            st.setInt(1, div.getID());
            st.setInt(2, v.getID());
            st.setString(3, vst.getEtat());
            st.setDate(4, new java.sql.Date(vst.getDate().getTime()));
            st.executeUpdate();
            return true;
       
   } catch (SQLException e) {
       return false;
   }
     
       }  
    

    public static  void main(String Arg[]) {
    	  System.out.println(getVisitByID(1));
    
    } 
}
