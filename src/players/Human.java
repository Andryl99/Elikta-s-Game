package players;
import java.util.Random;
import tools.GameData;
import java.util.Scanner;

public abstract class Human implements Players {
	
	GameData gameD = new GameData();
	Random rand = new Random();
	Scanner sc = new Scanner(System.in);
	

	public int[] tryToGuess(int turnNb, int[]previousSequence, String previousAnswer) {
		System.out.println("Please enter a sequence of "+gameD.getCasesLenght()+" digits :");
		String playerSequence = "";
		int[] playerSequenceTab = new int[gameD.getCasesLenght()];
		
		int check = 0;
		do {			
			playerSequence = sc.nextLine();
			
			if(playerSequence.length() > gameD.getCasesLenght() || playerSequence.length()<gameD.getCasesLenght()) {
				System.out.println("You entered a wrong combinaison, try again");
			}
			else
				check = 1;
		}while(check == 0);

		for(int i=0; i<gameD.getCasesLenght(); i++) {
			playerSequenceTab[i] = Character.getNumericValue(playerSequence.charAt(i));
		}
		
		return playerSequenceTab;
	}


	//méthode demandant au joueur humain d'entrer la séquence secrète qu'il souhaite pour le jeu choisis
	@Override
	public int[] generateSequence() {
		
		System.out.println("Please enter a sequence of "+gameD.getCasesLenght()+" digits going from 0 to "+gameD.getNbAllowed());
		
		String playerSequence = "";
		int[] playerSequenceTab = new int[gameD.getCasesLenght()];
		
		int isValidSequence = 0;
		int isValidLenght = 0;
		do{
			
			isValidSequence = 0;
			
			playerSequence = sc.nextLine();
			
			for(int i=0; i<playerSequence.length();i++) {
				if(Character.getNumericValue(playerSequence.charAt(i))>gameD.getNbAllowed()) {
					System.out.println("You entered an invalid digit (max number allowed : "+gameD.getNbAllowed()+")");
					break;
				}
				if(i==gameD.getCasesLenght()) {
					isValidSequence ++;
				}
			}
			
			isValidLenght = 0;
			
			if(playerSequence.length() > gameD.getCasesLenght()||playerSequence.length()<gameD.getCasesLenght()) {
				System.out.println("You entered a wrong combinaison, try again");
			}
			else
				isValidLenght ++;

		}while(isValidSequence != 1 && isValidLenght != 1);
		
		
		
		for(int i=0; i<gameD.getCasesLenght(); i++) {
			playerSequenceTab[i] = Character.getNumericValue(playerSequence.charAt(i));
		}	
		return playerSequenceTab;
	}
	
	@Override
	//retourne message défaite du joueur humain
	public String lostMessage() {
		return "\nYou lost, better luck next time !";
	}
	
	
	@Override
	//retourrne message de victoire du joueur humain
	public String winningMessage() {
		return "You win, congratulations !";
	}
	

}
