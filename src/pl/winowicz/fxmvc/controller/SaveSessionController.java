package pl.winowicz.fxmvc.controller;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SaveSessionController {

	public void saveSession(TextField fillFirstName, TextField fillLastName, TextField fillDescription,
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
		String query = "INSERT INTO sessions VALUES('" + firstName + "','" + lastName + "','" + description + "','"
				+ dateOfSession + "','" + typeOfSession + "','" + priceOfSession + "');";
		final String sqlQuery = query;
		statement.executeUpdate(sqlQuery);

		if (statement != null) {
			statement.close();
		}

		if (conn != null) {
			conn.close();
		}
	}
}
