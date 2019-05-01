package toranj.registration.domain;

public class Extra {
	
	int idExtra;
	String name;
	int money;
	public int getIdExtra() {
		return idExtra;
	}
	public void setIdExtra(int idExtra) {
		this.idExtra = idExtra;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public Extra(int idExtra, String name, int money) {
		super();
		this.idExtra = idExtra;
		this.name = name;
		this.money = money;
	}
	public Extra() {
		super();
		
	}
	
	

}
