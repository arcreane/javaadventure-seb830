package game;

import java.util.ArrayList;

public class Arme {
	
	//proprietes
	private String nom;
	private int degat;
	
	
	//constructeur
	public Arme(String nom, int degat) {
		this.setNom(nom);
		this.setDegat(degat);
	}

	// getters et setters
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getDegat() {
		return degat;
	}
	public void setDegat(int degat) {
		this.degat = degat;
	}

	
	// methodes
	public static int randCoup(int pourcent) {
		int chance = 1 + (int)(Math.random() * ((pourcent- 1) + 1));
		if(chance == 1) {
		}
		return chance;
	}
}
