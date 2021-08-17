import java.util.Random;

public class SnakeAndLadder {

	final int ENDPOSITION=100;
	final int STARTPOSITION=0;
	int userPosition;
	int dice;
	int option;
	public SnakeAndLadder(){
		userPosition = STARTPOSITION;
		System.out.println("User ready to Go....");
	}
	static {
		System.out.println("Welcome to Snakes and Ladders Game");
	}
	
	public int rollDice(){
		Random randomRoll = new Random();
		int move;
			dice = randomRoll.nextInt(6)+1;
			System.out.println("Dice Rolled value: " + dice);
			move = playGame();
			switch(move){
			  case 1: 
				  if((userPosition+dice)<= ENDPOSITION) {
					  userPosition = userPosition + dice;
					  System.out.println("User At Position: " + userPosition);
				  }
				  else {
					  System.out.println("Player getting More than : " +ENDPOSITION);
				  }
				  break;
			  case 2:
				  if((userPosition-dice)<0) {
					  System.out.println("User back to start");
					  userPosition=0;
					  System.out.println("User Position at: " + userPosition);
				  }
				  else {
					  userPosition = userPosition - dice;
					  System.out.println("User Position at: " + userPosition);
				  }
				  break;
			  default:
				  System.out.println("Stay in place");
				  System.out.println("User Position at: " + userPosition);
			}
			return userPosition;
		
	}

	public int playGame() {
		Random randomOption = new Random();
		option = randomOption.nextInt(3);
		if(option==0) {
			System.out.println("No play");
			return 0;
		}
		else if(option==1) {
			System.out.println("Ladder");
			return 1;	
		}
		else {
			System.out.println("Snake");
			return 2;
		}
		
	}

	public static void main(String[] args) {
		int winnerPos=0;
		int diecounter=0;
		SnakeAndLadder player1 = new SnakeAndLadder();
		SnakeAndLadder player2 = new SnakeAndLadder();
		while(winnerPos<100) {
			System.out.println("##player1##");
			winnerPos=player1.rollDice();
			if(winnerPos==100) {
				System.out.println("Player 1 is winner with Die Count :" +diecounter);
			}
			System.out.println("##player2##");
			winnerPos=player2.rollDice();
			if(winnerPos==100) {
				System.out.println("Player2 is winner with Die Count :" +diecounter);
			}
			System.out.println("--GAME END--");
			diecounter++;
		}
	}
}

