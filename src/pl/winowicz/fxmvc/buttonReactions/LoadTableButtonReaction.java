package pl.winowicz.fxmvc.buttonReactions;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import pl.winowicz.data.Client;

public class LoadTableButtonReaction {

	public void loadTable(TableView<Client> tableView, Button loadTableButton)
			throws SQLException, ClassNotFoundException {
		
		List<Client> list = new ArrayList<>();

		final String driver = "com.mysql.jdbc.Driver";
		Class.forName(driver);

		final String dbPath = "jdbc:mysql://localhost:3306/sys";
		Connection conn = (Connection) DriverManager.getConnection(dbPath, "root", "qwerty123");

		Statement statement = conn.createStatement();
		final String sqlQuery = "SELECT id, firstName, lastName, description, dateOfSession, typeOfSession, priceOfSession FROM sessions";
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

		
		tableView.setItems(data);
		}

	}


