package models;

public class Chef {
  private int ID;
  private String Nom,Prenom,cin;
  public Chef() {
		ID = 0;
		Nom = null;
		Prenom = null;
		this.cin = null;
	}
public Chef(int iD,String nom, String prenom, String cin) {
	ID = iD;
	Nom = nom;
	Prenom = prenom;

	this.cin = cin;
}
public int getID() {
	return ID;
}
public void setID(int iD) {
	ID = iD;
}
public String getNom() {
	return Nom;
}
public void setNom(String nom) {
	Nom = nom;
}
public String getPrenom() {
	return Prenom;
}
public void setPrenom(String prenom) {
	Prenom = prenom;
}
public String getCin() {
	return cin;
}
public void setCin(String cin) {
	this.cin = cin;
}

  
}
