package toranj.registration.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.text.Position;

import toranj.common.repository.DataBaseConnectionUtil;
import toranj.registration.domain.Extra;
import toranj.registration.domain.Office;
import toranj.registration.domain.Software;

public class RegistrationRepository {
	
	public String newEmployee( String name, String surname, Office office,
			Position position) {
		
		DataBaseConnectionUtil connectionUtil = new DataBaseConnectionUtil();
		Connection connection = connectionUtil.connect();	
		
		//Problema_ necesito incorporar el id_office
		
		String query= "BEGING; INSERT INTO position(idposition, name) VALUES('','"+position.name+"');"
				+ "INSERT INTO employee(idemployee, name, surname, idoffice, idposition, idextra, idsoftware) VALUES ('','"+name+"','"+surname+"', '', LAST_INSERT_ID(),'','' )";
		
		String success= "";
		
		try{
			Statement st= connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			
			if (rs.next() == false) { System.out.println("ResultSet in empty in Java"); } 
			else { 
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
	//EXTRA

	public String addExtra(Extra extra) {
		
		DataBaseConnectionUtil connectionUtil = new DataBaseConnectionUtil();
		Connection connection = connectionUtil.connect();	
		
		
		String query= "BEGING; INSERT INTO extra(idextra, name) VALUES('','"+extra.name+ "')";
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
	
//SOFTWARE

	public String addSoftware(Software software) {
		
		DataBaseConnectionUtil connectionUtil = new DataBaseConnectionUtil();
		Connection connection = connectionUtil.connect();	
		
		
		String query1= "update software set stock = stock - 1 where idsoftware='"+software.name+"'";
		String query2= "select stock from software where name='"+software.name+"'";
		String success;
		
		try{
			Statement st= connection.createStatement();
			
			st.addBatch(query1);
			st.addBatch(query2);
			
			ResultSet rs = st.executeQuery("select * from emp");
			 
			st.executeBatch();
			
			success=rs.getString("stock");
			
			
			rs.close();
			st.close();
			
			
			connectionUtil.close(connection);
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		 
	
		return success;
	}

}

