package cdio1;

public class Player 

{

	private int score;
	public boolean First12;
	
//Konstruktør
public Player()
{
	score = 0;
}
// Henter scoren
public int getScore()
{
	int result = this.score;
	return result;
}
// Tilføjer en værdi til spillerens score
public void addScore(int score)
{
	this.score = this.score + score;
}
// Nulstil scoren
public void resetScore()
{
	score = 0;
}

//Printer den nuværende score som én string
public String scoreString()
{
int result = this.score;
return "" + result + "";
}
}
