package pl.winowicz.fxmvc.buttonReactions;

import java.io.FileNotFoundException;
import java.sql.SQLException;

import javafx.scene.control.TextField;
import pl.winowicz.jdbc.JdbcMain;

public class SaveSessionButtonReaction {
	
	JdbcMain jdbcMain = new JdbcMain();

	public void saveSession(TextField fillId, TextField fillFirstName, TextField fillLastName,
			TextField fillDescription, TextField fillDateOfSession, TextField fillTypeOfSession,
			TextField fillPriceOfSession) throws ClassNotFoundException, SQLException, InterruptedException, FileNotFoundException {

		String id = fillId.getText();
		String firstName = fillFirstName.getText();
		String lastName = fillLastName.getText();
		String description = fillDescription.getText();
		String dateOfSession = fillDateOfSession.getText();
		String typeOfSession = fillTypeOfSession.getText();
		String priceOfSession = fillPriceOfSession.getText();
		
		String queryInsert = "INSERT INTO sessions VALUES('" + id + "','" + firstName + "','" + lastName + "','"
				+ description + "','" + dateOfSession + "','" + typeOfSession + "','" + priceOfSession + "');";

		jdbcMain.jdbcUpdate(queryInsert);

		fillId.setText(null);
		fillFirstName.setText(null);
		fillLastName.setText(null);
		fillDescription.setText(null);
		fillDateOfSession.setText(null);
		fillTypeOfSession.setText(null);
		fillPriceOfSession.setText(null);

	}
}
