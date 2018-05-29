package pl.winowicz.jdbc;

import java.io.FileNotFoundException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.winowicz.data.Client;

public class JdbcMain {

	ReadPassword rp = new ReadPassword();

	public static final String driver = "com.mysql.jdbc.Driver";

	public ObservableList<Client> jdbcSelect(String query)
			throws SQLException, ClassNotFoundException, FileNotFoundException {

		String login = rp.readPass().get(0);
		String pass = rp.readPass().get(1);

		List<Client> list = new ArrayList<>();
		final String driver = "com.mysql.jdbc.Driver";
		Class.forName(driver);

		final String dbPath = "jdbc:mysql://localhost:3306/sys";
		Connection conn = (Connection) DriverManager.getConnection(dbPath, login, pass);

		Statement statement = conn.createStatement();
		final String sqlQuery = query;
		ResultSet resultSet = statement.executeQuery(sqlQuery);

		while (resultSet.next()) {
			String firstName = resultSet.getString("firstName");
			String lastName = resultSet.getString("lastName");
			String description = resultSet.getString("description");
			String dateOfSession = resultSet.getString("dateOfSession");
			String typeOfSession = resultSet.getString("typeOfSession");
			String priceOfSession = resultSet.getString("priceOfSession");
			String id = resultSet.getString("id");
			list.add(new Client(id, firstName, lastName, description, dateOfSession, typeOfSession, priceOfSession));
		}

		if (statement != null) {
			statement.close();
		}
		if (resultSet != null) {
			resultSet.close();
		}
		if (conn != null) {
			conn.close();
		}

		final ObservableList<Client> data = FXCollections.observableArrayList(list);

		return data;

	}

	public void jdbcUpdate(String query) throws SQLException, ClassNotFoundException, FileNotFoundException {

		String login = rp.readPass().get(0);
		String pass = rp.readPass().get(1);

		final String driver = "com.mysql.jdbc.Driver";
		Class.forName(driver);

		final String dbPath = "jdbc:mysql://localhost:3306/sys";
		Connection conn = (Connection) DriverManager.getConnection(dbPath, login, pass);

		Statement statement = conn.createStatement();

		final String sqlQueryInsert = query;
		statement.executeUpdate(sqlQueryInsert);

		if (statement != null) {
			statement.close();
		}

		if (conn != null) {
			conn.close();
		}

	}
}
