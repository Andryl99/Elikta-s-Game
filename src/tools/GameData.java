package tools;

public class GameData {
	
	protected int lifeCount = 10;
	protected int casesLenght = 4;
	//nbAllowed comprends le 0, le noimbre maximal pour un NbAllowed de 6 est 5
	protected int nbAllowed = 6;
	protected boolean devMode = false;
	
	public int attackerNb = 0;
	
	public int getLifeCount() {
		return lifeCount;
	}
	
	public int getCasesLenght() {
		return casesLenght;
	}
	
	public int getNbAllowed() {
		return nbAllowed;
	}
	
	public boolean getDevMode() {
		return devMode;
	}

}
