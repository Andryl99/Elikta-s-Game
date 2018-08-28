package games;
import tools.*;
import java.util.Random;
import java.util.Scanner;
import iaCoreGame.*;

public class MagicalNumber{
	
	GameData gameD = new GameData();
	IaMagicalNumber iaMN = new IaMagicalNumber();
	
	Random rand = new Random();
	Scanner sc = new Scanner(System.in);
	int nbAllowed = gameD.getNbAllowed();
	int attackerNb;
	int defenderNb;
	int targetNb;
	boolean devMode = gameD.getDevMode();
	
	
	public void attackerMode() {
		
		System.out.println("Let's play !");
		defenderNb = rand.nextInt(nbAllowed);
		int lifeCount = gameD.getLifeCount();
		
		do {
			
			if(devMode = true) {
				System.out.println("Dev mode activated, the target number is : "+defenderNb);
			}
			System.out.println("You have "+lifeCount+" life left");
			System.out.println("Please enter a number between 0 and "+nbAllowed+" :");
			
			boolean correctAnswer = false;
		
			if(attackerNb<defenderNb)
				System.out.println("My number is bigger !");
			if(attackerNb>defenderNb)
				System.out.println("My number is smaller !");
			if(attackerNb==defenderNb) {
				System.out.println("You win congratulations !");
				break;
			}
			lifeCount--;
					
		}while(lifeCount != 0);
		
		if(lifeCount==0) {
			System.out.println("You lost, sorry ! The number was "+defenderNb);
		}		
	}
	
	public void defensorMode() {
		
		System.out.println("Let's play !");
		int lifeCount = gameD.getLifeCount();
		System.out.println("Please enter your secret number between 0 and "+nbAllowed+ ": ");
		defenderNb = Character.getNumericValue(sc.nextLine().charAt(0));
		//on génère un nb aléatoire pour le premier tour de l'ia
		attackerNb = rand.nextInt(gameD.getNbAllowed());
		
		do {
			
			System.out.println("I have "+lifeCount+" life left");
			System.out.println("I propose this : " + attackerNb);
			
			System.out.println("Please enter the corresponding answer :\n\"bigger\" for higher number\n\"smaller\" for smaller number\n\"correct for a good answer");
			boolean correctAnswer = false;
			char defenderAnswer;
			
			defenderAnswer = sc.nextLine().charAt(0);
			
			if(defenderAnswer == 'c' || defenderAnswer == 'C') {
				System.out.println("I win like a boss !");
				break;
			}
			else
				attackerNb = iaMN.guessMagicalNumber(defenderAnswer, attackerNb);
			lifeCount--;
			
			
		}while(lifeCount!=0);
		if(lifeCount == 0) {
			System.out.println("I lost, how is it possible ?!\n");
		}
	}
	
	public void duelMode() {
		
		System.out.println("Let's play !");
		int lifeCount = gameD.getLifeCount();
		targetNb = rand.nextInt(nbAllowed);
		char computerAnswer = ' ';
		System.out.println("Secret number has been generated between 0 and "+nbAllowed+", try to find it !");
		
		if(devMode = true) {
			System.out.println("Dev mode activated, the target number is : "+targetNb);
		}
		
		do {
			System.out.println("You have "+lifeCount+" life left !");
			
			boolean correctAnswer = false;
			do {
				System.out.println("This is your turn, please enter a proposal : ");
				attackerNb = Character.getNumericValue(sc.nextLine().charAt(0));
				if(attackerNb > nbAllowed || attackerNb < 0)
					System.out.println("You entered a non valid answer, try again");
				else
					correctAnswer = true;
			}while(correctAnswer = false);
			
			if(attackerNb == targetNb) {
				System.out.println("You win, congratulations !");
				break;
			}
			if(attackerNb < targetNb){
				System.out.println("The target number is bigger !");
				computerAnswer = 'b';
			}
			if(attackerNb > targetNb) {
				System.out.println("The targget number is smaller !");
				computerAnswer = 's';
			}
			
			attackerNb = iaMN.guessMagicalNumber(computerAnswer, attackerNb);
			
			System.out.println("This is my turn i propose "+attackerNb);
			
			if(attackerNb == targetNb) {
				System.out.println("The IA wins, congratulations !");
				break;
			}
			if(attackerNb < targetNb){
				System.out.println("The target number is bigger !");
				computerAnswer = 'b';
			}
			if(attackerNb > targetNb) {
				System.out.println("The targget number is smaller !");
				computerAnswer = 's';
			}
			
			lifeCount--;
			
			
			
			
		}while(lifeCount != 0);
		
		if(lifeCount == 0) {
			System.out.println("You both loose ! The target number was "+targetNb);
		}
		
	}

}
