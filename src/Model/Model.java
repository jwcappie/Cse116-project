package Model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

public class Model {

	/**
	 * Keeps the shuffled 25 codeNames
	 * 
	 */
	private ArrayList<String> names = new ArrayList<>();

	private String clue;

	private ArrayList<Person> personList;

	/**
	 * Stores the arrayList from ReadFile as unshuffled. -Aritra
	 * 
	 */
	private ArrayList<String> unShuffledCodenames = new ArrayList<>();

	private Board currentBoard;

	public Model(String fileName) {

		Board currentBoard = new Board();
		ReadFile(fileName);
		CreateNameList(fileName);
		CreatePersonList();
		currentBoard.setBoard(personList, names);
		this.currentBoard = currentBoard;

	}

	/**
	 * This method generates 25 person types, and assigns them to be 9 red agents, 8
	 * blue agents, 7 innocent and 1 assassin, the Collections.shuffle shuffles the
	 * list to randomize the order of the assigned people
	 * 
	 * @return ArrayList of type person
	 * 
	 */

	public ArrayList<Person> CreatePersonList() {

		ArrayList<Person> tempList = new ArrayList<>();

		for (int i = 0; i < 9; i++) {
			Person red = new Person("red");
			red.setRed();
			tempList.add(red);
		}

		for (int i = 0; i < 8; i++) {
			Person blue = new Person("blue");
			blue.setBlue();
			tempList.add(blue);
		}

		for (int i = 0; i < 7; i++) {
			Person Bystander = new Person("innocent");
			Bystander.setBystander();
			tempList.add(Bystander);
		}

		for (int i = 0; i < 1; i++) {
			Person assassin = new Person("assassin");
			assassin.setAssassin();
			tempList.add(assassin);
		}

		Collections.shuffle(tempList);

		personList = tempList;
		return personList;

	}

	/**
	 * Creates List of All names, shuffles the list, adds 25 to names
	 * 
	 * @param name
	 */
	private void CreateNameList(String name) {

		ArrayList<String> fullList = ReadFile(name);

		Collections.shuffle(fullList);

		for (int i = 0; i < 25; i++) {
			names.add(fullList.get(i));
		}

	}

	/**
	 * Reads File and returns an ArrayList Containing each line
	 * 
	 * @param fileName
	 * @return
	 */
	private ArrayList<String> ReadFile(String fileName) {

		ArrayList<String> lines = new ArrayList<>();
		ArrayList<String> UnshuffledLines = new ArrayList<>();

		try {

			for (String line : Files.readAllLines(Paths.get(fileName))) {
				
				lines.add(line);
				UnshuffledLines.add(line);
			}
			unShuffledCodenames = UnshuffledLines; 

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return lines;

	}

	/**
	 * @param clue
	 *            Takes the clue and checks to see if it matches any of the
	 *            NON-REVEALED codenames currently on the board.
	 * @return
	 */
	public boolean checkClue(String clue) {
		for (Location person : this.currentBoard.getLocations()) {
			if (person.isRevealed()) {
				return true;
			} else if (clue.equals(person.getCodeName())) {
				return false;
			}
		}
		return true;
	}

	/**
	 * getters and setters
	 * 
	 * @return
	 */
	public ArrayList<String> getNames() {
		return names;
	}

	public void setNames(ArrayList<String> names) {
		this.names = names;
	}

	/**
	 * getters for unShuffled codenames -Aritra
	 * 
	 * @return
	 */
	public ArrayList<String> getUnShuffledCodenames() {
		return unShuffledCodenames;
	}

	public Board getCurrentBoard() {
		return currentBoard;
	}

	public String getString() {
		return clue;
	}

	public void setClue(String c) {
		clue = c;
	}

}
