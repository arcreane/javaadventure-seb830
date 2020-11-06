package game;

public class Personnage {

	//proprietes
	protected String nom;
	protected int pointVie;
	protected boolean vivant;
	protected String race;
	
		
	//constructs
	public Personnage() {
		this("", 50, true, "");
	}
	public Personnage(String nom, int pointVie, boolean vivant, String race) {
		this.setNom(nom);
		this.setPointVie(pointVie);
		this.setVivant(vivant);
		this.setRace(race);
	}
	
	//accesseurs
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getPointVie() {
		return pointVie;
	}
	public void setPointVie(int pointVie) {
		this.pointVie = pointVie;
	}
	public boolean isVivant() {
		return vivant;
	}
	public void setVivant(boolean vivant) {
		this.vivant = vivant;
	}
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}

   //methodes
	public void estMort(Personnage perso) {
		perso.setPointVie(0);
		perso.setVivant(false);	
		System.out.println(perso.getNom() + " tombe à terre avec : " +perso.getPointVie()+ " points de vie");
		
	}
}
