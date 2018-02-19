package Model;

import java.util.ArrayList;

public class Board {
	
	private ArrayList<Location> Locations = new ArrayList <>();

	public Board() {
		
		//Creates 25 instances of Location and Stores in a ArrayList
		for(int i = 0; i<25; i++)
		{
			Locations.add(new Location());
		}
		
		
		
	}
	
	//Given a List of People and codeNames; assigns one to each location 
	public void setBoard(ArrayList<Person> PersonList, ArrayList<String> NameList)
	{
		
		int i = 0;
		for(Location temp: Locations)
		{
			temp.setCodeName(NameList.get(i));
			temp.setPerson(PersonList.get(i));
			i++;
		}
	}
	
	//Getters and Setters

	public ArrayList<Location> getLocations() {
		return Locations;
	}

	public void setLocations(ArrayList<Location> locations) {
		Locations = locations;
	}

}
