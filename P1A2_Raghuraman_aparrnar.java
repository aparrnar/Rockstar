import java.io.IOException;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author aparrnaa
 * Creation Date: 06/09/2017
 * Last Modified Date: 06/09/2017
 * Description:
 * The program does the following:
	 * Gets the player name from the user
	 * Prints a welcome message on the console
	 * Displays the creator name and a short description of the game on the console
	 * Displays the game rules
	 * Start the game
 */
public class P1A2_Raghuraman_aparrnar {
	
	/**
	 * @param name
	 * Print a message greeting the player
	 * Print a message with the name of the game creator
	 * Provide a one liner of what the game does
	 * Display the game rules for the player
	 */
	public static void welcome(String name)
	{
		System.out.println("Hello "+name+"!");
		System.out.print("\n");
		System.out.print("\n");
		System.out.println("***Creator Name and Game Description***");
		System.out.println("Hello, my name is Aparrnaa Raghuraman! ");
		System.out.println("The program is a simulation of a dice game where four dice are rolled and the win/loss is predicted based on a set of predetermined rules");
		System.out.print("\n");
		System.out.print("\n");
		System.out.println("***View Game Instructions***");
		System.out.println("A new player begins with his first dice roll (4 die = 1 set of dice). This is known as the starting roll");
		System.out.println("If the player rolls a 6, 12, 18, or 24 the player wins.");
		System.out.println("If the player rolls a 9, 11, 17, 19, or 23 the player loses");
		System.out.println("If the player rolls any other number the starting roll becomes the goal number");
		System.out.println("The player must continue to roll the dice until either one of two things happens:");
		System.out.println("\t\t The player rolls an 11, and he loses.");
		System.out.println("\t\t The player rolls the goal number again, and he wins");
		
	}
	
	/**
	 * Playing the game
	 */
	public static void startGame()
	{
		System.out.println("The game has begun");
		boolean playerWonOrLost = false;  //Set to true when player wins or loses,  false when player has to continue the game
		int diceValue, minRange = 4, maxRange = 24;
		/* diceValue takes integer values between 4 and 24, 
		 * since these are the minimum and maximum values 
		 * that can be obtained by rolling four six faced dice
		 * To generate random numbers within the interval 4 to 24, minRange and maxRange are defined
		 */
		int goalNumber = 0; //This value is set when the player rolls a value other than 6,12,18,24,9,11,17,19,23
			System.out.println("Rolling the dice..");
			diceValue = ThreadLocalRandom.current().nextInt(minRange, maxRange + 1);
				System.out.println("You have rolled: "+diceValue);
				//attemptNumber++;
				if(diceValue == 6 || diceValue == 12 || diceValue == 18 || diceValue == 24 || diceValue == goalNumber)
				{
					System.out.println("Congratulations!! You have won!");
					playerWonOrLost = true;
					promptToPlayAgain();
				}
				else if(diceValue == 9 || diceValue == 11 || diceValue == 17 || diceValue == 19 || diceValue == 23)
				{
					System.out.println("Ooops! You lost! Soo close :(");
					playerWonOrLost = true;
					promptToPlayAgain();
				}
				else
				{
					goalNumber = diceValue;
					System.out.println("You need to roll "+goalNumber+" to win"); //set goalNumber as the winning target
					playerWonOrLost = false;
					do
					{
						System.out.println("Press enter to roll again");
						detectEnterPress();
						System.out.print("\n");
						System.out.println("Rolling the dice..");
						diceValue = ThreadLocalRandom.current().nextInt(minRange, maxRange + 1);
						System.out.println("You have rolled: "+diceValue);
						if(diceValue == goalNumber)
						{
							System.out.println("Congratulations!! You have won!");
							playerWonOrLost = true;
							promptToPlayAgain();
						}
						else if(diceValue == 11)
						{
							System.out.println("Ooops! You lost! Soo close :(");
							playerWonOrLost = true;
							promptToPlayAgain();
						}
						else
						{
							System.out.println("You need to roll "+goalNumber+" to win");

						}
					}while(playerWonOrLost == false);
				}	
	}
	
	/**
	 * The below function waits and detects an enter key press from the user.
	 */
	public static void detectEnterPress()
	{
		try {
            int read = System.in.read(new byte[2]);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static void promptToPlayAgain()
	{
		boolean askAgain = false;
		do
		{
			System.out.println("Do you want to start a new game? Press y or Y to start a new game or n or N to exit");
			Scanner input = new Scanner(System.in);
			char userValue = input.next().charAt(0); 
			if(userValue == 'y' || userValue == 'Y')
			{
				startGame(); //start a new game
			}
			else if(userValue == 'n' || userValue == 'N')
			{
				System.exit(0); //Exiting the program
			}
			else
			{
				System.out.println("Invalid option! Enter y or Y to continue or n or N to exit");
				askAgain = true;
			}
		}while(askAgain == true);
	}
	
	/**
	 * @param args
	 * The main function places function calls to do the following:
	 * Get the player name from the user
	 * Print a welcome message on the console
	 * Display the creator name and a short description of the game on the console
	 * Display the game rules
	 * Start the game
	 */
	public static void main(String[] args) {
	Scanner input = new Scanner(System.in); //To receive input from the user
	System.out.println("Hi User! Enter your name: ");
	String userName = input.nextLine();
	welcome(userName); //Display welcome message, creator name, game description and rules
	System.out.print("\n");
	System.out.print("\n");
	System.out.println("Do you want to start the game? Press enter to start!");
	detectEnterPress();
	startGame();	
	}

}
