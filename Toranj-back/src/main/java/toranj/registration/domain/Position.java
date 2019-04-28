package toranj.registration.domain;

public class Position {

	int idPosition;
	String name;
	public int getIdPosition() {
		return idPosition;
	}
	public void setIdPosition(int idPosition) {
		this.idPosition = idPosition;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Position(int idPosition, String name) {
		super();
		this.idPosition = idPosition;
		this.name = name;
	}
	
	
}
