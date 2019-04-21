package main.java.toranj.common.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConexionUtil {
	
	String url= "jdbc:mysql://127.0.0.1:3306/toranjdb";
	String user="root";
	String pass= "1234";
	
	
	public Connection connect() {
		System.out.println("Conectando...");
		Connection connection = null;
		try {
			connection=DriverManager.getConnection(url, user, pass);
			System.out.println("Conectado");
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return connection;
	}
	
	public void close(Connection connection) throws SQLException{
		connection.close();
	}
}
