package game;

public class Monstre extends Personnage{
	

	//public int pointVie;
	public Arme arme = new Arme(" ", 0);

	//construct
	public Monstre(String nom, int pointVie, boolean vivant, String race, Arme arme) {
		super(nom, pointVie, vivant, race);
		this.setArme(arme);
	}
	
	//accesseurs

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
		int heroVie = hero.pointVie;
	
		do	
		{
		if (arme.getNom().equals("eclair")){
			if(chance == 1 ) {
				System.out.println("Baltazar lance un eclair qui vous paralyse : -" + degat + " points de vie\n");
				System.out.println("il en profite pour vous attaquer de nouveau : -" + degat + " points de vie\n");
				degat *= 2;
				tour ++;	
			}else {
				System.out.println("Baltazar vous attaque avec son baton spherique : -" + degat + " points de vie");
				tour++;
			}
		}else if (arme.getNom().equals("hache")){
			if(chance2 == 3) {
				degat = this.arme.getDegat() * 100 / 30;
				System.out.println("Patrick le barbare vous attaque avec une force prodigieuse, +30% de dégats : -" + degat + " points de vie");	
				tour++;
			}else {
				degat = this.arme.getDegat();
				System.out.println("Patrick le barbare vous attaque avec sa hache : -" + degat + " points de vie");
				tour++;
			}
		}
		heroVie -= degat;
		hero.setPointVie(heroVie);
		
		if(hero.getPointVie() <= 0) {
			hero.estMort(hero);
		}
		}while(tour != 1 && hero.getPointVie() > 0);
	
	
	//hero.setPointVie(heroVie);
	
	
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