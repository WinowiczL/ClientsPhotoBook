package pl.winowicz.fxmvc.buttonReactions;

import java.awt.Label;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

import javafx.scene.control.TextField;

public class SaveSessionButtonReaction {

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

		fillFirstName.setText(null);
		fillLastName.setText(null);
		fillDescription.setText(null);
		fillDateOfSession.setText(null);
		fillTypeOfSession.setText(null);
		fillPriceOfSession.setText(null);

	}
}
