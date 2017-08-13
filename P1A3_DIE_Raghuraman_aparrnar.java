import java.util.concurrent.ThreadLocalRandom;

/**
 * @author aparrnaa
 * Creation Date: 06/09/2017
 * Last Modified Date: 06/10/2017
 * Description:
 * The program defines the class structure for a Die object
 */

public class P1A3_DIE_Raghuraman_aparrnar {

	private int numberOfSides;
	private int currentValue;
	private String color;
	public static int numberOfInstances;
	
	/**
	 * @param numberOfSides - the number of sides in the die object
	 * @param currentValue - the current value shown in the face of the die object
	 * @param color - the color of the die object
	 */
	public P1A3_DIE_Raghuraman_aparrnar(int numberOfSides, int currentValue, String color) {
		this.numberOfSides = numberOfSides;
		this.currentValue = currentValue;
		this.color = color;
		numberOfInstances++; //increment total number of die instances
	}
	
	/**
	 * No argument constructor
	 * Initialize die object values to 0
	 */
	public P1A3_DIE_Raghuraman_aparrnar()
	{
		this.numberOfSides = 0;
		this.currentValue = 0;
		this.color = null;
		numberOfInstances = 0;
	}
		
	
	/**
	 * Generates a random number from 1 to the number of sides in the die
	 * @return diceValue - value obtained from roll of a single die
	 */
	public int rollDie()
	{
		int minRange = 1, maxRange = this.numberOfSides;
		int diceValue;
		diceValue = ThreadLocalRandom.current().nextInt(minRange, maxRange + 1);
		setCurrentValue(diceValue);
		return diceValue;
	}

	/**
	 * @return the numberOfInstances of dice
	 */
	public static int getNumberOfInstances() {
		return numberOfInstances;
	}

	/**
	 * @param currentValue - the currentValue of the die to set
	 */
	public void setCurrentValue(int currentValue) {
		this.currentValue = currentValue;
	}

	/**
	 * @return the numberOfSides
	 */
	public int getNumberOfSides() {
		return numberOfSides;
	}

	/**
	 * @param numberOfSides - the numberOfSides of the die to set
	 */
	public void setNumberOfSides(int numberOfSides) {
		this.numberOfSides = numberOfSides;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color- the color of the die to set
	 */
	public void setColor(String color) {
		this.color = color;
	}


}
