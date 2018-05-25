package pl.winowicz.jdbc;

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

public class LoadTableQuery {

	public ObservableList<Client> loadTable() throws ClassNotFoundException, SQLException, InterruptedException {

		List<Client> list = new ArrayList<>();

		final String driver = "com.mysql.jdbc.Driver";
		Class.forName(driver);

		final String dbPath = "jdbc:mysql://localhost:3306/sys";
		Connection conn = (Connection) DriverManager.getConnection(dbPath, "root", "qwerty123");

		Statement statement = conn.createStatement();
		final String sqlQuery = "SELECT firstName, lastName, description, dateOfSession, typeOfSession, priceOfSession FROM sessions";
		ResultSet resultSet = statement.executeQuery(sqlQuery);

		String firstName = null;
		String lastName = null;
		String description = null;
		String dateOfSession = null;
		String typeOfSession = null;
		String priceOfSession = null;
		while (resultSet.next()) {
			firstName = resultSet.getString("firstName");
			lastName = resultSet.getString("lastName");
			description = resultSet.getString("description");
			dateOfSession = resultSet.getString("dateOfSession");
			typeOfSession = resultSet.getString("typeOfSession");
			priceOfSession = resultSet.getString("priceOfSession");
			list.add(new Client(firstName, lastName, description, dateOfSession, typeOfSession, priceOfSession));
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
}
