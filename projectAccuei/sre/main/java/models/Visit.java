package models;


import java.util.*;

public class Visit {

    Visitor Visitor;
    Division division;
    private int ID;
    private String etat;
    private Date date;

    public Visit() {
        this.ID = 0;
        this.etat = null; 
        this.date = new Date();
    }

    public Visit( int ID, String etat,Date date) {
        this.ID = ID;
        this.etat = etat;
         this.date = date;
       
    }

    public Visitor getVisitor() {
        return Visitor;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    

    public void setVisitor(Visitor Visitor) {
        this.Visitor = Visitor;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division Service) {
        this.division = Service;
    }
    

	public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "Visit{" + "ID=" + ID + ", etat=" + etat + ", date=" + date + '}';
    }
    
}
