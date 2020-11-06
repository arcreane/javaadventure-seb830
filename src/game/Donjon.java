package game;

public class Donjon {
	
	
	private int salle;
	

	public Donjon(int salle) {
		this.setSalle(salle);
	}
	
	public int getSalle() {
		return salle;
	}
	public void setSalle(int salle) {
		this.salle = salle;
	}
	
	//methodes 
	
	//evenements salles
	public void potionVie(Hero hero) {
		int vie = hero.getPointVie();
		vie += 20;
		hero.setPointVie(20);
		System.out.println("Vous buvez une potion préparée par un enchanteur et récuperez de la vie : + 20 points de vie" );
	}
	public void sortilege(Hero monstre) {
		int vie = monstre.getPointVie();
		vie /= 2;
		monstre.setPointVie(vie);
		System.out.println("Vous récitez un sortilège de magie qui diminue la vie enemie de moitié : + " + vie);
	}	
	
}
