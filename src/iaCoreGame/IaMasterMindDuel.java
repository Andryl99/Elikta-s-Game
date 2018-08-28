package iaCoreGame;

public class IaMasterMindDuel extends IaMasterMind{
	
	/*
	 * légère modification des méthodes pour permettre de créer une IA adaptée au mode duel
	 */
	
	public String giveAnAnswer(int[] attackerSequence, int[] defenderSequence) {
		
		String answer = "";
		int winningCount = 0;
		
		boolean[] boolSequ = new boolean[gameD.getCasesLenght()];
		for(int i=0; i<gameD.getCasesLenght(); i++) {
			boolSequ[i] = false;
		}
		
		for(int i=0; i<boolSequ.length; i++) {
			if(attackerSequence[i] == defenderSequence[i]) {
				answer = answer +"x";
				boolSequ[i] = true;
			}
			else {
				for(int j=0; j<boolSequ.length; j++) {
					if(attackerSequence[i] == defenderSequence[j] && i!=j && boolSequ[j] == false) {
						answer = answer + "m";
						boolSequ[j] = true;
					}
				}
			}
		}
		while(answer.length()<gameD.getCasesLenght()) {
			answer = answer +"o";
		}
		
		for(int i=0; i<gameD.getCasesLenght(); i++) {
			if(answer.charAt(i)=='x') {
				winningCount++;
			}
		}
		if(winningCount == gameD.getCasesLenght()) {
			answer = "You win !";
		}
		
		return answer;
	}

}
