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
	int[][] possibilities = new int[gameD.getCasesLenght()][gameD.getNbAllowed()];
	boolean[][] availablePossibilities = new boolean[gameD.getCasesLenght()][gameD.getNbAllowed()];

	//algorythme de r�solution du mastermind.
	public int[] tryToGuess(int turnNb, int[] previousSequence, String previousAnswer) {
		
		/*
		 * Explication de l'algorythme dans le fichierr PDF pr�sent dans le dossier du jeux
		 * 
		 * 
		 */
		
		
		int[] guess = new int[gameD.getCasesLenght()];
		
		//on g�n�re un tableau � deux dimension qui contiendra un tableau � 2 dimensions g�n�r� par la m�thode generateAllPossibilities();
		
		
		//on r�cup�re le tableau de toute les possibilit�es 		
		//et le tableau de boolean associ�
		if(turnNb == 0) {
			possibilities = mBreak.generateAllPossibilities();
			logger.info("All possibilities have been generated\n");
			availablePossibilities = mBreak.generateBoolTab();
		}
		
		
		
		//si c'est le premier tour (aucune r�ponse du d�fenseur n'a �t� donn�e) on g�n�re une r�ponse permettant de proposer des chiffres al�atoire a tout les emplacements
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
			
			//si le nombre est absent, on remplie le boolean � l'index indiqu� d'un true, emp�chant l'IA de reproposer ce chiffre
			if(previousAnswer.charAt(i) == 'o' || previousAnswer.charAt(i) == 'O') {
				availablePossibilities[i][previousSequence[i]] = true;
				/*for(int j=0; j<gameD.getCasesLenght();j++) {
					
				}*/
			}
			
			
			if(previousAnswer.charAt(i) == 'm' || previousAnswer.charAt(i) == 'M') {
				availablePossibilities[i][previousSequence[i]] = true;
			}
		}
		
		
		
		
		//boucle permettant de proposer un nombre al�atoire, de le v�rifier, et de le proposer si il n'a pas d�j� �t� propos� pr�c�demment.
		boolean nbIsCorrect;
		int nbProposed = 0;
		
		for(int i=0; i<gameD.getCasesLenght(); i++) {
			do {
				nbIsCorrect = false;
				
				//variable int temporaire qui permet de v�rifier la proposition avant de la valider
				int nbTemp;
				nbTemp = possibilities[i][rand.nextInt(gameD.getNbAllowed())];
				if(availablePossibilities[i][nbTemp] == false) {
					nbProposed = nbTemp;
					nbIsCorrect = true;
				}
				else 
					nbIsCorrect = false;
				
			}while(nbIsCorrect == false);
			
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
		
		//utilisation d'un tableau de boolean pour �viter les doublons lors de la v�rification de la proposition
		boolean[] boolSequ = new boolean[gameD.getCasesLenght()];
		for(int i=0; i<boolSequ.length; i++) {
			boolSequ[i] = false;		
		}
		
		//boucles qui permettent de comptabilliser les nombres corrects et/ou mal plac�s
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
