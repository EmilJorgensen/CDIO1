package cdio1;

import desktop_resources.GUI;
public class Ui {
	public static void main(String[] args) 

	{
		Dice dice = new Dice();
		Player player1 = new Player();
		Player player2 = new Player();
		
	while(player1.getScore()< 40 && player2.getScore()<40)
	{
		int hit1 = 0;
		int hit2 = 0;
		int sum = 0;
		
		// Player 1's turn *****************************************************
		
		// Update score in middle of board
			GUI.displayChanceCard("Player 1's score:  " + player1.scoreString() + "\n" + "     Player 2's Score:  " + player2.scoreString());
		
		// Create buttons and show turn (Break game)
			GUI.getUserLeftButtonPressed("Player 1's turn", "Hard roll", " Soft roll");
		for (int i=0; i<2; i++)
		{
			dice.roll();
				player1.addScore(dice.getFaceValue());
				if(i==0)
				{
				hit1 = dice.getFaceValue();					
				}
				else
				{
				hit2 = dice.getFaceValue();
				sum = hit1 + hit2;
						
				// Show dice on board
					GUI.setDice(hit1,hit2);
						
				// Snakeeye => reset score
					if(Dice.Snakeeye(sum) == true)
					{
						player1.resetScore();
					}
					// Twice double six win
					
					if(sum == 12)	// Checks for double 6
					{
						if(player1.First12 == true){
							GUI.displayChanceCard("Player1 wins by hitting double 6 twice");
							System.exit(0);
						}
						else
						{
							player1.First12 = true;
						} }
						else 
						{
							player1.First12 = false;
						}	
				
				// Equal dice => extra turn
					if(Dice.Equals(hit1) == true)
					{
					i = i - 2 ;
					// Break game and announce extra turn
						GUI.getUserLeftButtonPressed("Player 1 gets an extra turn!", "Hard roll", " Soft roll");
					}
					
				}
					
		}
		
		// Update score in middle of board
			GUI.displayChanceCard("Sum of dice: " + sum + ".   Player 1's score:  " + player1.scoreString() + "\n" + "     Player 2's Score:  " + player2.scoreString());
		
		
		// Change of turn to Player 2 *****************************************************
		
		GUI.getUserLeftButtonPressed("Player 2's turn", "Hard roll", " Soft roll");
		for (int i=0; i<2; i++)
		{
		dice.roll();
		player2.addScore(dice.getFaceValue()); // ADd hit to Player 2 score
			if(i==0)
			{
			hit1 = dice.getFaceValue();
			}
			else
			{
				hit2 = dice.getFaceValue();
				sum = hit1 + hit2;
				
				// Show dice on board
					GUI.setDice(hit1,hit2);
				
				// Snakeeye => resetscore
					if(Dice.Snakeeye(sum) == true)
					{
						player2.resetScore();
					}
				// Twice double six win
					
					if(sum == 12)	// Checks for double 6
					{
						if(player2.First12 == true){
							GUI.displayChanceCard("Player1 wins by hitting double 6 twice");
							System.exit(0);
						}
						else
						{
							player2.First12 = true;
						} }
						else 
						{
							player2.First12 = false;
						}
				
				// Equal dice => extra turn
					if(Dice.Equals(hit1) == true)
					{
					i = i - 2 ;
					// Break game and announce extra turn
						GUI.getUserLeftButtonPressed("Player 2 gets an extra turn!", "Hard roll", " Soft roll");
					}
			}

		}
		
		// Update score in middle of board
			GUI.displayChanceCard("Sum of dice: " + sum + ".   Player 1's score:  " + player1.scoreString() + "\n" + "     Player 2's Score:  " + player2.scoreString());
	}	
	}
	

	
}
