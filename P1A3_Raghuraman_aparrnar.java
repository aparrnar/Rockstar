import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author aparrnaa
 * Creation Date: 06/09/2017
 * Last Modified Date: 06/10/2017
 * Description:
 * The program does the following:
	 * Gets the player name from the user
	 * Prints a welcome message on the console
	 * Displays the creator name and a short description of the game on the console
	 * Displays the game rules
	 * Start the game
 */

public class P1A3_Raghuraman_aparrnar {
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
		System.out.println("****************");
		System.out.println("Creator Name and Game Description");
		System.out.println("****************");
		System.out.println("Hello, my name is Aparrnaa Raghuraman! ");
		System.out.println("The program is a simulation of a dice game where four dice are rolled and the win/loss is predicted based on a set of predetermined rules");
		System.out.print("\n");
		System.out.print("\n");
		System.out.println("****************");
		System.out.println("Game Instructions");
		System.out.println("****************");
		System.out.println("A new player begins with his first dice roll (4 die = 1 set of dice). This is known as the starting roll");
		System.out.println("If the player rolls a 6, 12, 18, or 24 the player wins.");
		System.out.println("If the player rolls a 9, 11, 17, 19, or 23 the player loses");
		System.out.println("If the player rolls any other number the starting roll becomes the goal number");
		System.out.println("The player must continue to roll the dice until either one of two things happens:");
		System.out.println("\t\t The player rolls an 11, and he loses.");
		System.out.println("\t\t The player rolls the goal number again, and he wins");
	}

	/**
	 * Playing the game manually
	 * @param dieObjects[] - an array of die objects created
	 */
	public static void startGame(P1A3_DIE_Raghuraman_aparrnar dieObjects[])
	{
		System.out.println("The game has begun");
		boolean playerWonOrLost = false;  //Set to true when player wins or loses,  false when player has to continue the game
		int diceValue = 0;
		int dieCounter = 0;
		int totalDiceValue = 0; //gives the sum of all four die rolls
		int goalNumber = 0; //This value is set when the player rolls a value other than 6,12,18,24,9,11,17,19,23
			System.out.println("Rolling the dice..");
			for(dieCounter = 0; dieCounter < 4; dieCounter++)
			{
				diceValue = dieObjects[dieCounter].rollDie(); //roll individual dice
				totalDiceValue += diceValue; //calculate sum
			}
				System.out.println("You have rolled: "+totalDiceValue);
				if(totalDiceValue == 6 || totalDiceValue == 12 || totalDiceValue == 18 || totalDiceValue == 24 || totalDiceValue == goalNumber)
				{
					System.out.println("Congratulations!! You have won!");
					playerWonOrLost = true;
				}
				else if(totalDiceValue == 9 || totalDiceValue == 11 || totalDiceValue == 17 || totalDiceValue == 19 || totalDiceValue == 23)
				{
					System.out.println("Ooops! You lost! Soo close :(");
					playerWonOrLost = true;
				}
				else
				{
					goalNumber = totalDiceValue;
					System.out.println("You need to roll "+goalNumber+" to win"); //set goalNumber as the winning target
					playerWonOrLost = false;
					do
					{
						totalDiceValue = 0;
						System.out.println("Press enter to roll again");
						detectEnterPress(); //wait for enter key
						System.out.print("\n");
						System.out.println("Rolling the dice..");
						for(dieCounter = 0; dieCounter < 4; dieCounter++)
						{
							diceValue = dieObjects[dieCounter].rollDie();
							totalDiceValue += diceValue;
						}
						System.out.println("You have rolled: "+totalDiceValue);
						if(totalDiceValue == goalNumber)
						{
							System.out.println("Congratulations!! You have won!");
							playerWonOrLost = true;
						}
						else if(totalDiceValue == 11)
						{
							System.out.println("Ooops! You lost! Soo close :(");
							playerWonOrLost = true;
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
	 * @exception IOException
	 */
	public static void detectEnterPress()
	{
		try {
            int read = System.in.read(new byte[2]);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	/**
	 *The function automatically plays the game in the computer for numTimes number of times and returns the total wins and losses to the user
	 * Also returns the outcome of every game, along with the die rolls that led to the outcome
	 * @param dieObjects - an array of die objects created
	 * @param numTimes - number of times the game is to be played
	 */
	public static void startGameAuto(P1A3_DIE_Raghuraman_aparrnar dieObjects[], int numTimes)
	{
		int totalWins= 0, totalLosses = 0;
		int dieCounter;
		int totalDiceValue = 0, diceValue = 0;
		int num = 1;
		while(num <= numTimes) //play that many number of times
		{
			totalDiceValue = 0;
			System.out.println("******************************");
			System.out.println("Game "+num+" has begun");
			System.out.println("******************************");
			boolean playerWonOrLost = false;  //Set to true when player wins or loses,  false when 
			int goalNumber = 0; //This value is set when the player rolls a value other than 6,12,18,24,9,11,17,19,23
				
			System.out.print("\n");
			System.out.println("Rolling the dice..");
			for(dieCounter = 0; dieCounter < 4; dieCounter++)
			{
				diceValue = dieObjects[dieCounter].rollDie();
				//System.out.println(dieCounter+": "+diceValue);
				totalDiceValue += diceValue;
			}
			
			System.out.println("You have rolled: "+totalDiceValue);
			if(totalDiceValue == 6 || totalDiceValue == 12 || totalDiceValue == 18 || totalDiceValue == 24 || totalDiceValue == goalNumber)
			{
				System.out.println("Congratulations!! You have won!");
				playerWonOrLost = true;
				totalWins++;
				num++;
				continue;
			}
			else if(totalDiceValue == 9 || totalDiceValue == 11 || totalDiceValue == 17 || totalDiceValue == 19 || totalDiceValue == 23)
			{
				System.out.println("Ooops! You lost! Soo close :(");
				playerWonOrLost = true;
				totalLosses++;
				num++;
				continue;
			}
			else
			{
				goalNumber = totalDiceValue;
				System.out.println("You need to roll "+goalNumber+" to win"); //set goalNumber as the winning target
				playerWonOrLost = false;
				do
				{
					System.out.print("\n");
					System.out.println("Rolling the dice..");
					totalDiceValue = 0;
					
					for(dieCounter = 0; dieCounter < 4; dieCounter++)
					{
						diceValue = dieObjects[dieCounter].rollDie();
						totalDiceValue += diceValue;
					}
						System.out.println("You have rolled: "+totalDiceValue);
						
					if(totalDiceValue == goalNumber)
					{
						System.out.println("Congratulations!! You have won!");
						playerWonOrLost = true;
						totalWins++;
						num++;
						continue;
					}
					
					else if(totalDiceValue == 11)
					{
						System.out.println("Ooops! You lost! Soo close :(");
						playerWonOrLost = true;
						totalLosses++;
						num++;
						continue;
					}
					
					else
					{
						System.out.println("You need to roll "+goalNumber+" to win");
					}
				}while(playerWonOrLost == false);
			}
		}
		System.out.print("\n");
		System.out.println("****************");
		System.out.println("Game statistics");
		System.out.println("****************");
		System.out.println("Number of games won: "+totalWins);
		System.out.println("Number of games lost: "+totalLosses);
		
	}
	
	/**
	 * @param args
	 * The main function does the following:
	 * Display welcome Message
	 * Create and Initialize die objects
	 * Get user input to play manually or by the computer
	 * If chosen to play by computer, get the number of times the game is to be played from the user
	 * 
	 */
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Hi User! Enter your name: ");
		String userName = input.next();
		welcome(userName);
		
		P1A3_DIE_Raghuraman_aparrnar dieObjects[] = new P1A3_DIE_Raghuraman_aparrnar[4]; //Creates 4 die Objects
		int userChoice = 0;
		for(int objectCounter = 0; objectCounter < 4; objectCounter++ )
		{
			System.out.println("Enter the number of sides in die "+(objectCounter+1));
			int numberOfSides = input.nextInt();
			System.out.println("Enter the colour in die "+(objectCounter+1));
			String colour = input.next();
			dieObjects[objectCounter] = new P1A3_DIE_Raghuraman_aparrnar(numberOfSides, 0, colour);
			System.out.println("Die "+(objectCounter+1)+" created");
		}
		
		do
		{
		System.out.println("****************");
		System.out.println("Enter 1 to play manually and 2 for the computer to play on its own");
		System.out.println("To exit, press 0");
		System.out.println("****************");
		userChoice = input.nextInt();
		switch(userChoice)
		{
		case 0: System.out.println("Exiting the game...");
				System.out.println("Thanks for playing, "+userName+"!");
				System.exit(0);
				break;
		case 1: startGame(dieObjects);
		break;
		case 2: 
			System.out.println("Enter the number of times the computer should play the game");
			int numTimes = input.nextInt(); //number of times the game must be played by the computer
			if(numTimes == 0)
			{
				System.out.println("Enter a valid number of times");
				continue;
			}
			startGameAuto(dieObjects, numTimes);
			break;
		default:
			System.out.println("Invalid Option");
			continue;
		}
		}while(userChoice != 0);
				
	
	}

}
