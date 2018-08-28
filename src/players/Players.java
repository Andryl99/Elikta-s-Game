package players;

public interface Players {
	
	//interface permettant d'avoir une vue claire des m�thodes employ�es par tout les joueurs (humains ou IA) permettant une coh�rence entre toutes les classes d�finissant les joueurs
	
	int[] generateSequence();
	
	int[] tryToGuess(int turnNb, int[]previousSequence, String previousAnswer);
	
	String giveAnAnswer(int[] attackerSequence, int[] defenderSequence);
	
	String lostMessage();
	
	String winningMessage();
	
	
	

}
