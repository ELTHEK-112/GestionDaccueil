/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelsDbUtil;

import java.sql.*;
import models.*;
import java.util.*;

/**
 *
 * @author Karim_Med_3L9aoui
 */
public class ResponsibleDbUtil {
    public static boolean addResponsible(Responsible rp){
      
        try{
            PreparedStatement st = SingleConnection.getDbConnction().prepareStatement("INSERT INTO `responsible` VALUES (?,?,?,?)");
            st.setInt(1, rp.getID());
            
            st.setString(2, rp.getNom());
            st.setString(3,rp.getPrenom());
            st.setString(4, rp.getCIN());
            st.executeUpdate();
            return true;
            
        } catch (SQLException e) {
            return false;
        }
    }

    public static Responsible getResponsibleById(int id) {
        Responsible rsp = null;
        try {
            PreparedStatement ps = SingleConnection.getDbConnction().prepareStatement("select * from responsible where ID = ?");
            ps.setInt(1, id);
            ResultSet st = ps.executeQuery();
            while (st.next()) {
                rsp = new Responsible(st.getInt("ID"), st.getString("Nom"), st.getString("Prenom"), st.getString("CIN"));
            }
            return rsp;
        } catch (SQLException e) {
            return null;
        }

    }
    public static Responsible getResponsibleByPass(int password) {
        Responsible rsp = null;
        try {
            PreparedStatement ps = SingleConnection.getDbConnction().prepareStatement("select * from responsible where password = ?");
            ps.setInt(1, password);
            ResultSet st = ps.executeQuery();
            while (st.next()) {
                rsp = new Responsible(st.getInt("ID"), st.getString("Nom"), st.getString("Prenom"), st.getString("CIN"));
            }
            return rsp;
        } catch (SQLException e) {
            return null;
        }

    }

    public static List<Responsible> getALL() {
        List<Responsible> listRep = new ArrayList<Responsible>();
        
        try {
            PreparedStatement ps = SingleConnection.getDbConnction().prepareStatement("select * from responsible ");

            ResultSet st = ps.executeQuery();
            while (st.next()) {
                listRep.add(new Responsible(st.getInt("ID"), st.getString("Nom"), st.getString("Prenom"), st.getString("CIN")));
            }
            return listRep;

        } catch (SQLException e) {
            return null;
        

    }
    }

    public static boolean deleteResponsible(int id) {
        try {
            PreparedStatement ps = SingleConnection.getDbConnction().prepareStatement("DELETE FROM `responsible` WHERE `ID` = ?");
            PreparedStatement ps1 = SingleConnection.getDbConnction().prepareStatement("DELETE FROM `division` WHERE `ResponsibleID`= ?");
            ps.setInt(1, id);
            ps1.setInt(1, id);
            ps1.executeUpdate();
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            return false;
        }
    }

    public static boolean updatResponsible(int id, Responsible rp) {

        try {
            PreparedStatement ps = SingleConnection.getDbConnction().prepareStatement("UPDATE `responsible` SET `Nom`=?,`Prenom`=?,`CIN`=? WHERE `ID`= ?");
            ps.setInt(4, id);
            ps.setString(1, rp.getNom());
            ps.setString(2, rp.getPrenom());
            ps.setString(3, rp.getCIN());

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }

    }
    public static void main(String arg[]) {
    	System.out.println(getResponsibleById(2));

    }
}
