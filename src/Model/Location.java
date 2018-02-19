package Model;

public class Location {
	
	private boolean Revealed;
	private Person person;
	private String codeName;

	public Location() {
		
		Revealed = false;
	}

	//Getters and Setters
	public boolean isRevealed() {
		return Revealed;
	}

	public void setRevealed(boolean revealed) {
		Revealed = revealed;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}
	
	

	

}
