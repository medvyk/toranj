package toranj.registration.domain;

import java.util.Date;
import toranj.login.domain.User;

public class Employee {
	int idEmployee;
	String name;
	String surname;
	Date arrivalDate;
	String comment;
	Office office;
	Position position;
	Extra extra;
	Software software;
	User user;
	public int getIdEmployee() {
		return idEmployee;
	}
	public void setIdEmployee(int idEmployee) {
		this.idEmployee = idEmployee;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public Office getOffice() {
		return office;
	}
	public void setOffice(Office office) {
		this.office = office;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public Extra getExtra() {
		return extra;
	}
	public void setExtra(Extra extra) {
		this.extra = extra;
	}
	public Software getSoftware() {
		return software;
	}
	public void setSoftware(Software software) {
		this.software = software;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Employee(int idEmployee, String name, String surname, Date arrivalDate, String comment, Office office,
			Position position, Extra extra, Software software, User user) {
		super();
		this.idEmployee = idEmployee;
		this.name = name;
		this.surname = surname;
		this.arrivalDate = arrivalDate;
		this.comment = comment;
		this.office = office;
		this.position = position;
		this.extra = extra;
		this.software = software;
		this.user = user;
	}
	public Employee() {
		super();
	}
	
	
	
}