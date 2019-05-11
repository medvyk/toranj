package toranj.global.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import toranj.common.repository.DataBaseConnectionUtil;
import toranj.registration.domain.Employee;
import toranj.registration.domain.Extra;
import toranj.registration.domain.Laptop;
import toranj.registration.domain.Office;
import toranj.registration.domain.Position;
import toranj.registration.domain.Software;

public class GlobalRepository {
	
	
	//show employee main table
	
	public List<Employee> showEmployee() {
		
		DataBaseConnectionUtil connectionUtil = new DataBaseConnectionUtil();
		Connection connection = connectionUtil.connect();	
		List<Employee> fullEmployee = new ArrayList<>();
		
		String query= "select employee.name, employee.surname, office.name as officeName,\r\n" + 
				"position.name as positionName, extra.name as extraName,\r\n" + 
				"software.name as softwareName, laptop.name as laptopName, employee.dateArrival, employee.comment from toranjdb.employee\r\n" + 
				"inner join toranjdb.office as office on office.idOffice = employee.idOffice  \r\n" + 
				"inner join toranjdb.position as position on position.idPosition=employee.idPosition \r\n" + 
				"inner join toranjdb.extra as extra on extra.idExtra=employee.idExtra \r\n" + 
				"inner join toranjdb.software as software on software.idSoftware=employee.idSoftware \r\n" + 
				"inner join toranjdb.laptop as laptop on laptop.idLaptop=employee.idLaptop" ;
			
		
		try{
			Statement st= connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			
			while (rs.next()) {
				Employee e = new Employee();
				
				Office o = new Office();
				o.setName(rs.getString("officeName"));
				
				Position p = new Position();
				p.setName(rs.getString("positionName"));;
				
				Extra ex = new Extra();
				ex.setName(rs.getString("extraName"));
				
				Software s = new Software();
				s.setName(rs.getString("softwareName"));
				
				Laptop l = new Laptop();
				l.setName(rs.getString("laptopName"));
				
				
				e.setName(rs.getString("name"));
				e.setSurname(rs.getString("surname"));
				e.setOffice(o);
				e.setPosition(p);
				e.setSoftware(s);
				e.setLaptop(l);
				e.setExtra(ex);
				e.setArrivalDate(rs.getDate("dateArrival"));
				e.setComment(rs.getString("comment"));
				
				
				fullEmployee.add(e);
			}
			rs.close();
			st.close();
			connectionUtil.close(connection);
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		 
	
		return fullEmployee;
		
	}
	
	//Show  employee group by OFFICE	
	public List<Employee> showEmployeeAtOffice () {
		
		DataBaseConnectionUtil connectionUtil = new DataBaseConnectionUtil();
		Connection connection = connectionUtil.connect();	
		List<Employee> employeeAtOffice = new ArrayList();
		
		String query= "select count(toranjdb.employee.idEmployee) as total, office.name from toranjdb.employee as employee " + 
				"inner join toranjdb.office as office on office.idOffice=employee.idOffice " + 
				"group by (name)";	
		
		try{
			Statement st= connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			
		
			while (rs.next()) {
				Office o = new Office();
				Employee e = new Employee();
				
				e.setIdEmployee(rs.getInt("total"));
				o.setName(rs.getString("name"));
				e.setOffice(o);
				
				employeeAtOffice.add(e);		
				
			}

			rs.close();
			st.close();
			connectionUtil.close(connection);
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		 
		return employeeAtOffice;
		
	}
	
	//Show  employee group by POSITION	
	public List<Employee> showEmployeePosition () {
		
		DataBaseConnectionUtil connectionUtil = new DataBaseConnectionUtil();
		Connection connection = connectionUtil.connect();	
		List<Employee> employeePosition = new ArrayList();
		
		String query= "select count( toranjdb.employee.idEmployee) as total, position.name from toranjdb.employee as employee " + 
				"inner join toranjdb.position as position on position.idPosition=employee.idPosition " + 
				"group by (name)";	
		
		try{
			Statement st= connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			
		
			while (rs.next()) {
				Position p = new Position();
				Employee e = new Employee();
				
				e.setIdEmployee(rs.getInt("total"));
				p.setName(rs.getString("Name"));
				e.setPosition(p);
				
				employeePosition.add(e);		
				
			}

			rs.close();
			st.close();
			connectionUtil.close(connection);
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		 
		return employeePosition;
		
	}
	
	//mostrar total empleados
	public int totalEmployee () {
		
		DataBaseConnectionUtil connectionUtil = new DataBaseConnectionUtil();
		Connection connection = connectionUtil.connect();	
		int totalEmployee=0;
		
		String query= "select count(*) as total from employee";
		
		try{
			Statement st= connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			rs.next();
			totalEmployee= rs.getInt("total");
			
			rs.close();
			st.close();
			connectionUtil.close(connection);
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		 
		return totalEmployee;
		
	}
	
	//total software
	public int totalSoftware () {
	
	DataBaseConnectionUtil connectionUtil = new DataBaseConnectionUtil();
	Connection connection = connectionUtil.connect();	
	
	
	String query= "select sum(idSoftware) as total from software";	
	
	int totalSoftware=0;	
	
	try{
		Statement st= connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		rs.next(); 
		totalSoftware=rs.getInt("total");
		rs.close();
		st.close();
		connectionUtil.close(connection);
		
	}catch(SQLException e) {
		System.out.println(e.getMessage());
	}
	 
	return totalSoftware;
	
}

	//total laptop
	public int totalLaptop () {
	
	DataBaseConnectionUtil connectionUtil = new DataBaseConnectionUtil();
	Connection connection = connectionUtil.connect();	
	
	
	String query= "select sum(idLaptop) as total from laptop";	
	
	int totalLaptop=0;	
	
	try{
		Statement st= connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		 
		rs.next(); 
		totalLaptop=rs.getInt("total");
		
		
		rs.close();
		st.close();
		connectionUtil.close(connection);
		
	}catch(SQLException e) {
		System.out.println(e.getMessage());
	}
	 
	return totalLaptop;
	
}


}
