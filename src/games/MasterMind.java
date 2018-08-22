package games;

import players.Players;

public class MasterMind extends Game{

	@Override
	public void launch(Players pAttacker, Players pDefender, Players pIaDuel, int pDuelMode) {
		int lifeCount = gameD.getLifeCount();
		boolean devMode = gameD.getDevMode();
		int[] defenderSequence = new int[gameD.getCasesLenght()];
		int[] attackerSequence = new int[gameD.getCasesLenght()];
		int[] iaDuelSequence = new int[gameD.getCasesLenght()];
		String defenderAnswer = "";
		String iaDuelAnswer = "";
		int turnNb = 0;
		this.attacker = pAttacker;
		this.defender = pDefender;
		this.iaDuel = pIaDuel;
		this.duelMode = pDuelMode;
		
		System.out.println("Let's play !");
		
		if(duelMode == 0) {
			defenderSequence = defender.generateSequence();
			if(devMode = true) {
				System.out.print("Dev mode activated, the sequence is : ");
				for(int i:defenderSequence) {
					System.out.print(i);
				}
				System.out.print("\n\n");
			}
			do {
				
				System.out.println("Only "+lifeCount+" life left.");
				
				attackerSequence = attacker.tryToGuess(turnNb, attackerSequence, defenderAnswer);
				turnNb++;
				defenderAnswer = defender.giveAnAnswer(attackerSequence, defenderSequence);
				System.out.println("The answer to your proposal is : "+defenderAnswer);
				
				//boucle de vérif de victoire
				if(Character.getNumericValue(defenderAnswer.charAt(0)) == gameD.getCasesLenght() || defenderAnswer.charAt(0) == 'y' || defenderAnswer.charAt(0) == 'Y') {
					System.out.println(attacker.winningMessage());
					break;
				}
				
				lifeCount--;
				
			}while(lifeCount >0);
			if(lifeCount == 0) {
				System.out.print("The secret sequence was : ");
				for(int i:defenderSequence) {
					System.out.print(i);
				}
				System.out.println("\n"+attacker.lostMessage());
			}
			
		}
		
		
		
		
		else {
			iaDuelSequence = iaDuel.generateSequence();
			if(devMode = true) {
				System.out.print("Dev mode activated, the sequence is : ");
				for(int i:iaDuelSequence) {
					System.out.print(i);
				}
				System.out.print("\n\n");
			}
			turnNb++;
			
			do {
				
				System.out.println("Only "+lifeCount+" life left");
				
				attackerSequence = attacker.tryToGuess(turnNb, attackerSequence, iaDuelAnswer);
				iaDuelAnswer = iaDuel.giveAnAnswer(attackerSequence, iaDuelSequence);
				
				if(iaDuelAnswer.charAt(0) == 'y' || iaDuelAnswer.charAt(0) == 'Y') {
					System.out.println(attacker.winningMessage());
					break;
				}
				
				System.out.println("The answer yo your proposal is :"+iaDuelAnswer);
				
				defenderSequence = defender.tryToGuess(turnNb, attackerSequence, iaDuelAnswer);
				iaDuelAnswer = iaDuel.giveAnAnswer(defenderSequence, iaDuelSequence);
				
				if(iaDuelAnswer.charAt(0) == 'Y' || iaDuelAnswer.charAt(0) == 'y'){
					System.out.println(attacker.winningMessage());
					break;
				}
				
				System.out.println("The answer to your proposal is : "+iaDuelAnswer);
				lifeCount--;
				
			}while(lifeCount > 0);
			
			if(lifeCount == 0) {
				System.out.println("The secret sequence was : ");
				for(int i:defenderSequence) {
					System.out.print(i);
				}
				System.out.println("You booth loose, shame on you !");
			}
		}
		
	}

}
