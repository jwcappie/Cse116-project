package Model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

public class Model {

	/** Keeps the shuffled 25 codeNames
	 * 
	 */
	private ArrayList<String> names = new ArrayList<>();
	
	private String clue;
	
	private ArrayList<Person> personList;
	
	/**Stores the arrayList from ReadFile as unshuffled. -Aritra
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

	/** Creates List of 9 red agents, 8 blue agents, 7 innocent, 1 assassin shuffles the list
	 * 
	 */
	private void CreatePersonList() {

		ArrayList<Person> tempList = new ArrayList<>();

		for (int i = 0; i < 25; i++) {
			Person temp = new Person();

			if (i < 9) {
				temp.setRed();
			} else if (i >= 9 && i < 17) {
				temp.setBlue();
			} else if (i >= 17 && i < 24) {
				temp.setBystander();
			} else {
				temp.setAssassin();
			}

			tempList.add(temp);
		}

		Collections.shuffle(tempList);

		personList = tempList;

	}

	/** Creates List of All names, shuffles the list, adds 25 to names
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

	/** Reads File and returns an ArrayList Containing each line
	 * 
	 * @param fileName
	 * @return
	 */
	private ArrayList<String> ReadFile(String fileName) {

		ArrayList<String> lines = new ArrayList<>();

		try {

			for (String line : Files.readAllLines(Paths.get(fileName))) {
				lines.add(line);
			}

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		unShuffledCodenames = lines;
		return lines;

	}
	
	/**
	 * @param clue
	 * Takes the clue and checks to see if it matches any of the NON-REVEALED codenames currently on the board.
	 * @return
	 */
	public boolean checkClue(String clue) {
		for (Location person : this.currentBoard.getLocations()) {
			if (person.isRevealed()) {
				return true;
			}
			else if (clue.equals(person.getCodeName())) {
				return false;
			}
		}
		return true;
	}

	/** getters and setters
	 * 
	 * @return
	 */
	public ArrayList<String> getNames() {
		return names;
	}

	public void setNames(ArrayList<String> names) {
		this.names = names;
	}
		
	/** getters for unShuffled codenames -Aritra 
	 * 
	 * @return
	 */
	public ArrayList<String> getUnShuffledCodenames(){
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
