package players;
import java.util.Random;
import tools.GameData;

public abstract class Computer implements Players{
	
	GameData gameD = new GameData();
	Random rand = new Random();
	
	public String winningMessage = "I win like a boss ! Thanks for playing !";
	
	public String getWinningMessage() {
		return winningMessage;
	}

	public abstract String giveAnAnswer(int[] attackerSequence, int[] defenderSequence);
	
	@Override
	public int[] generateSequence() {
		int[] sequence = new int[gameD.getCasesLenght()];
		for(int i=0; i<gameD.getCasesLenght(); i++) {
			sequence[i] = rand.nextInt(gameD.getNbAllowed());
		}
		return sequence;
	}
	
	public String lostMessage() {
		return "I lost, how can it be possible !";
	}
	
	public String winningMessage() {
		return "I win like a boss, thanks for playing !";
	}
}
