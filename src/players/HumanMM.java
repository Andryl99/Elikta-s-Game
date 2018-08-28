package players;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HumanMM extends Human{
	
	static final Logger logger = LogManager.getLogger();

	@Override
	//override de la méthode giveAnAnswer pour l'adaptée au jeux mastermind
	public String giveAnAnswer(int[] attackerSequence, int[] defenderSequence) {
		String answer = "";
		
		System.out.println("Please enter the corresponding answer\nx if the number is correct\no if the number is incorrect\nm if the number is not at right place\nEnter \"you win\" if the complete sequence is correct.");
		
		
		boolean isValidAnswer;
		//boucle de controle d'input de l'utilisateur
		do {
			answer = "";
			answer = sc.nextLine();
			if(answer.charAt(0) == 'y'||answer.charAt(0) == 'Y') {
				break;
			}
			isValidAnswer = false;
			if(answer.length()>gameD.getCasesLenght()||answer.length()<gameD.getCasesLenght()) {
				System.out.println("You entered an invalid sequence, try again !");
				isValidAnswer = false;
			}
		
			for(int i=0; i<answer.length(); i++) {
				if(answer.charAt(i)!='x'&& answer.charAt(i)!='X'&& answer.charAt(i)!='O'&& answer.charAt(i)!='o'&& answer.charAt(i)!='m'&& answer.charAt(i)!='M') {
					System.out.println("You entered an invalid sequence, try again !");
					logger.info("Human player entered an invalid answer (char not allowed)\n");
					break;
				}
				else {
					isValidAnswer = true;
				}
			
			}
		}while(isValidAnswer = false);
		
		return answer;
	}

}
