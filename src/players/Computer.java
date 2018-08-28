package players;
import java.util.Random;
import tools.GameData;



public abstract class Computer implements Players{
		
	GameData gameD = new GameData();
	Random rand = new Random();

	//m�thode bastraite red�finis dans les classes correspondant aux jeux, cette m�thode premets de r�pondre � la proposition de l'adversaire
	//selon le jeu choisi
	public abstract String giveAnAnswer(int[] attackerSequence, int[] defenderSequence);
	
	//m�thode utilis�e dans tout les jeux qui g�n�re une s�quence al�atoire avec les param�tres du config.properties ( et GameData)
	@Override
	public int[] generateSequence() {
		int[] sequence = new int[gameD.getCasesLenght()];
		for(int i=0; i<gameD.getCasesLenght(); i++) {
			sequence[i] = rand.nextInt(gameD.getNbAllowed());
		}
		return sequence;
	}
	
	//retourne le message de d�faite de l'IA
	public String lostMessage() {
		return "I lost, how can it be possible !";
	}
	
	//retourne le message de victoire de l'IA
	public String winningMessage() {
		return "I win like a boss, thanks for playing !";
	}
}
