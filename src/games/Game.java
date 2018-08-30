package games;

import players.Players;
import tools.GameData;

public abstract class Game {
	
	GameData gameD = new GameData();
	
	protected Players attacker;
	protected Players defender;
	protected Players iaDuel;
	protected int duelMode;
	protected int[] sequence;
	protected int lifeCount = gameD.getLifeCount();
	protected boolean devMode = gameD.getDevMode();
	protected int nbAllowed = gameD.getNbAllowed();
	protected int casesLenght = gameD.getCasesLenght();
	
	public abstract void launch(Players attacker, Players defender, Players iaDuel, int duelMode);

	

}
