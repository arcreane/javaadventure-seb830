package game;

import java.util.Scanner;

public class Game {
	
	
	public boolean starting = false;

	public void playing() {
		
		//message d'introduction
		while(!starting) {
			
			System.out.println("________________________________________");
			System.out.println("\\             Votre mission             \\");
			System.out.println(" \\  Votre roi Ferdinand IV vous confie   \\");
			System.out.println("  \\ la tache de lui rapporter le tresor   \\");
			System.out.println("   \\ des magiciens du donjon.              \\");
			System.out.println("    /  Trouverez la force et le courage     / ");
			System.out.println("   /    pour tuer les vos enemis?          / ");
			System.out.println("  /   e - entrer   q - battre en retraite /");
			System.out.println(" /_______________________________________/");
			scanner();
			
			
		}
	}
	
	//entrée utilisateur intro
	public String scanner() {
		Scanner scan = new Scanner(System.in);
		String choice = scan.nextLine();	
			
		do {
			
		if(choice.equals("e")){
			initGame();
			starting = true;
			break;
			
		}else if(choice.equals("q")) {
			System.out.println("Vous repartez sur vos terre, votre roi ne sera pas fier de vous");
			starting = true;
			break;	
		}else {
			System.out.println("Vous n\'avez que deux solutions, décidez vous");
			break;
			
		}
		}while(!choice.equals("e") || !choice.equals("q"));
		return choice;
	}
	
	public void initGame() {
			//création d'un hero
			Hero player1 = new Hero("Bernard", 100, true, "Chevalier");
			
			System.out.println("Vous ouvrez la porte du Donjon et entrez dans une salle.... ");
			stage(player1);
	}

	//entrée utilisateur pour le deroulement du combat
	public void scannerCombat() {
		Scanner scan = new Scanner(System.in);
		String ok = scan.nextLine();	
			
		while(!ok.equals("n")) {
		System.out.println("mauvais commande");
		break;
		}
	}
	
	//entree utilisateur pour le choix de l'arme
	public String scanArme() {
		Scanner scan = new Scanner(System.in);
		String choixArme = scan.nextLine();
		 
		do{ 
			if(!choixArme.equals("epee") || !choixArme.equals("fiole")) {
				System.out.println("");
				break;
				
			}else {
				System.out.println("mauvaise commande");
				break;
			}
		}while(!choixArme.equals("epee") || choixArme.equals("fiole"));
		return choixArme;
	}
	
	
	//deroulement du jeu
	public void stage(Hero player1) {
		
	if(starting =true)	
	{
		//creation donjon
		Donjon donjon = new Donjon(1);
		int salle = donjon.getSalle();
		
		for(int i = salle; i < salle + 5; i ++) 
		{
			System.out.println(" ______________________________");
			System.out.println("|                              |");
			System.out.println("             SALLE " + i      	 );
			System.out.println("|______________________________|\n");
			int rand = Monstre.randMonstre();
		//creation monstre aleatoirement
		if(rand == 1) {
			Monstre monstre = new Monstre("baltazar", 20, true, "magicien", new Arme("eclair", 8));
			do{
				
				monstre.attaque(player1);
				System.out.println("tour suivant - appuyez sur la touche n");
				scannerCombat();
				
				System.out.println("Entrer le nom de l'arme à utiliser : epee ou fiole");
				String choixArme = scanArme();
				
				//Choix de l'arme 
				if(choixArme.equals("fiole")) {
					player1.attaque(monstre);
					System.out.println("tour suivant - appuyez sur la touche n");
					scannerCombat();
				}else {
					System.out.println("Votre coup à echoué");
				}	
				
				//si mort  du hero ou du monstre
				if(player1.getPointVie() <= 0){
					player1.estMort(player1);
					Game.afficheFin();
					System.exit(1);
								
				}else if(monstre.getPointVie() <= 0) {
					//monstre.estMort(monstre);
					System.out.println("Vous parvenez à vous débarasser du magicien et avancez dans la salle numero " + (i + 1));
					break;
			  }	
			}while(player1.getPointVie() > 0 && monstre.getPointVie() > 0);	
		
		}else if(rand == 2){
			Monstre monstre = new Monstre("patrick", 20, true, "barbare", new Arme("hache", 5));
			do
			{
				monstre.attaque(player1);
				System.out.println("tour suivant - appuyez sur la touche n");
				scannerCombat();
				System.out.println("Entrer le nom de l'arme à utiliser : epee ou fiole");
				String choixArme = scanArme();
				
				if(choixArme.equals("epee")) {
					player1.attaque(monstre);
					System.out.println("tour suivant - appuyez sur la touche n");
					scannerCombat();
				}else {
					System.out.println("Votre coup à echoué");
				}
				
				if(player1.getPointVie() <= 0){
					player1.estMort(player1);
					Game.afficheFin();
					System.exit(1);
					
				}else if(monstre.getPointVie() <= 0) {
					System.out.println("Vous tuez le barbare et avancez dans la salle numero " + (i+1));
					break;
				}
		   }while(player1.getPointVie() > 0 && monstre.getPointVie() > 0);
		}
	  }
	}	
	//fin du jeu si toutes les salles sont affichées
	if(player1.vivant = true) {
		System.out.println("Vous entrez dans la Derniere salle du donjon et decouvez le tresor\n");	
		afficheTresor();
	}
}
	
	public static void afficheFin() {
		System.out.println("     ____________");
		System.out.println("    |	         |");
		System.out.println("    |     FIN    |");
		System.out.println("    |____________|");
	
	}	
	public static void afficheTresor() {
		
		System.out.println("   _____________  ");
		System.out.println("  |____________|\\  ");
		System.out.println("  \\             \\\\");
		System.out.println("   \\_____________\\\\");
		System.out.println("    /_____________/|");
		System.out.println("    |	  °      | |");
		System.out.println("    |   tré$or   | |");
		System.out.println("    |____________|/");
		
	}
}
