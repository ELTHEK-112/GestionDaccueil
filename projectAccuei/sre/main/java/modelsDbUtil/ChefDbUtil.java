package modelsDbUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.*;

public class ChefDbUtil {
	  public static boolean add(Chef rp,int pass){
	      
	        try{
	            PreparedStatement st = SingleConnection.getDbConnction().prepareStatement("INSERT INTO `chef`VALUES (?,?,?,?,?)");
	            st.setInt(1, rp.getID());
	            st.setInt(2, pass);
	            st.setString(3, rp.getNom());
	            st.setString(4,rp.getPrenom());
	            st.setString(5, rp.getCin());
	            st.executeUpdate();
	            return true;
	            
	        } catch (SQLException e) {
	            return false;
	        }
	    }

	    public static Chef getById(int id) {
	        Chef rsp = null;
	        try {
	            PreparedStatement ps = SingleConnection.getDbConnction().prepareStatement("select * from chef where ID = ?");
	            ps.setInt(1, id);
	            ResultSet st = ps.executeQuery();
	            while (st.next()) {
	                rsp = new Chef(st.getInt("ID"),st.getString("Nom"), st.getString("Prenom"), st.getString("CIN"));
	            }
	            return rsp;
	        } catch (SQLException e) {
	            return null;
	        }

	    }

	    public static List<Chef> getALL() {
	        List<Chef> listRep = new ArrayList<Chef>();
	        
	        try {
	            PreparedStatement ps = SingleConnection.getDbConnction().prepareStatement("select * from chef ");

	            ResultSet st = ps.executeQuery();
	            while (st.next()) {
	                listRep.add(new Chef(st.getInt("ID"), st.getString("Nom"), st.getString("Prenom"), st.getString("CIN")));
	            }
	            return listRep;

	        } catch (SQLException e) {
	            return null;
	        

	    }
	    }

	    public static boolean deleteResponsible(int id) {
	        try {
	            PreparedStatement ps = SingleConnection.getDbConnction().prepareStatement("DELETE FROM `chef` WHERE `ID` = ?");
	            PreparedStatement ps1 = SingleConnection.getDbConnction().prepareStatement("DELETE FROM `service` WHERE `ChefID`= ?");
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
	            PreparedStatement ps = SingleConnection.getDbConnction().prepareStatement("UPDATE `chef` SET `Nom`=?,`Prenom`=?,`CIN`=? WHERE `ID`= ?");
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
    	
System.out.println(getById(1));
	    }
}
