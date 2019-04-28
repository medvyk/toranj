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
	
	public String newEmployee(int idEmployee, String name, String surname, Office office,
			Position position, Extra extra, Software software) {
		
		DataBaseConnectionUtil connectionUtil = new DataBaseConnectionUtil();
		Connection connection = connectionUtil.connect();	
		
		//PONER QUERY
		String query= "";
		
		try{
			Statement st= connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			//idEmployee = rs.getInt("idEmployee"); CAMBIAR LO QUE COJO DEL RESULTADO
			
			rs.close();
			st.close();
			connectionUtil.close(connection);
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		 
		//CAMBIAR EL RETURN STATEMENT
		return query;
		
	}

}
