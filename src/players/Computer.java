package players;
import java.util.Random;
import tools.GameData;



public abstract class Computer implements Players{
		
	GameData gameD = new GameData();
	Random rand = new Random();

	//méthode bastraite redéfinis dans les classes correspondant aux jeux, cette méthode premets de répondre à la proposition de l'adversaire
	//selon le jeu choisi
	public abstract String giveAnAnswer(int[] attackerSequence, int[] defenderSequence);
	
	//méthode utilisée dans tout les jeux qui génère une séquence aléatoire avec les paramètres du config.properties ( et GameData)
	@Override
	public int[] generateSequence() {
		int[] sequence = new int[gameD.getCasesLenght()];
		for(int i=0; i<gameD.getCasesLenght(); i++) {
			sequence[i] = rand.nextInt(gameD.getNbAllowed());
		}
		return sequence;
	}
	
	//retourne le message de défaite de l'IA
	public String lostMessage() {
		return "I lost, how can it be possible !";
	}
	
	//retourne le message de victoire de l'IA
	public String winningMessage() {
		return "I win like a boss, thanks for playing !";
	}
}
