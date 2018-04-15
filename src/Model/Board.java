package Model;

import java.util.ArrayList;

public class Board {
/**
 * Arraylist containing all 25 location spots
 */
	private ArrayList<Location> Locations = new ArrayList<>();

	private int count = 0;
/**
 * Integer equal to the current round number
 */
	private int round = 0;
	
/**
 * Boolean which returns true if it is red team's turn.
 */
	private boolean redTurn;
/** 
 * Boolean which returns true if it is blue team's turn.
 */
	private boolean blueTurn;
	
/**
 * String equal to the winning team, either blue or red.	
 */
	private String winner;

	public Board() {

		/** Creates 25 instances of Location and Stores in a ArrayList
		 * 
		 */
		for (int i = 0; i < 25; i++) {
			Locations.add(new Location());
		}

	}

	/** Given a List of People and codeNames; assigns one to each location
	 * 
	 * @param PersonList
	 * @param NameList
	 */
	public void setBoard(ArrayList<Person> PersonList, ArrayList<String> NameList) {

		int i = 0;
		for (Location temp : Locations) {
			temp.setRevealed(false);
			temp.setCodeName(NameList.get(i));
			temp.setPerson(PersonList.get(i));
			i++;
		}
	}

	/**
	 * Method defined which decrements the count, updates a Location when the
	 * Location's codename was selected, and returns if the Location contained the
	 * current team's Agent blueTurn is a boolean used to check if it is red or
	 * blues turn currently
	 * 
	 * Takes in codename-- checks for coresponding location then if the guess is correct or not
	 */

	public boolean guessCheck(String guessCode) {

		for (Location guess : Locations) {
			if (guessCode.equals(guess.getCodeName())) {
				guess.setRevealed(true);
				if (guess.getPerson().isBlue() == true && blueTurn == true) {
					count = count - 1;

					return true;
				} else if (guess.getPerson().isRed() == true && blueTurn == false) {
					count = count - 1;

					return true;
				}
				}
			}
		return false;

		
	}
	/** Method defined which correctly returns whether or not the Board is in one of the winning states given and array list of Locations
	 * 
	 * @return 
	 */

	public boolean winningState()
	{
		int redCount = 0;
		int blueCount = 0;
		ArrayList<Location> LocationTemp = Locations;
		
		for(Location check: LocationTemp)
		{
			if(check.isRevealed()== true)
			{
			if (check.getPerson().isBlue() == true)
			{
				blueCount = blueCount + 1;
			}
			else if(check.getPerson().isRed() == true)
			{
				redCount = redCount+1;
			}
			else if(check.getPerson().isAssassin() == true)
			{
				assassinWin();
				return true;
			}
			}
		}
		
		if(redCount == 9)
		{
			winner = "Red";
			return true;
		}
		else if (blueCount == 8)
		{
			winner = "Blue";
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	/**
	 * Takes in an int (round number) as a parameter and sets who's turn it is during that round
	   If redTurn is true than it is red's turn, if blueTurn is true than it is Blue's turn
	 * @param r - the current round number
	 *  **/
	public void whosTurn () {
			if (round % 2 == 0) {
				redTurn = true;
				blueTurn = false;
			}
			else {
				redTurn = false;
				blueTurn = true;
			}
		}

	/** 
	 * If the Assassin is revealed then it will return who the winner is
	 * @param r - the round number
	 * @return winner - String containing the name of the team that has won due to the other team revealing the assassin
	 */
	public String assassinWin () {
		whosTurn();
		
		for (Location assassinLocate : Locations) {
			if (assassinLocate.getPerson().isAssassin() == true) {
				if (blueTurn == true && assassinLocate.isRevealed() == true) {
					winner = "Red";
				}
				if (redTurn == true && assassinLocate.isRevealed() == true) {
					winner = "Blue"; 
				}
			}
		}
		return winner;
	}
	
	/** Getters and Setters
	 * 
	 * @return
	 */

	public ArrayList<Location> getLocations() {
		return Locations;
	}

	public void setLocations(ArrayList<Location> locations) {
		Locations = locations;
	}
	
	public int getRound() {
		return round;
	}
	
	public void setRound(int r) {
		round = r;
	}
	
	/** Getter and Setter method of Redturn
	 * 
	 * @return
	 */
	public boolean getRedTurn() {
		return redTurn;
	}
	
	public void setRedTurn(boolean x) {
		redTurn = x;
		blueTurn = !x;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public boolean isBlueTurn() {
		return blueTurn;
	}

	public void setBlueTurn(boolean blueTurn) {
		this.blueTurn = blueTurn;
		redTurn = !blueTurn;
	}

	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}

}
