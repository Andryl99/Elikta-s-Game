package iaCoreGame;

import java.util.Random;
import players.Computer;
import tools.*;

public class IaSecretNumbers extends Computer{
	
	GameData gameD = new GameData();
	Random rand = new Random();

	public int[] tryToGuess(int turnNb, int[] previousSequence, String previousAnswer) {
		
		int[] guessing = new int[gameD.getCasesLenght()];
		
		//génère une réponse aléatoire au premier tour
		if(turnNb == 0) {
			for(int i=0; i<gameD.getCasesLenght(); i++) {
				guessing[i] = rand.nextInt(gameD.getNbAllowed());
			}
			System.out.print("\nI propose this : ");
			for(int i:guessing) {
				System.out.print(i);
			}
			System.out.print("\n\n");
			return guessing;
		}
		
		if(turnNb != 0) {
			//transformation du String previousAnswer en tableau de char pour faciliter la manipulation
			char[] answerTab = new char[gameD.getCasesLenght()];
			for(int i=0; i<gameD.getCasesLenght(); i++) {
				answerTab[i] = previousAnswer.charAt(i);
			}
			
			for(int i=0; i<gameD.getCasesLenght(); i++) {
				
				if(answerTab[i] == '=')
					guessing[i] = previousSequence[i];
				
				if(answerTab[i] == '+') {
					if(previousSequence[i] == 8)
						guessing[i] = 9;
					if(previousSequence[i] == 7)
						guessing[i] = 8;
					if(previousSequence[i] == 6)
						guessing[i] = 7;
					if(previousSequence[i] == 5)
						guessing[i] = 8;
					if(previousSequence[i] == 4)
						guessing[i] = 5;
					if(previousSequence[i] == 3)
						guessing[i] = 4;
					if(previousSequence[i] == 3)
						guessing[i] = 4;
					if(previousSequence[i] == 2)
						guessing[i] = 3;
					if(previousSequence[i] == 1)
						guessing[i] = 2;
				}
			
				if(answerTab[i] == '-') {
					if(previousSequence[i] == 7)
						guessing[i] = 6;
					if(previousSequence[i] == 8)
						guessing[i] = 7;
					if(previousSequence[i] == 1)
						guessing[i] = 0;
					if(previousSequence[i] == 2)
						guessing[i] = 1;
					if(previousSequence[i] == 5)
						guessing[i] = 2;
					if(previousSequence[i] == 3)
						guessing[i] = 2;	
					if(previousSequence[i] == 4)
						guessing[i] = 3;
				
					}
				}
			}
			else
				return guessing;
			
			System.out.print("I propose this : ");
			for(int i:guessing) {
				System.out.print(i);
			}
			System.out.println("");
			return guessing;
		}


	@Override
	public String giveAnAnswer(int[] attackerSequence, int[] defenderSequence) {
		String answer = "";
		int asWon = 0;
	
		for(int i=0; i<attackerSequence.length; i++) {
			if(attackerSequence[i] == defenderSequence[i]) {
				answer = answer +"=";
			}
			if(attackerSequence[i] > defenderSequence[i]) {
				answer = answer +"-";
			}
			if(attackerSequence[i] < defenderSequence[i]) {
				answer = answer +"+";
			}
		}
		for(int i=0; i<answer.length(); i++) {
			if(answer.charAt(i) == '=')
				asWon++;				
		}
			
		if(asWon == gameD.getCasesLenght()) {
			String str = "You win";
			return str;
		}
		else
			return answer;
			
	}
}
	


