package Model;

import java.util.ArrayList;

public class Board {

	private ArrayList<Location> Locations = new ArrayList<>();
	private int count = 0;
	private boolean blueTurn = false;
	
	private int round;
	
	private boolean redTurn;
	
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
			temp.setCodeName(NameList.get(i));
			temp.setPerson(PersonList.get(i));
			i++;
		}
	}

	/**
	 * Method defined which decrements the count, updates a Location when the
	 * Location's codename was selected, and returns if the Location contained the
	 * current team's Agent
	 *  blueTurn is a boolean used to check if it is red or blues turn currently
	 */


	public boolean guessCheck(Location guess) {
		guess.setRevealed(true);
		if (guess.getPerson().isBlue() == true && blueTurn == true) {
			count = count - 1;

			return true;
		} else if (guess.getPerson().isRed() == true && blueTurn == false) {
			count = count - 1;

			return true;
		} else {
			return false;
		}

	}

	/** Method defined which correctly returns whether or not the Board is in one of the winning states
	 * 
	 * @return 
	 */

	public boolean winningState()
	{
		int redCount = 0;
		int blueCount = 0;
		
		for(Location check: Locations)
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
				return true;
			}
			}
		}
		
		if(redCount == 9)
		{
			return true;
		}
		else if (blueCount == 8)
		{
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
	public void whosTurn (int r) {
		round = r;
			if (r % 2 == 0) {
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
	public String assassinWin (int r) {
		round = r;
		whosTurn(round);
		
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
	}

}
