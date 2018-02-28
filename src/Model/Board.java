package Model;

import java.util.ArrayList;

public class Board {

	private ArrayList<Location> Locations = new ArrayList<>();
	private int count = 0;
	private boolean blueTurn = false;

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

}
