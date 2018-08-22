package tools;
import java.util.ArrayList;

public class MastermindBreak {
	
	GameData gameD = new GameData();
	
	//m�thode qui g�n�re un tableau � 2 dimensions contenant casesLenght tableau de nbAllowed Integer (toute les possibilit�es)
	public int[][] generateAllPossibilities(){
		
		int[][] tabGenerated = new int[gameD.getCasesLenght()][gameD.getNbAllowed()];
		
		for(int i=0; i<gameD.getCasesLenght(); i++) {
			for(int j=0; j<gameD.getNbAllowed(); j++) {
				tabGenerated[i][j] = j;
			}
		}
				
		return tabGenerated;

	        
	}
	
	//m�thode qui g�n�re un tableau � 2 dimensions qui permet d'�viter les doublons de propositions
	public boolean[][] generateBoolTab(){
		
		boolean[][] booleanTab = new boolean[gameD.getCasesLenght()][gameD.getNbAllowed()];
		
		for(int i=0; i<gameD.getCasesLenght(); i++) {
			for(int j=0; j<gameD.getNbAllowed(); j++) {
				booleanTab[i][j] = false;
			}
		}
		
		return booleanTab;
	}
	
	
	
	
}
