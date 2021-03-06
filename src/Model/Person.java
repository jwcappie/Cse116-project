package Model;

public class Person {
	
	private String personType;
	private boolean red= false;
	private boolean green= false;
	private boolean blue = false;
	private boolean assassin = false;
	private boolean bystander = false;
	private boolean revealed = false;
	/**
	 * This constructor assigns a string value to the field codeName
	 * @param c string value to be assigned to the field codeName
	 */
	public Person(String c) {
		setCodename(c);
		
	}
	
	
	/**
	 * This checks if the person is red if so it returns true
	 * @return boolean true 
	 */
	public boolean isRed() {
		return red;
	}

	/**
	 * This method assigns the field red to true	
	 */
	public void setRed() {
		red = true;
	}
	
	/**
	 * This method assigns the field green to true	
	 */
	public void setGreen() {
		green = true;
	}
	
	

	/**
	 * This checks if the person is blue if so it returns true
	 * @return boolean true 
	 */
	public boolean isBlue() {
		return blue;
	}
	/**
	 * This method assigns the field blue to true	
	 */
	public void setBlue() {
		blue = true;
	}
	
	/**
	 * This method assigns the field blue to true	
	 */
	public boolean isGreen() {
		return green;
	}
	
	
	/**
	 * This checks if the person is assassin if so it returns true
	 * @return boolean true 
	 */
	public boolean isAssassin() {
		return assassin;
	}
	/**
	 * This method assigns the field red to true	
	 */
	public void setAssassin() {
		assassin = true;
	}
	
	
	/**
	 * This checks if the person is bystander if so it returns true
	 * @return boolean true 
	 */
	public boolean isBystander() {
		return bystander;
	}
	
	public void setBystander() {
		bystander = true;
	}

	
	
	/**
	 * @return the codename as string
	 */
	public String getPersonType() {
		return personType;
	}

	/**
	 * @param codename the codename to set
	 */
	public void setCodename(String codename) {
		this.personType = codename;
	}
	


}
