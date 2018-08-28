package iaCoreGame;

import tools.*;

public class IaMagicalNumber {
	
	GameData gameD = new GameData();

	
	//méthode permettant à l'IA de résoudre une partie de Magical Number, algorythme très simple et volontairement "lourd" pour permettre de s'adapter aux différents paramètres choisis dans le config.properties.
	public int guessMagicalNumber(char defenderAnswer, int previousTry) {
		
		if(defenderAnswer == 'B' || defenderAnswer == 'b') {
			
			if(previousTry == 8)
				previousTry = 9;
			if(previousTry == 7)
				previousTry = 8;
			if(previousTry == 6)
				previousTry = 7;
			if(previousTry == 5)
				previousTry = 8;
			if(previousTry == 4)
				previousTry = 6;
			if(previousTry == 3)
				previousTry = 4;
			if(previousTry == 2)
				previousTry = 3;
			if(previousTry == 1)
				previousTry = 2;
			if(previousTry ==0)
				previousTry = 1;
		
			return previousTry;
		}
		
		if(defenderAnswer == 'S' || defenderAnswer == 's') {
			
			if(previousTry == 2)
				previousTry = 1;
			if(previousTry == 1)
				previousTry = 0;	
			if(previousTry == 3)
				previousTry = 2;
			if(previousTry == 4)
				previousTry = 3;
			if(previousTry == 5)
				previousTry = 2;
			if(previousTry == 6)
				previousTry = 4;
			if(previousTry == 7)
				previousTry = 6;
			
			return previousTry;
		}
		
		else return 0;
	}
}
