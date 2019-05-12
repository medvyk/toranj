package toranj.registration.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import toranj.registration.domain.Position;
import toranj.common.repository.DataBaseConnectionUtil;
import toranj.registration.domain.Employee;
import toranj.registration.domain.Extra;
import toranj.registration.domain.Laptop;
import toranj.registration.domain.Office;
import toranj.registration.domain.Order;
import toranj.registration.domain.Software;

public class RegistrationRepository {

	//ADD EMPLOYEE
	public boolean addEmployee(Employee employee) {

		DataBaseConnectionUtil connectionUtil = new DataBaseConnectionUtil();
		Connection connection = connectionUtil.connect();

		Date date = new Date(employee.getArrivalDate().getTime());
		String query = "INSERT INTO toranjdb.employee(name, surname, idoffice, idposition, idsoftware, dateArrival, comment, idLaptop, idExtra) "
				+ " VALUES ('" + employee.getName() + "','" + employee.getSurname() + "', '"
				+ employee.getOffice().getIdOffice() + "'," + " '" + employee.getPosition().getIdPosition() + "','"
				+ employee.getSoftware().getIdSoftware() + "'," + " '" + date + "', '"
				+ employee.getComment() + "','"+employee.getLaptop().getIdLaptop() + "', '"+employee.getExtra().getIdExtra()+"')";

		boolean success = true;

		try {
			Statement st = connection.createStatement();
			int result = st.executeUpdate(query);
			if(result != 1) {
				success = false;
			}

			st.close();
			connectionUtil.close(connection);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			success = false;
		}

		return success;

	}

	//SHOW  OFFICE
	public List<Office> getOffices() {

		DataBaseConnectionUtil connectionUtil = new DataBaseConnectionUtil();
		Connection connection = connectionUtil.connect();
		List<Office> offices = new ArrayList<>();

		String query = "SELECT * from toranjdb.office";

		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				Office o = new Office();
				o.setIdOffice(rs.getInt("idOffice"));
				o.setName(rs.getString("name"));
				offices.add(o);
			}

			rs.close();
			st.close();
			connectionUtil.close(connection);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return offices;

	}

	// SHOW Position
	public List<Position> getPosition() {

		DataBaseConnectionUtil connectionUtil = new DataBaseConnectionUtil();
		Connection connection = connectionUtil.connect();
		List<Position> positions = new ArrayList<>();

		String query = "SELECT * from toranjdb.position";

		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				Position p = new Position();
				p.setIdPosition(rs.getInt("idPosition"));
				p.setName(rs.getString("name"));
				positions.add(p);
			}

			rs.close();
			st.close();
			connectionUtil.close(connection);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return positions;

	}

	//SHOW  SOTWARE
	public List<Software> getSoftware() {

		DataBaseConnectionUtil connectionUtil = new DataBaseConnectionUtil();
		Connection connection = connectionUtil.connect();
		List<Software> softwares = new ArrayList<>();

		String query = "SELECT * from toranjdb.software";

		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				Software s = new Software();
				s.setIdSoftware(rs.getInt("idSoftware"));
				s.setName(rs.getString("Name"));
				s.setPrice(rs.getInt("Price"));
				softwares.add(s);
			}

			rs.close();
			st.close();
			connectionUtil.close(connection);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return softwares;

	}

	//SHOW  Employee
	public List<Employee> getEmployee() {

			DataBaseConnectionUtil connectionUtil = new DataBaseConnectionUtil();
			Connection connection = connectionUtil.connect();
			List<Employee> employees = new ArrayList<>();

			String query = "SELECT * from toranjdb.employee";

			try {
				Statement st = connection.createStatement();
				ResultSet rs = st.executeQuery(query);

				while (rs.next()) {
					Employee e = new Employee();
					e.setIdEmployee(rs.getInt("idEmployee"));
					e.setName(rs.getString("name"));
					e.setSurname(rs.getString("surname"));
					employees.add(e);
				}

				rs.close();
				st.close();
				connectionUtil.close(connection);

			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

			return employees;

		}

	//SHOW  Laptop
	public List<Laptop> getLaptop() {

			DataBaseConnectionUtil connectionUtil = new DataBaseConnectionUtil();
			Connection connection = connectionUtil.connect();
			List<Laptop> laptops = new ArrayList<>();

			String query = "SELECT * from toranjdb.laptop";

			try {
				Statement st = connection.createStatement();
				ResultSet rs = st.executeQuery(query);

				while (rs.next()) {
					Laptop l = new Laptop();
					l.setIdLaptop(rs.getInt("idLaptop"));
					l.setName(rs.getString("name"));
					l.setPrice(rs.getInt("price"));
					laptops.add(l);
				}

				rs.close();
				st.close();
				connectionUtil.close(connection);

			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

			return laptops;

		}

	//SHOW  Extra
	public List<Extra> getExtra() {

				DataBaseConnectionUtil connectionUtil = new DataBaseConnectionUtil();
				Connection connection = connectionUtil.connect();
				List<Extra> extras = new ArrayList<>();

				String query = "SELECT * from toranjdb.extra";

				try {
					Statement st = connection.createStatement();
					ResultSet rs = st.executeQuery(query);

					while (rs.next()) {
						Extra x = new Extra();
						x.setIdExtra(rs.getInt("idExtra"));
						x.setName(rs.getString("Name"));
						x.setMoney(rs.getInt("Money"));
						extras.add(x);
					}

					rs.close();
					st.close();
					connectionUtil.close(connection);

				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}

				return extras;

			}

	
	// GET AN Order
	public boolean placeOrder(Order order) {

		DataBaseConnectionUtil connectionUtil = new DataBaseConnectionUtil();
		Connection connection = connectionUtil.connect();

		// String queryTemp = "UPDATE table SET field = field - 1 WHERE id = '" + "' and
		// field > 0";
		String updateSoftware = "update toranjdb.software set stock = stock - 1 where idSoftware='"
				+ order.getIdSoftware() + "' and stock>0";
		String updateLaptop = "update toranjdb.laptop SET stock = stock-1 where idLaptop = '" + order.getIdLaptop()
				+ "' and stock>0";
		String updateEmployee = "update toranjdb.employee SET idSoftware = '" + order.getIdSoftware() + "'"
				+ " , idLaptop = '" + order.getIdLaptop() + "', idExtra='" + order.getIdExtra() + "'"
				+ " where idEmployee = '" + order.getIdEmployee() + "'";
		// String query2= "select stock from software where
		// name='"+software.getName()+"'";
		boolean success = false;

		try {
			Statement st = connection.createStatement();

			st.addBatch(updateSoftware);
			st.addBatch(updateLaptop);
			st.addBatch(updateEmployee);

			// ResultSet rs = st.;

			st.executeBatch();

			// success=rs.getString("stock");

			success = true;
			// rs.close();
			st.close();

			connectionUtil.close(connection);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return success;
	}

}
