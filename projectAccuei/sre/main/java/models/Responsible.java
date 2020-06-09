package models;


public class Responsible {

	private int ID;
	private String Nom;
	private String Prenom;
	private String CIN;

    public Responsible(int ID, String Nom, String Prenom, String CIN) {
        this.ID = ID;
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.CIN = CIN;
       
    }

  public  Responsible() {
       this.ID = 0;
        this.Nom = null;
        this.Prenom = null;
       this.CIN = null;
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
        return Prenom;
    }

    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    public String getCIN() {
        return CIN;
    }

    public void setCIN(String CIN) {
        this.CIN = CIN;
    }

    @Override
    public String toString() {
        return "Responsible{" + " CIN=" + CIN +", ID=" + ID + ", Nom=" + Nom + ", Prenom=" + Prenom +'}';
    }
        
    
    public static void  main(String ARg[]){
    	
    	String s = "23";
    	int i = Integer.parseInt(s);
    	System.out.println(i);
    	
    	
    }

    
}
