package models;



public class Service {

    
    Chef chef;
    Division division;
    private int ID;
    private String Nom;

    public Service() {
        this.chef = null;
        this.ID = 0;
        this.Nom = null;
        division = null;
        
    }

    public Service( int ID, String Nom) {
        this.ID = ID;
        this.Nom = Nom;
        chef = new Chef();
        division = new Division();
      
    }
    


    public Division getDivision() {
		return division;
	}

	public void setDivision(Division division) {
		this.division = division;
	}

	public Chef getChef() {
        return chef;
    }

    public void setChef(Chef chef) {
        this.chef = chef;
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

   
    
}
