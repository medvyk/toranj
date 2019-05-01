package toranj.registration.domain;

public class Order {
	int idSoftware;
	int idExtra;
	int idLaptop;
	int idEmployee;
	public int getIdSoftware() {
		return idSoftware;
	}
	public void setIdSoftware(int idSoftware) {
		this.idSoftware = idSoftware;
	}
	public int getIdExtra() {
		return idExtra;
	}
	public void setIdExtra(int idExtra) {
		this.idExtra = idExtra;
	}
	public int getIdLaptop() {
		return idLaptop;
	}
	public void setIdLaptop(int idLaptop) {
		this.idLaptop = idLaptop;
	}
	public int getIdEmployee() {
		return idEmployee;
	}
	public void setIdEmployee(int idEmployee) {
		this.idEmployee = idEmployee;
	}

	public Order(int idSoftware, int idExtra, int idLaptop, int idEmployee) {
		super();
		this.idSoftware = idSoftware;
		this.idExtra = idExtra;
		this.idLaptop = idLaptop;
		this.idEmployee = idEmployee;
	}
	public Order() {
		super();
		
	}
	

}
