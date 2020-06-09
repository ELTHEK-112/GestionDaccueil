package models;



import java.util.ArrayList;

public class Division {
	ArrayList<Visit> visits;
	ArrayList<Service> services ;
	Responsible responsible;
   private int ID;
   private String Nom;
   
public Division() {
	
}
public Division( int iD, String nom) {
	super();
	this.visits = new ArrayList<Visit>();
	this.services = new ArrayList<Service>();
	ID = iD;
	Nom = nom;
}

public Responsible getResponsible() {
	return responsible;
}
public void setResponsible(Responsible rsp) {
	this.responsible = rsp;
}
public ArrayList<Visit> getVisits() {
	return visits;
}
public void setVisits(ArrayList<Visit> visits) {
	this.visits = visits;
}
public ArrayList<Service> getServices() {
	return services;
}
public void setServices(ArrayList<Service> services) {
	this.services = services;
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
   
   
}
