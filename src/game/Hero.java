package game;

import game.Monstre;

public class Hero  extends Personnage{

	//proprietes
	public Arme arme[]  = {new Arme("épée", 10), new Arme("fiole flasque", 8)};
	//construct
	public Hero(String nom, int pointVie, boolean vivant, String race) {
		super(nom, pointVie, vivant, race);
	}

	
	//methodes
	public void attaque(Monstre monster) {
		int tour = 0;
		int chance = Arme.randCoup(10);
		int chance2 = Arme.randCoup(3);
		int degat = 0;
		int monstreVie = monster.getPointVie();
		
		do
		{
		if(monster.getRace().equals("barbare"))
			{
			if(chance == 1) {
				degat = this.arme[0].getDegat() *  2;
				System.out.println("Bernard a visé la tête, patrick le barbare est sonné.. -" +degat+ " points de vie");
				System.out.println("Bernard en profite pour l'attaquer de nouveau -"+degat+ " points de vie");
				tour++;
			}else {
				degat = this.arme[0].getDegat();
				System.out.println("Vous avez touché le barbare : -" +degat+ " points de vie");
				tour ++;
				}
		}else if (monster.getRace().equals("magicien") && monster.getPointVie() > 0)
				{
				if(chance2 == 3) {
					degat = this.arme[1].getDegat() + (this.arme[1].getDegat() * 100 / 30);
					System.out.println("Votre concentration vous permet de mieux viser et d'augmenter les degats de 30% : -" +degat+ " points de vie");	
					tour++;		
				}else {
					degat = this.arme[1].getDegat();
					System.out.println("Vous avez touché le magicien : -" +degat+ " points de vie");	
					tour++;
				}
	}
		monstreVie -= degat;
		monster.setPointVie(monstreVie);
		if(monster.getPointVie() <= 0) {
			monster.estMort(monster);
		}
	}while(tour != 1 && monster.getPointVie() > 0);
		
		
		

		System.out.println("  _____________________________________");
		System.out.println(" /____________________________________/|");
        System.out.println("|                                    | |");
        System.out.println("|     VIE BERNARD: "+this.getPointVie()+"                       ");
        System.out.println("|     MORAL : 100                    | |");
        System.out.println("|     VIE ENEMI: "+monster.getPointVie()+"                 ");
        System.out.println("|     DEGATS : "+ degat +"                    | |");
        System.out.println("|                                    | |");
        System.out.println("l____________________________________|/");		
	}
	
}
