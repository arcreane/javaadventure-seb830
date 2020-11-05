package game;

public class Donjon {
	
	private int salle;
	private boolean inside;
	
	public Donjon(int salle, boolean inside) {
		this.setSalle(salle);
		this.setInside(inside);
	}
	// construction du donjon avec 6 salles 
	public Donjon() {
		this(6, false);
	}
	
	
	public int getSalle() {
		return salle;
	}

	public void setSalle(int salle) {
		this.salle = salle;
	}


	public boolean isInside() {
		return inside;
	}

	public void setInside(boolean inside) {
		this.inside = inside;
	}

	
	public void initDonjon() {
	}
	
	
	
	
	
	
	
	
	
	
}
