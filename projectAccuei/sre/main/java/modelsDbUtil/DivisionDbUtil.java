package modelsDbUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import models.Division;
import models.Responsible;
import models.Service;
import models.Visit;

public class DivisionDbUtil {
	 public static boolean addDivision(Responsible rsp,Division division){

	        try {
	            PreparedStatement st = SingleConnection.getDbConnction().prepareStatement("INSERT INTO `division`(`ID`, `ResponsibleID`, `Nom`) VALUES (?,?,?)");
	            st.setInt(1, division.getID());
	            st.setInt(2, rsp.getID());
	            st.setString(3, division.getNom());
	            st.executeUpdate();
	            return true;
	        } catch (SQLException e) {
	            return false;
	        }
	    }
	 public static Division getByIdResponsible(int id) {
		  
	        Division dv = null;
	        Responsible rsp = null;
	        
	        
	        
	        try {
	            PreparedStatement st = SingleConnection.getDbConnction().prepareStatement("select * from division vs , responsible r where vs.ResponsibleID = r.ID and vs.ResponsibleID = ?");
	            st.setInt(1, id);
	            ResultSet rs = st.executeQuery();
	            while (rs.next()) {
	              rsp = new Responsible(rs.getInt(4),rs.getString(5), rs.getString(6), rs.getString(7));
	              
	              dv = new Division(rs.getInt(1), rs.getString(3));
	            }
	              dv.setResponsible(rsp);
	              PreparedStatement st1 = SingleConnection.getDbConnction().prepareStatement("select * from visit where DivisionID = ?");
		            st1.setInt(1, dv.getID());
		            ResultSet rs1 = st1.executeQuery();
		            while (rs1.next()) {
		            	ArrayList<Visit> arr = new ArrayList<Visit>();
		            	arr.add(VisitDbUtil.getVisitByID(rs1.getInt("ID")));
		            	dv.setVisits(arr);
		            }

	            return dv;

	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }

	    }


	    public static Division getById(int id) {
	  
	        Division dv = null;
	        Responsible rsp = null;
	        
	        
	        
	        try {
	            PreparedStatement st = SingleConnection.getDbConnction().prepareStatement("select * from division vs , responsible r where vs.ResponsibleID = r.ID and vs.ID = ?");
	            st.setInt(1, id);
	            ResultSet rs = st.executeQuery();
	            while (rs.next()) {
	              rsp = new Responsible(rs.getInt(4),rs.getString(4), rs.getString(6), rs.getString(7));
	              
	              dv = new Division(rs.getInt(1), rs.getString(3));
	            }
	              dv.setResponsible(rsp);
	              PreparedStatement st1 = SingleConnection.getDbConnction().prepareStatement("select * from visit where DivisionID = ?");
		            st1.setInt(1, dv.getID());
		            ResultSet rs1 = st1.executeQuery();
		            while (rs1.next()) {
		            	ArrayList<Visit> arr = new ArrayList<Visit>();
		            	arr.add(VisitDbUtil.getVisitByID(rs1.getInt("ID")));
		            	dv.setVisits(arr);
		            }

	            return dv;

	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }

	    }

	    public static ArrayList<Division> getAll() {
	        try {
	            ArrayList<Division> arrSrev = new ArrayList<Division>();
	           
	            PreparedStatement st = SingleConnection.getDbConnction().prepareStatement("select * from division vs , responsible r where vs.ResponsibleID = r.ID ");

	            ResultSet rs = st.executeQuery();

	            while (rs.next()) {
	                Division S = new Division(rs.getInt(1), rs.getString(3));
	                Responsible R = new Responsible(rs.getInt(4),rs.getString(5), rs.getString(6), rs.getString(7));
	                S.setResponsible(R);
	                arrSrev.add(S);
	            }
	            for (int i = 0; i < arrSrev.size(); i++) {
		               Statement st1 = SingleConnection.getDbConnction().createStatement();
		         
		                ResultSet rs1 = st1.executeQuery("select * from visit where DivisionID = "+ arrSrev.get(i).getID());
		                
		                while(rs1.next()){
		                	ArrayList<Visit> arr = new ArrayList<Visit>();
			            	arr.add(VisitDbUtil.getVisitByID(rs1.getInt(1)));
			            	arrSrev.get(i).setVisits(arr);
		                } 
		                
		            }
	            
	         
	            return arrSrev;

	        } catch (SQLException e) {
	            e.getStackTrace();
	            return null;
	        }

	    }
	    public static boolean delete(int id){
	        try {
	            PreparedStatement st = SingleConnection.getDbConnction().prepareStatement("DELETE FROM `division` WHERE `ID` = ?");
	      
	             st.setInt(1, id);
	             
	              st.executeUpdate();
	              return true;
	            
	        } catch (SQLException e) {
	            return false;
	        }
	    }
	    public static boolean updateDivision(int DivisionID, Division s , int RspoID){
	             try {
	                 PreparedStatement st = SingleConnection.getDbConnction().prepareStatement("UPDATE `division` SET  `ResponsibleID`= ?, `Nom`= ? WHERE  ID = ? ");
	                 st.setInt(1, RspoID);
	                 st.setString(2, s.getNom());
	                 st.setInt(3, DivisionID);
	                 st.executeUpdate();
	                 return true;
	            
	        } catch (SQLException e) {
	            return false;
	        }
	  
	    
	    
	    }
	    public static void main(String Arg[]) {
	    	System.out.println(DivisionDbUtil.getById(277));
	    }
}
