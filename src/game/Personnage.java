package game;

public class Personnage {

	//proprietes
	protected String nom;
	protected int pointVie;
	protected int maxVie;
	public boolean vivant;
	public static boolean playTour;
	
		
	//constructs
	public Personnage() {
		this("", 50, 50, true);
	}
	public Personnage(String nom, int pointVie, int maxVie, boolean vivant) {
		this.setNom(nom);
		this.setPointVie(pointVie);
		this.setMaxVie(maxVie);
		this.setVivant(vivant);
		
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
	public int getMaxVie() {
		return maxVie;
	}
	public void setMaxVie(int maxVie) {
		this.maxVie = maxVie;
	}
	public boolean isVivant() {
		return vivant;
	}
	public void setVivant(boolean vivant) {
		this.vivant = vivant;
	}

   //methodes
	public boolean estMort(Personnage perso) {
		if(perso.getPointVie() <= 0) {
			setPointVie(0);
			setVivant(this.vivant = false);
			System.out.println(perso.nom + " est mort");
		}return this.vivant;
	}
}
