package models;


import java.util.*;

public class Visitor {

                 ArrayList<Visit> visit;
	private int ID;
	private String Nom;
	private String prenom;
	private String CIN;
     public Visitor() {
        this.ID = 0;
        this.Nom = null;
        this.prenom = null;
        this.CIN = null;
        visit = null;
    }

    public Visitor(int ID, String Nom, String prenom, String CIN) {
        this.ID = ID;
        this.Nom = Nom;
        this.prenom = prenom;
        this.CIN = CIN;
        visit = new ArrayList<Visit>();
    }

    public ArrayList<Visit> getVisit() {
        return visit;
    }

    public void setVisit(ArrayList<Visit> visit) {
        this.visit = visit;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCIN() {
        return CIN;
    }

    public void setCIN(String CIN) {
        this.CIN = CIN;
    }

    @Override
    public String toString() {
       String s= "Visitor{ ID=" + ID + ", Nom=" + Nom + ", prenom=" + prenom + ", CIN=" + CIN + "}\n";
          for(Visit list : visit) s=s+"Les Visites :" + list.toString() + "\n";
        return s;
    }
       public boolean addVisit(Visit v){
     
     return visit.add(v);
     
     }
    
     public Visit deleteVisit(int index){
              if (index > visit.size() && index <= 0 )
                  return null ;
              else {
                       index--;
                       return visit.remove(index);
              }
     }
     public boolean SerchVisit(Visit v){
         for (Visit list : visit){
           if (v.getID() == list.getID())
               return true;
           else 
               return false;
         }
         return false;
     }
     public Visit SerchVisit(int id){
     
      for (Visit list : visit){
           if (list.getID() == id)
               return list;
           else 
               return null;
         }
         return null;
     
     }
      public Visit getVisit(int index){
      
      if (index > visit.size() && index <= 0 )
                       return null ;
              else {
                      index =  index - 1;
                       return visit.get(index);
              }
      
      }
    
        
}
