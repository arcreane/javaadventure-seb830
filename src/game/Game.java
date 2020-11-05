package game;

import java.util.Scanner;

public class Game {
	
	public boolean starting = false;
	
	
	
	public void playing() {
		
		while(!starting) {
			System.out.println(" ________________________________________");
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
			
		}
		}while(!choice.equals("e") || !choice.equals("q"));
		return choice;
	}
	
	public void initGame() {
			//Donjon donjon = new Donjon(6, false);
			Hero player1 = new Hero("Bernard", 50, false, "Chevalier");
			System.out.println("Vous ouvrez la porte du Donjon et entrez dans une salle.... ");
			stage(player1);
	}

	public void scannerCombat() {
		Scanner scan = new Scanner(System.in);
		String ok = scan.nextLine();	
			
		do {
			if(!ok.equals("n")){
				System.out.println("mauvaise commande");
				break;
			}
		}while(!ok.equals("n"));
	}
	
	public String scanArme() {
		Scanner scan = new Scanner(System.in);
		String choixArme = scan.nextLine();
		 
		do{ 
			if(!choixArme.equals("epee") || !choixArme.equals("fiole")) {
				System.out.println("mauvaise commande");
				break;
			}else {
				System.out.println("");
			}
		}while(!choixArme.equals("epee") || choixArme.equals("fiole"));
		return choixArme;
	}
	
	public void stage(Hero player1) {
		int rand = Monstre.randMonstre();
		
	if(starting =true)	
	{
		int salle = 1;
		for(salle = 1; salle < 6; salle++)
		{
		
		System.out.println(" ______________________________");
		System.out.println("|                              |");
		System.out.println("             SALLE " + salle       );
		System.out.println("|______________________________|\n");
	
		if(rand == 1) {
			Monstre monstre = new Monstre("baltazar", 20, false, "magicien", new Arme("eclair", 8));
			
			do{
				monstre.attaque(player1);
				System.out.println("tour suivant - appuyez sur la touche n");
				scannerCombat();
				
				System.out.println("Entrer le nom de l'arme à utiliser : epee ou fiole");
				String choixArme = scanArme();
				
					if(choixArme.equals("fiole")) {
						player1.attaque(monstre);
						System.out.println("tour suivant - appuyez sur la touche n");
						scannerCombat();
					}else {
						System.out.println("Votre coup à echoué");
					}
				if(player1.getPointVie() <= 0){
					player1.setPointVie(0);
					System.out.println("Le magicien vous assène le coup de grâce, vous avez perdu");
					starting = false;
					break;
				}else if(monstre.getPointVie() <= 0) {
					monstre.setPointVie(0);
					
					System.out.println("Vous parvenez à vous débarasser du magicien et avancez dans la salle numero " + (salle + 1));
					break;
				}
			}while(player1.getPointVie() > 0 || monstre.getPointVie() > 0);
				
		
		}else if(rand == 2){
			Monstre monstre = new Monstre("patrick", 20, false, "barbare", new Arme("hache", 5));
			
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
				player1.setPointVie(0);
				System.out.println("\nLe barbare vous assène le coupe de grâce, vous avez perdu");
				starting =false;
				break;
				
			}else if(monstre.getPointVie() <= 0) {
				monstre.setPointVie(0);
				System.out.println("Vous tuez le barbare et avancer dans la salle numero " + (salle + 1));
				break;
			}
		}while(player1.getPointVie() > 0 || monstre.getPointVie() > 0);
		}
		}
	}
	System.out.println("Vous entrez dans la Derniere salle du donjon et decouvez le tresor\n");
	afficheFin();	
	}
	
	public void afficheFin() {
		System.out.println("  	_____________");
		System.out.println("   |             |");
		System.out.println("   |     FIN     |");
		System.out.println("   |             |");
		System.out.println("   |_____________|");
	
	}
	
	
	
	
	
	
}
