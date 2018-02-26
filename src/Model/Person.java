package Model;

public class Person {
	
	private String codename;
	private boolean red= false;
	private boolean blue = false;
	private boolean assassin = false;
	private boolean bystander = true;
	private boolean revealed = false;

	public Person() {
		
	}
	
	//getters and setters
	public boolean isRed() {
		return red;
	}

	public void setRed() {
		red = true;
	}

	public boolean isBlue() {
		return blue;
	}

	public void setBlue() {
		blue = true;
	}

	public boolean isAssassin() {
		return assassin;
	}

	public void setAssassin() {
		assassin = true;
	}

	public boolean isBystander() {
		return bystander;
	}
	
	public void setBystander() {
		bystander = true;
	}
	
	public void setRevealed() {
		revealed = true;
	}
	
	public boolean isRevealed() {
		return revealed;
	}

}
