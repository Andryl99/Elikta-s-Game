package tools;

public enum Rules {
	
	SECRETNUMBERSAT ("****************\n"
			+ "The rules : \n"
			+ "In this game, the IA have a secret sequence, try to guess it by giving him a sequence of digits.\n"
			+ "For each proposal, the IA will help you by answering with a sequence of '+' '-' or '=' corresponding to your proposal !\n"
			+ "For exemple : the IA sequence is 1234 and you propose 0332, the answer you'll get will be '+-=+', your job is to find it before you run out of lives !\n"),
	
	SECRETNUMBERSDF ("****************\n"
			+ "The rules : \n"
			+ "In this game mode, the IA will try to find YOUR sequence, pick a secret sequence and answer to the IA depending of his proposal.\n"),
	
	SECRETNUMBERDD ("*****************\n"
			+ "The rules : \n"
			+ "In duel mode, you and the IA will fight to know who find the secret sequence first, for each proposal, you'll have an answer just like the other game mode.\n"),
	
	MAGICALNUMBERAT ("******************\n"
			+ "The rules : \n"
			+ "Try to find the IA's secret digit, for each proposal he'll tell you if his number is higher or lower,\n"
			+ "Find it before you run out of lives !\n"),
	
	MAGICALNUMBERDF ("****************\n"
			+ "The rules : \n"
			+ "In this game mode, the IA will try to discover your secret digit, for each proposal, tell him if your number is higher or smaller !\n"),
	
	MAGICALNUMBERDD ("****************\n"
			+ "The rules : \n"
			+ "In duel mode, you and the IA will fight to know who find the secret number first, for each proposal, you'll get an answer just like the other game mode\n"),
	
	MASTERMINDAT ("*******************\n"
			+ "The rules : \n"
			+ "In the mastermind, you'll have to discover the IA's secret sequence, for each proposal he will tell you how many correct numbers you have\n"
			+ "And how many correct numbers but not in the right place you have.\n"
			+ "Try to find the sequence before you run out of lives\n"),
	
	MASTERMINDDF ("*******************\n"
			+ "The rules : \n"
			+ "In the defender mode, the IA will try to find your secret sequence, for each proposal,\ntell him wich number is correct (with a 'x') wich is good but not in the right spot (with a 'm') and wich is not in your sequence at all (with a 'o')\n"),

	MASTERMINDDD ("*******************\n"
			+ "The rules : \n"
			+ "In duel mode, you and the IA will fight to know who find the secret sequence first, for each proposal you'll have an answer like in the defender mode\n"
			+ "For each digit, you'll have a 'x' for a correct number, a 'm' for a correct but not in the right position number and a 'o' for a number not present in the sequence.");
	
	private final String rule;
	
	private Rules(String rule) {
		this.rule = rule;
	}
	
	public String toString() {
		return rule;
	}
	
	

}
