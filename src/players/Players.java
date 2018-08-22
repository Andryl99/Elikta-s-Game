package players;

public interface Players {
	
	int[] generateSequence();
	
	int[] tryToGuess(int turnNb, int[]previousSequence, String previousAnswer);
	
	String giveAnAnswer(int[] attackerSequence, int[] defenderSequence);
	
	String lostMessage();
	
	String winningMessage();
	
	
	

}
