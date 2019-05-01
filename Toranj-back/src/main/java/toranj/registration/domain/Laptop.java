package toranj.registration.domain;

public class Laptop {
	int idLaptop;
	String name;
	int price;
	public int getIdLaptop() {
		return idLaptop;
	}
	public void setIdLaptop(int idLaptop) {
		this.idLaptop = idLaptop;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Laptop(int idLaptop, String name, int price) {
		super();
		this.idLaptop = idLaptop;
		this.name = name;
		this.price = price;
	}
	public Laptop() {
		super();
		
	}
	
	

}
