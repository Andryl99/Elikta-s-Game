package players;

public class HumanMM extends Human{

	@Override
	public String giveAnAnswer(int[] attackerSequence, int[] defenderSequence) {
		String answer = "";
		
		System.out.println("Please enter the corresponding answer\nx if the number is correct\no if the number does not exist in the sequence\nm if the number is not at right place\nEnter \"you win\" if the complete sequence is correct.");
		answer = sc.nextLine();
		
		boolean isValidAnswer;
		do {
			
			if(answer.charAt(0) == 'y'||answer.charAt(0) == 'Y') {
				break;
			}
			isValidAnswer = false;
			if(answer.length()>gameD.getCasesLenght()) {
				System.out.println("You entered too many characters, try again !");
				isValidAnswer = true;
			}
		
			for(int i=0; i<answer.length(); i++) {
				if(answer.charAt(i)!='x'&& answer.charAt(i)!='X'&& answer.charAt(i)!='O'&& answer.charAt(i)!='o'&& answer.charAt(i)!='m'&& answer.charAt(i)!='M') {
					System.out.println("You entered an invalid sequence, try again !");
					isValidAnswer = false;
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
