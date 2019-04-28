package toranj.registration.domain;

public class Software {
	
	int idSoftware;
	String name;
	int stock;
	int price;
	public int getIdSoftware() {
		return idSoftware;
	}
	public void setIdSoftware(int idSoftware) {
		this.idSoftware = idSoftware;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Software(int idSoftware, String name, int stock, int price) {
		super();
		this.idSoftware = idSoftware;
		this.name = name;
		this.stock = stock;
		this.price = price;
	}
	
	

}
