package pl.winowicz.fxmvc.buttonReactions;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSetMetaData;

import javafx.scene.control.TextField;

public class SaveSessionButtonReaction {

	public void saveSession(TextField fillId, TextField fillFirstName, TextField fillLastName,
			TextField fillDescription, TextField fillDateOfSession, TextField fillTypeOfSession,
			TextField fillPriceOfSession) throws ClassNotFoundException, SQLException, InterruptedException {

		String id = fillId.getText();
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

		String queryInsert = "INSERT INTO sessions VALUES('" + id + "','" + firstName + "','" + lastName + "','"
				+ description + "','" + dateOfSession + "','" + typeOfSession + "','" + priceOfSession + "');";
		final String sqlQueryInsert = queryInsert;
		statement.executeUpdate(sqlQueryInsert);

		fillId.setText(null);
		fillFirstName.setText(null);
		fillLastName.setText(null);
		fillDescription.setText(null);
		fillDateOfSession.setText(null);
		fillTypeOfSession.setText(null);
		fillPriceOfSession.setText(null);

	}
}
