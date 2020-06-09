/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelsDbUtil;

import models.*;
import java.util.*;
import java.sql.*;

/**
 *
 * @author Karim_Med_3L9aoui
 */
public class ServiceDbutil {
    public static boolean addService(Service service,Chef chef,Division division){
    	
    	Chef chf =chef;
    	Service s = service;
    	Division dv = division;
    	
        try {
            PreparedStatement st = SingleConnection.getDbConnction().prepareStatement("INSERT INTO `service`(`ID`, `ChefID`,`DivisionID`, `Nom`) VALUES (?,?,?,?)");
            st.setInt(1, s.getID());
            st.setInt(2, chf.getID());
            st.setInt(3, dv.getID());
            st.setString(4, s.getNom());
            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public static Service getById(int id) {
        Service sv = null;
        try {
            PreparedStatement st = SingleConnection.getDbConnction().prepareStatement("select * from service v , division vs , responsible r,chef c where c.ID=v.ChefID and vs.ResponsibleID = r.ID and v.DivisionID = vs.ID and v.ID = ?");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
            Responsible  rsp = new Responsible(rs.getInt(8),rs.getString(9), rs.getString(10), rs.getString(11));
             Chef rp = new Chef(rs.getInt(12),rs.getString(13), rs.getString(14), rs.getString(15));
           Division   dv = new Division(rs.getInt(5), rs.getString(7));
              sv=new Service(rs.getInt(1), rs.getString(4));
              sv.setChef(rp);sv.setDivision(dv);sv.getDivision().setResponsible(rsp);

            }
            
            return sv;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
    public static Service getByName(String name) {
        Service sv = null;
        try {
            PreparedStatement st = SingleConnection.getDbConnction().prepareStatement("select * from service v , division vs , responsible r,chef c where c.ID=v.ChefID and vs.ResponsibleID = r.ID and v.DivisionID = vs.ID and v.Nom like ?");
            st.setString(1, name);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
            Responsible  rsp = new Responsible(rs.getInt(8),rs.getString(9), rs.getString(10), rs.getString(11));
             Chef rp = new Chef(rs.getInt(12),rs.getString(13), rs.getString(14), rs.getString(15));
           Division   dv = new Division(rs.getInt(5), rs.getString(7));
              sv=new Service(rs.getInt(1), rs.getString(4));
              sv.setChef(rp);sv.setDivision(dv);sv.getDivision().setResponsible(rsp);

            }
            
            return sv;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }


    public static ArrayList<Service> getAll() {
        try {
            ArrayList<Service> arrSrev = new ArrayList<Service>();
           
            PreparedStatement st = SingleConnection.getDbConnction().prepareStatement("select * from service s,chef r where r.ID = s.ChefID ");

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Service S = new Service(rs.getInt(1), rs.getString(4));
                Chef R = new Chef(rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8));
                S.setChef(R);
                arrSrev.add(S);
            }
            
            for (int i = 0; i < arrSrev.size(); i++) {
               Statement st1 = SingleConnection.getDbConnction().createStatement();
         
                ResultSet rs1 = st1.executeQuery("select * from service v , division vs , responsible r where vs.ResponsibleID = r.ID and v.DivisionID = vs.ID and v.ID = ' " + arrSrev.get(i).getID() + " ' ");
                
                while(rs1.next()){
                	Division d = new Division(rs1.getInt(5),rs1.getString(7));
                	d.setResponsible(new Responsible(rs1.getInt(8),rs1.getString(9),rs1.getString(10),rs1.getString(11)));
                } 
                
            }
            return arrSrev;

        } catch (SQLException e) {
            e.getStackTrace();
            return null;
        }

    }
    public static boolean deleteService(int id){
        try {
            PreparedStatement st = SingleConnection.getDbConnction().prepareStatement("DELETE FROM `service` WHERE `ID` = ?");
      
             st.setInt(1, id);
             
              st.executeUpdate();
              return true;
            
        } catch (SQLException e) {
            return false;
        }
    }
    public static boolean updateService(int serviceID, Service s , int ChefID,int divisionID){
             try {
                 PreparedStatement st = SingleConnection.getDbConnction().prepareStatement("UPDATE `service` SET DivisionID = ? , `ResponsibleID`= ?, `Nom`= ? WHERE  ID = ? ");
                 st.setInt(1, divisionID);
                 st.setInt(2, ChefID);
                 st.setString(3, s.getNom());
                 st.setInt(4, serviceID);
                 st.executeUpdate();
                 return true;
            
        } catch (SQLException e) {
            return false;
        }
  
    
    
    }
  public static void main(String Arg[]){
    	
    System.out.println(addService(new Service(6,"wwwww"), ChefDbUtil.getById(1), DivisionDbUtil.getById(23) ));
    }
}
