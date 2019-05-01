package toranj.login.repository;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import toranj.common.repository.DataBaseConnectionUtil;

public class LoginRepository {
	

	public LoginRepository() {		super();	}	public int findUser(String user, String password) {
		//Make connection to database
		//Make query for select user
		//return key if exists or 0 if doesn't exist
		
		DataBaseConnectionUtil connectionUtil = new DataBaseConnectionUtil();
		Connection connection = connectionUtil.connect();
		
		String query= "SELECT idEmployee FROM toranjdb.user where username= '"+user+"' and password= '" + password +"'";
		int idEmployee= 0;
		try{
			Statement st= connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			idEmployee = rs.getInt("idEmployee");
			
			rs.close();
			st.close();
			connectionUtil.close(connection);
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return idEmployee;
	}	}

