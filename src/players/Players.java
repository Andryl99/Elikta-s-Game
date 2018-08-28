package players;

public interface Players {
	
	//interface permettant d'avoir une vue claire des méthodes employées par tout les joueurs (humains ou IA) permettant une cohérence entre toutes les classes définissant les joueurs
	
	int[] generateSequence();
	
	int[] tryToGuess(int turnNb, int[]previousSequence, String previousAnswer);
	
	String giveAnAnswer(int[] attackerSequence, int[] defenderSequence);
	
	String lostMessage();
	
	String winningMessage();
	
	
	

}
