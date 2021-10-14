package br.com.globallabs.springwebmvc.model;

//@Entity
public class Jedi {

	//private static final long serialVersionUID = 1L;

	// private Long id;
	
	private String name;
	private String lastName;

	public Jedi() {

	}

	public Jedi(String name, String lastName) {
		super();
		this.name = name;
		this.lastName = lastName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	

}
