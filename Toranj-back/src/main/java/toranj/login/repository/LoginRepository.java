package toranj.login.repository;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import toranj.common.repository.DataBaseConnectionUtil;import toranj.login.domain.User;

public class LoginRepository {
	

	public LoginRepository() {		super();	}	public int findUser(User user) {
		//Make connection to database
		//Make query for select user
		//return id if exists or 0 if doesn't exist
		
		DataBaseConnectionUtil connectionUtil = new DataBaseConnectionUtil();
		Connection connection = connectionUtil.connect();
		
		String query= "SELECT idUser FROM toranjdb.user where username= '"+user.getUserName()+"' and password= '" + user.getPassword() +"'";
		int idUser= 0;
		try{
			Statement st= connection.createStatement();
			ResultSet rs = st.executeQuery(query);			rs.next();
			idUser = rs.getInt("idUser");
			rs.close();
			st.close();
			connectionUtil.close(connection);
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return idUser;
	}		public int setSession(int id, String session) {		int result = 0;				DataBaseConnectionUtil connectionUtil = new DataBaseConnectionUtil();		Connection connection = connectionUtil.connect();				String query= "update toranjdb.user SET session='"+session+"' where idUser= '"+id+"'";				try{			Statement st= connection.createStatement();			result = st.executeUpdate(query);						st.close();			connectionUtil.close(connection);					}catch(SQLException e) {			System.out.println(e.getMessage());		}		return result;	}		public boolean checkSession(User user) {		boolean result = false;				DataBaseConnectionUtil connectionUtil = new DataBaseConnectionUtil();		Connection connection = connectionUtil.connect();				String query= "Select idEmployee from toranjdb.user where session='" + user.getSession() + "' and username='" 		+ user.getUserName() + "' and password='" + user.getPassword() + "' and idUser='" + user.getId() + "'";				try{			Statement st= connection.createStatement();			ResultSet rs = st.executeQuery(query);			if(rs.next()) {				result = true;			}						st.close();			connectionUtil.close(connection);					}catch(SQLException e) {			System.out.println(e.getMessage());		}		return result;	}	}

