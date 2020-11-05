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
		/*
		Donjon donjon = new Donjon(6, false);
		Hero player1 = new Hero("john", 50, 50, false, "Chevalier", new Arme("épée", 10));
		
		Monstre cpu = new Monstre("baltazar", 40, 40, false, "Magicien", new Arme("eclair", 8));
		
		int heroVie = player1.getPointVie();
		int cpuVie = cpu.getPointVie();
		System.out.println("john a " + heroVie + " points de vie et baltazar a " + cpuVie + " points de vie");
		System.out.println("john attaque le magicien\n");
		player1.attaque(cpu);
		cpu.attaque(player1);
		
		System.out.println("baltazar a " + player1.getPointVie() + " points de vie Bernard : " + cpu.getPointVie());
		
		cpu.attaque(player1);
		cpu.affiècheStatsMonstre(cpu,player1, cpu.arme);
		*/
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
			break;
			}	
		}while(!choice.equals("e") || !choice.equals("q"));
		return choice;
	}
	
	public void initGame() {
		
			Donjon donjon = new Donjon(6, false);
			Hero player1 = new Hero("Bernard", 50, 50, false, "Chevalier");
		
			System.out.println("Vous ouvrez la porte du Donjon et entrez dans une salle.... ");
			stage(player1);
	}

	public void scannerCombat() {
			
		Scanner scan = new Scanner(System.in);
		char ok = scan.nextLine().charAt(1);	
			
		do {
			if(ok == 'n'){
				break;
			}else {
				System.out.println("mauvaise commande");
				System.out.println("tour suivant - appuyez sur la touche : n"); 
				break;
			} 
		}while(ok != 'n');
		
	}
		

	public void stage(Hero player1) {
		int rand = Monstre.randMonstre();
		
		if(rand == 1) {
			Monstre monstre = new Monstre("baltazar", 20, 20, false, "magicien", new Arme("eclair", 8));
			while(!monstre.estMort(monstre)|| !player1.estMort(player1))
			{
				monstre.attaque(player1);
				//monstre.afficheStatsMonstre(monstre, player1, 8);
				System.out.println("tour suivant - appuyez sur la touche : n");
				scannerCombat();
				
				player1.attaque(monstre);
				System.out.println("tour suivant - appuyez sur la touche : n");
				scannerCombat();
				
			}
		}else if(rand == 2){
			Monstre monstre = new Monstre("patrick", 20, 20, false, "barbare", new Arme("hache", 5));
			while(!monstre.estMort(monstre) ) {
				//System.out.println("Vous etes attaqué par " + monstre.getNom() + " le " + monstre.getRace());
				monstre.attaque(player1);
				//monstre.afficheStatsMonstre(monstre, player1, 8);
				System.out.println("tour suivant - appuyez sur la touche : n");
				scannerCombat();
				
				player1.attaque(monstre);
				scannerCombat();
				System.out.println("tour suivant - appuyez sur la touche : n");
			}
		}
	}
}
