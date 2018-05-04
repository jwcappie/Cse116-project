package Model;

import java.util.ArrayList;

public class Board2 {
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
	 * Boolean which returns true if it is green team's turn.
	 */
	private boolean greenTurn;
	
	
	/**
	 * Keeps track of which teams have revealed an assassin and lost.
	 */
	private boolean greenLost = false;
	private boolean redLost = false;
	private boolean blueLost = false;
	
/**
 * String equal to the winning team, either blue or red.	
 */
	private String winner;

	public Board2() {

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
				if (guess.getPerson().isBlue() == true && blueTurn) {
					count--;
					return true;
				} else if (guess.getPerson().isRed() && redTurn) {
					count--;
					return true;
				}
				else if (guess.getPerson().isGreen() && greenTurn) {
					count--;
					return true;
				}
				else if (guess.getPerson().isAssassin()) {
					removeTeam();
					return false;
				}
				}
			}
		return false;

		
	}
	/** Method defined which correctly returns whether or not the Board is in one of the winning states given and array list of Locations
	 * 
	 * @return 
	 */

	public boolean winningState() {
		int redCount = 0;
		int blueCount = 0;
		int greenCount = 0;
		int assassinCount = 0;
		ArrayList<Location> LocationTemp = Locations;
		
		for(Location check: LocationTemp) {
			if(check.isRevealed() == true) {
				if (check.getPerson().isBlue()) {
					blueCount++;
				}
				else if(check.getPerson().isRed()) {
					redCount++;
				}
				else if(check.getPerson().isGreen()) {
					greenCount++;
				}
				else if (check.getPerson().isAssassin()) {
					assassinCount++;
				}
			}
		}
		
		if (redCount == 6 && redLost == false) {
			winner = "Red";
			return true;
		}
		else if (blueCount == 5 && blueLost == false) {
			winner = "Blue";
			return true;
		}
		else if (greenCount == 5 && greenLost == false) {
			winner = "Green";
			return true;
		}
		else if (assassinCount == 2) {
			if (blueLost == false) {
				winner = "Blue";
				return true;
			}
			if (redLost == false) {
				winner = "Red";
				return true;
			}
			if (greenLost == false) {
				winner = "Green";
				return true;
			}
			return false;
		}
		else {
			return false;
		}
		
	}
	
	/** 
	 * Removes a team if they reveal an assassin.
	 * @null
	 * @return null
	 */
	public void removeTeam() {
		if (blueTurn) {
			blueLost = true;
		}
		else if (redTurn) {
			redLost = true;
		}
		else {
			greenLost = true;
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
	
	public boolean getGreenTurn() {
		return greenTurn;
	}
	
	//Changed so it no longer takes a parameter and simply sets as red turn
	public void setRedTurn() {
		redTurn = true;
		blueTurn = false;
		greenTurn = false;
	}
	
	public void setGreenTurn() {
		redTurn = false;
		blueTurn = false;
		greenTurn = true;
	}
	
	public void setBlueTurn() {
		redTurn = false;
		blueTurn = true;
		greenTurn = false;
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
	
	public boolean isGreenTurn() {
		return greenTurn;
	}

	public boolean isRedTurn() {
		return redTurn;
	}

	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}
	public boolean isGreenLost() {
		return greenLost;
	}

	public void setGreenLost(boolean greenLost) {
		this.greenLost = greenLost;
	}

	public boolean isRedLost() {
		return redLost;
	}

	public void setRedLost(boolean redLost) {
		this.redLost = redLost;
	}

	public boolean isBlueLost() {
		return blueLost;
	}

	public void setBlueLost(boolean blueLost) {
		this.blueLost = blueLost;
	}


}
