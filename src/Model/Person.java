package Model;

public class Person {
	
	private String codename;
	private boolean red= false;
	private boolean blue = false;
	private boolean assassin = false;
	private boolean bystander = true;
	private boolean revealed = false;

	public Person(String c) {
		codename = c;
	}
	
	//getters and setters
	public boolean isRed() {
		return Red;
	}

	public void setRed() {
		Red = true;
	}

	public boolean isBlue() {
		return Blue;
	}

	public void setBlue() {
		Blue = true;
	}

	public boolean isAssassin() {
		return Assassin;
	}

	public void setAssassin() {
		Assassin = true;
	}

	public boolean isInnocent() {
		return Innocent;
	}
	
	public void setRevealed() {
		revealed = true;
	}
	
	public boolean isRevealed() {
		return revealed;
	}

}
