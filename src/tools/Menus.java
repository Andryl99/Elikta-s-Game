package tools;

//énumération de tout les menus de l'application
public enum Menus {
	
	INTROMENU ("***************************************\n"
			+ "Welcome to the awesome Elikta's game !\n"
			+ "Play with me to save the world !\n"
			+ "***************************************\n"),

	GAMECHOICE ("Please pick a game :\n"
			+ "1 - Secret Number\n"
			+ "2 - Magical Numbers\n"
			+ "3 - Mastermind\n"
			+ "4 - Quit the app\n"
			+ "Please enter the game number :"),
	
	MODECHOICE ("\nPlease pick a game mode :\n"
			+ "1 - Attacker Mode : Play against the IA\n"
			+ "2 - Defensor Mode : The IA play against you\n"
			+ "3 - Duel Mode : Play a duel against the IA"
			+ "Please enter the game mode number :"),
	
	RETRYCHOICE ("***************************************"
			+ "\nWhat will you do now ?\n"
			+ "1 - Retry this game\n"
			+ "2 - Try another game\n"
			+ "3 - Leave the app");

	
	
	private final String menu;
	
	private Menus(String menu) {
		this.menu = menu;
	}
	
	public String toString() {
		return menu;
	}
	
	
}
