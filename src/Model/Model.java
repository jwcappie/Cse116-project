package Model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

public class Model {

	private ArrayList<String> names = new ArrayList<>();
	private ArrayList<Person> personList;
	private ArrayList<String> unShuffledCodenames = new ArrayList<>();   //Stores the arrayList from ReadFile as unshuffled. -Aritra
//	private String text_File_For_CodeName = "";

	public Model(String fileName) {

		Board currentBoard = new Board();
		ReadFile(fileName);
		CreateNameList(fileName);
		CreatePersonList();
		currentBoard.setBoard(personList, names);

	}

	// Creates List of 9 red agents, 8 blue agents, 7 innocent, 1 assassin shuffles
	// the list
	private void CreatePersonList() {

		ArrayList<Person> tempList = new ArrayList<>();

		for (int i = 0; i < 25; i++) {
			Person temp = new Person();

			if (i < 9) {
				temp.setRed();
			} else if (i >= 9 && i < 16) {
				temp.setBlue();
			} else if (i >= 16 && i < 23) {
				temp.setBystander();
			} else {
				temp.setAssassin();
			}

			tempList.add(temp);
		}

		Collections.shuffle(tempList);

		personList = tempList;

	}

	// Creates List of All names, shuffles the list, adds 25 to names
	private void CreateNameList(String name) {

		ArrayList<String> fullList = ReadFile(name);

		Collections.shuffle(fullList);

		for (int i = 0; i < 25; i++) {
			names.add(fullList.get(i));
		}

	}

	// Reads File and returns an ArrayList Containing each line
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

	// getters and setters
	public ArrayList<String> getNames() {
		return names;
	}

	public void setNames(ArrayList<String> names) {
		this.names = names;
	}
		
	//getters for unShuffled codenames -Aritra 
	public ArrayList<String> getUnShuffledCodenames(){
		return unShuffledCodenames;
	}
}
