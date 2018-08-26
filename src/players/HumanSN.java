package players;

public class HumanSN extends Human{


	public String giveAnAnswer(int[] attackerSequence, int[] defenderSequence) {
		String returnedAnswer = "";
		String answer = "";
		System.out.println("Please enter the corresponding answer \n= if the number is correct\n- if the number is smaller\n+ if the number is bigger\nEnter You win if the sequence is correct");	
		
		answer = sc.nextLine();
		
		for(int i=0; i<attackerSequence.length; i++) {
			returnedAnswer = returnedAnswer + Character.toString(answer.charAt(i));
			
		}
		return returnedAnswer;
	}

}
