package toranj.registration.domain;

public class Office {
	
	int idOffice;
	String name;
	public int getIdOffice() {
		return idOffice;
	}
	public void setIdOffice(int idOffice) {
		this.idOffice = idOffice;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Office(int idOffice, String name) {
		super();
		this.idOffice = idOffice;
		this.name = name;
	}
	
	
	

}
