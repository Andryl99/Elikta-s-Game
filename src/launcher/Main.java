package launcher;
import games.*;
import players.*;
import tools.*;
import iaCoreGame.*;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) { 
		
		//0 pour désactivé / 1 pour activé
		int duelMode = 0;
		
		Game secretNumbers = new SecretNumbers();
		Game masterMind = new MasterMind();
		
		Scanner sc = new Scanner(System.in);
		
		char retryChoice = ' ';
		
		System.out.println(Menus.INTROMENU.toString());
		
		do {
			System.out.println(Menus.GAMECHOICE.toString());
		
			char gameChoice = sc.nextLine().charAt(0);
		
			if (gameChoice == '1') {
			
				do {
					//
					System.out.println(Menus.MODECHOICE.toString());
					char modeChoice = sc.nextLine().charAt(0);

						if(modeChoice == '1')
							secretNumbers.launch(new HumanSN(), new IaSecretNumbers(), null, duelMode);			
						if(modeChoice =='2') 
							secretNumbers.launch(new IaSecretNumbers(), new HumanSN(), null, duelMode);
						if(modeChoice == '3') {
							duelMode = 1;
							secretNumbers.launch(new HumanSN(), new IaSecretNumbers(), new IaSecretNumbers(), duelMode);
							duelMode = 0;
						}
							//secretNumber.duelMode();
						System.out.println(Menus.RETRYCHOICE.toString());
						retryChoice = sc.nextLine().charAt(0);
					
				}while(retryChoice == '1');
			
			}
		
			if(gameChoice == '2') {
			
				do {
					MagicalNumber magicalNumber = new MagicalNumber();					
					System.out.println(Menus.MODECHOICE.toString());
					char modeChoice = sc.nextLine().charAt(0);
				
					if(modeChoice == '1')
						magicalNumber.attackerMode();
					if(modeChoice == '2')
						magicalNumber.defensorMode();
					if(modeChoice == '3')
						magicalNumber.duelMode();
				
					System.out.println(Menus.RETRYCHOICE.toString());
					retryChoice = sc.nextLine().charAt(0);
					
				}while(retryChoice =='1');
				
			}
			
		
			if(gameChoice == '3') {
			
				do {
					System.out.println(Menus.MODECHOICE.toString());
					char modeChoice = sc.nextLine().charAt(0);
			
					if(modeChoice == '1')
						masterMind.launch(new HumanMM(), new IaMasterMind(), null, duelMode);
					if(modeChoice == '2')
						masterMind.launch(new IaMasterMind(), new HumanMM(), null, duelMode);
					if(modeChoice =='3') {
						duelMode = 1;
						masterMind.launch(new HumanMM(), new IaMasterMind(), new IaMasterMindDuel(), duelMode);
						duelMode = 0;
					}
					
					System.out.println(Menus.RETRYCHOICE.toString());
					retryChoice = sc.nextLine().charAt(0);
					
					}while(retryChoice =='1');
				
				}
			
				}while(retryChoice =='2');
		

		System.out.println("Have a good day, good bye !");
			
		
		
		

		
		
		
		
			
			
		


	}
}




