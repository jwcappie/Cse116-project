package Model;

public class Person {
	
	private String codename;
	private boolean red= false;
	private boolean blue = false;
	private boolean assassin = false;
	private boolean bystander = true;
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
	public String getCodename() {
		return codename;
	}

	/**
	 * @param codename the codename to set
	 */
	public void setCodename(String codename) {
		this.codename = codename;
	}
	


}
