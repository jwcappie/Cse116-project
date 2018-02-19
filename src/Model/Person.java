package Model;

public class Person {
	
	private boolean Red= false;
	private boolean Blue = false;
	private boolean Assassin = false;
	private boolean Innocent = false;

	public Person() {
		
		
		
	}
	
	//getters and setters
	public boolean isRed() {
		return Red;
	}

	public void setRed(boolean red) {
		Red = red;
	}

	public boolean isBlue() {
		return Blue;
	}

	public void setBlue(boolean blue) {
		Blue = blue;
	}

	public boolean isAssassin() {
		return Assassin;
	}

	public void setAssassin(boolean assassin) {
		Assassin = assassin;
	}

	public boolean isInnocent() {
		return Innocent;
	}

	public void setInnocent(boolean innocent) {
		Innocent = innocent;
	}

}
