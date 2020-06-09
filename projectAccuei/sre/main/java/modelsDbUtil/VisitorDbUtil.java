/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelsDbUtil;
import java.sql.*;

import java.util.*;    
import models.*;
/**
 *
 * @author Karim_Med_3L9aoui
 */
public class VisitorDbUtil {
    public static boolean addVisitor(Visitor v){
        try {
         String reqsql =     "INSERT INTO `visitor`(`ID`, `Nom`, `Prenom`, `CIN`) VALUES (?,?,?,?)";
         PreparedStatement stp = SingleConnection.getDbConnction().prepareStatement(reqsql);
         stp.setInt(1, v.getID());
         stp.setString(2,v.getNom());
         stp.setString(3,v.getPrenom());
         stp.setString(4,v.getCIN());
         stp.executeUpdate();
         return true;
        } catch (SQLException e) {
            return false;
        }
    }
    
    public static Visitor getById(int id) {
        
        Visitor vs = null;
 
       
        try {
            PreparedStatement st = SingleConnection.getDbConnction().prepareStatement("select * from visitor where ID = ?");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                
                vs = new Visitor(rs.getInt("ID"), rs.getString("Nom"),rs.getString("Prenom"),rs.getString("CIN"));
                
            }
            
            ResultSet rs2 = st.executeQuery("select * from visit v, division s ,responsible r where s.ResponsibleID  = r.ID and v.DivisionID = s.ID and VisitorID = " + vs.getID());
            while (rs2.next()) {
                Visit v = new Visit(rs2.getInt(1), rs2.getString(4), rs2.getDate(5));
                Division s = new Division(rs2.getInt(6),rs2.getString(8));
                s.setResponsible( new Responsible(rs2.getInt(9), rs2.getString(10),rs2.getString(11),rs2.getString(12)));
                v.setDivision(s);
                v.setVisitor(vs);
                vs.addVisit(v);
            }
        
            

            return vs;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public static ArrayList<Visitor> getAll() {
        try {
            ArrayList<Visitor> arrVisitor = new ArrayList<Visitor>();
         

            PreparedStatement st = SingleConnection.getDbConnction().prepareStatement("select * from visitor  ");

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Visitor v = new Visitor(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4));
                
                arrVisitor.add(v);
            }
            for (int i = 0; i < arrVisitor.size(); i++) {
             
         
               ResultSet rs1 = st.executeQuery("select * from visit v , Division s , responsible r where s.ResponsibleID  = r.ID and  v.DivisionID = s.ID and v.VisitorID = ' " + arrVisitor.get(i).getID() + " ' ");
                
                while(rs1.next()){
                  Visit v = new Visit(rs1.getInt(1), rs1.getString(4), rs1.getDate(5));
                Division s = new Division(rs1.getInt(6),rs1.getString(8));
                Responsible rp = new Responsible(rs1.getInt(9), rs1.getString(10),rs1.getString(11),rs1.getString(12));
                s.setResponsible(rp);
                v.setDivision(s);
                v.setVisitor(arrVisitor.get(i));
                arrVisitor.get(i).addVisit(v);
                } 
                
            }
           
            return arrVisitor;

        } catch (SQLException e) {
            e.getStackTrace();
            return null;
        }

    }
    public static boolean delete(int id){
        try {
            PreparedStatement st = SingleConnection.getDbConnction().prepareStatement("DELETE FROM `visitor` WHERE `ID` = ?");
            PreparedStatement st1 = SingleConnection.getDbConnction().prepareStatement("DELETE FROM `visit` WHERE `visitorID` =  ?");
              st.setInt(1, id);
              st1.setInt(1, id);
              st1.executeUpdate();
              st.executeUpdate();
              return true;
            
        } catch (SQLException e) {
            return false;
        }
    }
    public static boolean update(int id, Visitor v ){
             try {
                 PreparedStatement st = SingleConnection.getDbConnction().prepareStatement("UPDATE `visitor` SET `Nom`= ?, `Prenom`= ? , `CIN` = ?  WHERE  ID = ? ");
                 st.setInt(4, id);
                 st.setString(1, v.getNom());
                 st.setString(2, v.getPrenom());
                 st.setString(3, v.getCIN());
                 st.executeUpdate();
                 return true;
            
        } catch (SQLException e) {
            return false;
        }
    
    
    }
   public static void main(String arg[]) {
	   System.out.println(getById(1));
	   
   }
}
