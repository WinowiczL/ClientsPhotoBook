package pl.winowicz.fxmvc.controller;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

import javafx.scene.control.TextField;

public class FindSessionController {

	public void findSession(TextField fillFirstName, TextField fillLastName, TextField fillDescription,
			TextField fillDateOfSession, TextField fillTypeOfSession, TextField fillPriceOfSession)
			throws ClassNotFoundException, SQLException, InterruptedException {

		String firstName = fillFirstName.getText();
		String lastName = fillLastName.getText();
		String description = fillDescription.getText();
		String dateOfSession = fillDateOfSession.getText();
		String typeOfSession = fillTypeOfSession.getText();
		String priceOfSession = fillPriceOfSession.getText();

		final String driver = "com.mysql.jdbc.Driver";
		Class.forName(driver);

		final String dbPath = "jdbc:mysql://localhost:3306/sys";
		Connection conn = (Connection) DriverManager.getConnection(dbPath, "root", "qwerty123");

		Statement statement = conn.createStatement();
		final String sqlQuery = "SELECT firstName, lastName, description, dateOfSession, typeOfSession, priceOfSession FROM sessions";
		ResultSet resultSet = statement.executeQuery(sqlQuery);

		if (statement != null) {
			statement.close();
		}
		if (resultSet != null) {
			resultSet.close();
		}
		if (conn != null) {
			conn.close();
		}

	}

}
