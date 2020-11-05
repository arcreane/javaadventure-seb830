package game;

public class Monstre extends Personnage{
	
	//proprietes
	private String race;
	//public int pointVie;
	public Arme arme = new Arme(" ", 0);

	//construct
	public Monstre(String nom, int pointVie, int maxVie, boolean vivant, String race, Arme arme) {
		super(nom, pointVie, maxVie, vivant);
		this.setRace(race);
		this.setArme(arme);
	}
	public Monstre() {
		
	}
	
	
	//accesseurs
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}

	public int getPointVie() {
		return pointVie;
	}

	public void setPointVie(int pointVie) {
		this.pointVie = pointVie;
	}

	public Arme getArme() {
		return arme;
	}

	public void setArme(Arme arme) {
		this.arme = arme;
	}
	
	//methodes
	public static int randMonstre() {
		int rand =  1 + (int)(Math.random() * ((2- 1) + 1));
		return rand;
	}
	
	
	
	public void attaque(Hero hero) {
		int tour = 0;
		int chance = Arme.randCoup(10);
		int chance2 = Arme.randCoup(3);
		int degat = this.arme.getDegat();
	
		do	{
		if (arme.getNom().equals("eclair")){
			if(chance == 1) {
				System.out.println("Baltazar lance un eclair qui vous paralyse : -" + degat + " points de vie\n");
				System.out.println("il en profite pour vous attaquer de nouveau : -" + degat + " points de vie\n");
				degat = this.arme.getDegat();
				tour ++ ;	
			}else {
				System.out.println("Baltazar vous attaque avec son baton spherique : -" + degat + " points de vie");
				degat = this.arme.getDegat();
				tour++;
			}
		}else if (arme.getNom().equals("hache")){
			if(chance2 == 3) {
				System.out.println("Patrick le barbare vous attaque avec une force prodigieuse, +30% de dégats : -" + degat + " points de vie");	
				degat = this.arme.getDegat() * 100 / 30;
				tour++;
			}else {
				System.out.println("Patrick le barbare vous attaque avec sa hache : -" + degat + " points de vie");
				degat = this.arme.getDegat();
				tour++;
			}
		}
		}while(tour != 1);
	int HeroVie = hero.pointVie;
	HeroVie -= degat;
	hero.setPointVie(HeroVie);
	
	
	System.out.println("  _____________________________________");
	System.out.println(" /____________________________________/|");
    System.out.println("|                                    | |");
    System.out.println("|     VIE ENEMI: "+this.getPointVie()+"                       ");
    System.out.println("|     MORAL : 100                    | |");
    System.out.println("|     VIE BERNARD  : "+hero.getPointVie()+"                  ");
    System.out.println("|     DEGATS : "+ this.arme.getDegat()+"                     | |");
    System.out.println("|                                    | |");
    System.out.println("l____________________________________|/");
	
	}
}