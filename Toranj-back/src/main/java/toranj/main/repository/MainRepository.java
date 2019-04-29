package toranj.main.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import toranj.common.repository.DataBaseConnectionUtil;
import toranj.registration.domain.Extra;

public class MainRepository {
	
	//show the last 10 employees
	
	public String showEmployee() {
		
		DataBaseConnectionUtil connectionUtil = new DataBaseConnectionUtil();
		Connection connection = connectionUtil.connect();	
		
		
		String query= "Select  employee.name, employee.surname, office.name, position.name, from employee as emplyee" + 
				" 	inner join office as office on office.idofficer=employee.idoffice" + 
				" 	inner join position as position on postition.idposition=employee.idposition" + 
				" 	order by idemployee limit 10";
		String success="";	
		
		try{
			Statement st= connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			if (rs.next() == false) { success="ResultSet in empty in Java";
			} else { 
				do { success= rs.toString(); 
			 } 
			while (rs.next()); }

			
			rs.close();
			st.close();
			connectionUtil.close(connection);
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		 
	
		return success;
		
	}
	
	//Show a selected employee
	
	public String showChosenEmployee (String name, String surname) {
		
		DataBaseConnectionUtil connectionUtil = new DataBaseConnectionUtil();
		Connection connection = connectionUtil.connect();	
		
		
		String query= "Select  employee.name, employee.surname, office.name, position.name, from employee as emplyee" + 
				" 	inner join office as office on office.idofficer=employee.idoffice" + 
				" 	inner join position as position on postition.idposition=employee.idposition" + 
				" 	where employee.name='"+name+"' and surname='"+surname+"'" +
				" 	order by idemployee limit 10";
		
		String success="";	
		
		try{
			Statement st= connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			if (rs.next() == false) { success="ResultSet in empty in Java";
			} else { 
				do { success= rs.toString(); 
			 } 
			while (rs.next()); }

			
			rs.close();
			st.close();
			connectionUtil.close(connection);
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		 
		return success;
		
	}
	//mostrar total empleados
	
public int totalEmployee () {
		
		DataBaseConnectionUtil connectionUtil = new DataBaseConnectionUtil();
		Connection connection = connectionUtil.connect();	
		
		
		String query= "Select  * from employee";
		
		int totalEmployee=0;	
		
		try{
			Statement st= connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			while (rs.next()){
				
				rs.last();
				totalEmployee = rs.getRow();
				rs.beforeFirst();
			}
				
			  
			rs.close();
			st.close();
			connectionUtil.close(connection);
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		 
		return totalEmployee;
		
	}
	
//total sfotware

public int totalSotware () {
	
	DataBaseConnectionUtil connectionUtil = new DataBaseConnectionUtil();
	Connection connection = connectionUtil.connect();	
	
	
	String query= "Select  * from software";
	
	int totalSoftware=0;	
	
	try{
		Statement st= connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		while (rs.next()){
			
			rs.last();
			totalSoftware = rs.getRow();
			rs.beforeFirst();
		}
			
		  
		rs.close();
		st.close();
		connectionUtil.close(connection);
		
	}catch(SQLException e) {
		System.out.println(e.getMessage());
	}
	 
	return totalSoftware;
	
}

}
