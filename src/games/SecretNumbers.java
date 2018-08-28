package games;
import players.*;
import tools.GameData;

public class SecretNumbers extends Game{
	
	GameData gameD = new GameData();
	
	public void launch(Players pAttacker, Players pDefender, Players pIaDuel, int pDuelMode) {
		int lifeCount = gameD.getLifeCount();
		boolean devMode = gameD.getDevMode();
		int[] defenderSequence = new int [gameD.getCasesLenght()];
		int[] attackerSequence = new int [gameD.getCasesLenght()];
		int[] iaDuelSequence = new int [gameD.getCasesLenght()];
		String defenderAnswer = "";
		String iaDuelAnswer = "";
		int turnNb = 0;
		this.attacker = pAttacker;
		this.defender = pDefender;
		//un objet de type IaSecretNumbers utilisée pour les duels
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
				
				//permet de vérifier si la réponse du défenseur (joueur ou ia) commence par le charactère Y (composant le premier charactère de toute les situations de victoire)
				if(defenderAnswer.charAt(0) == 'Y' || defenderAnswer.charAt(0) == 'y'){
					System.out.println(attacker.winningMessage());
					break;
				}
				lifeCount--;
			
			
			
			}while(lifeCount > 0);	
			
			if(lifeCount == 0) {
				System.out.print("The secret sequence was : ");
				for(int i:defenderSequence) {
					System.out.print(i);
				}
				System.out.println("\n"+attacker.lostMessage());
			}
		
		
		}
		else {
			//pour les duel le joueur commence toujours en premier, il est définis comme attacker, l'ordinateur est définis comme defender
			//l'ia contre qui l'ordinateur et le joueur est définis par iaDuel (objet de type iaSecretNumbers)
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
				
				if(iaDuelAnswer.charAt(0) == 'Y' || iaDuelAnswer.charAt(0) == 'y'){
					System.out.println(attacker.winningMessage());
					break;
				}
				
				System.out.println("The answer to your proposal is : "+iaDuelAnswer);
				
				defenderSequence = defender.tryToGuess(turnNb, attackerSequence, iaDuelAnswer);
				iaDuelAnswer = iaDuel.giveAnAnswer(defenderSequence, iaDuelSequence);
				
				System.out.println("The answer to your proposal is : "+iaDuelAnswer);
				if(iaDuelAnswer.charAt(0) == 'Y' || iaDuelAnswer.charAt(0) == 'y'){
					System.out.println(defender.winningMessage());
					break;
				}
				
				
				lifeCount--;
				
				
			}while(lifeCount > 0);
			
			if(lifeCount == 0) {
				System.out.print("The secret sequence was : ");
				for(int i:defenderSequence) {
					System.out.print(i);
				}
				System.out.println("You both loose, shame on you !");
			}
			
			
			
		}
	}


}
