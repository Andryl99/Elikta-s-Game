package iaCoreGame;

import java.util.Random;

import players.Computer;
import tools.GameData;
import tools.MastermindBreak;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class IaMasterMind extends Computer{
	
	static final Logger logger = LogManager.getLogger();
	
	Random rand = new Random();
	
	GameData gameD = new GameData();
	MastermindBreak mBreak = new MastermindBreak();

	public int[] tryToGuess(int turnNb, int[] previousSequence, String previousAnswer) {
		
		
		int[] guess = new int[gameD.getCasesLenght()];
		
		//on génère un tableau à deux dimension qui contiendra un tableau à 2 dimensions généré par la méthode generateAllPossibilities();
		int[][] possibilities = new int[gameD.getCasesLenght()][gameD.getNbAllowed()];
		boolean[][] availablePossibilities = new boolean[gameD.getCasesLenght()][gameD.getNbAllowed()];
		
		
		//on récupère le tableau de toute les possibilitées 
		possibilities = mBreak.generateAllPossibilities();
		logger.info("All possibilities have been generated\n");
		//et le tableau de boolean associé
		availablePossibilities = mBreak.generateBoolTab();
		
		if(turnNb == 0) {
			for(int i=0; i<gameD.getCasesLenght(); i++) {
				String firstAnswer = "o";
				previousAnswer = previousAnswer + firstAnswer;
			}
			
		}
		
			
		for(int i=0; i<gameD.getCasesLenght(); i++) {
			
			//si on indique que le chiffre en i est correct,
			//on remplie le tableau correspondant de la bonne valeur, pour ne proposer que cette valeur correcte
			if(previousAnswer.charAt(i) == 'x' || previousAnswer.charAt(i) == 'X'){
				for(int j=0; j<gameD.getNbAllowed(); j++) {
					possibilities[i][j] = previousSequence[i];
				}
			}
			
			//si le nombre est absent, on remplie le boolean à l'index indiqué d'un true, empêchant l'IA de reproposer ce chiffre
			if(previousAnswer.charAt(i) == 'o' || previousAnswer.charAt(i) == 'O') {
				for(int j=0; j<gameD.getCasesLenght();j++) {
					availablePossibilities[i][previousSequence[i]] = true;
				}
			}
			
			if(previousAnswer.charAt(i) == 'm' || previousAnswer.charAt(i) == 'M') {
				availablePossibilities[i][previousSequence[i]] = true;
			}
		}
		
		
		
		
		boolean nbIsCorrect;
		int nbProposed = 0;
		
		for(int i=0; i<gameD.getCasesLenght(); i++) {
			do {
				nbIsCorrect = false;
				
				//variable int temporaire qui permet de vérifier la proposition avant de la valider
				int nbTemp;
				nbTemp = possibilities[i][rand.nextInt(gameD.getNbAllowed())];
				if(availablePossibilities[i][nbTemp] == false) {
					nbProposed = nbTemp;
					nbIsCorrect = true;
				}
			}while(nbIsCorrect = false);
			
			guess[i] = nbProposed;
		}
		
		System.out.print("I propose this :");
		for(int i:guess) {
			System.out.print(i);
		}
		System.out.println("");
		return guess;
	}


		
		
		
	@Override
	public String giveAnAnswer(int[] attackerSequence, int[] defenderSequence) {
		
		int correctNb = 0;
		int presentNb = 0;
		
		//utilisation d'un tableau de boolean initié à false pour vérification de la séquence
		boolean[] boolSequ = new boolean[gameD.getCasesLenght()];
		for(int i=0; i<boolSequ.length; i++) {
			boolSequ[i] = false;		
		}
		
		for(int i=0; i<boolSequ.length; i++) {
			if(attackerSequence[i] == defenderSequence[i]) {
				correctNb++;
				boolSequ[i] = true;
			}			
		}
		
		for(int i=0; i<gameD.getCasesLenght(); i++) {
			for(int j=0; j<gameD.getCasesLenght();j++) {
				if(attackerSequence[i] == defenderSequence[j] && i!=j && boolSequ[j] == false) {
					presentNb++;
					boolSequ[j] = true;
				}
			}
		}
		
		return correctNb+" corrects, "+presentNb+" presents";
	}

}
