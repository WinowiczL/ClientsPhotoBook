package pl.winowicz.fxmvc.buttonReactions;

import java.io.FileNotFoundException;
import java.sql.SQLException;

import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import pl.winowicz.data.Client;
import pl.winowicz.jdbc.JdbcMain;

public class FindSessionButtonReaction {
	
	JdbcMain jdbcMain = new JdbcMain();
	
	String category;
	String value;
	
	

	public void findSession(ComboBox<String> findComboBox, TableView<Client> tableView, TextField fillValueToFind)
			throws ClassNotFoundException, SQLException, FileNotFoundException {

		String category = findComboBox.getValue();
		String value = fillValueToFind.getText();
		
		final String sqlFindQuery = String.format("SELECT id, firstName, lastName, description, dateOfSession, typeOfSession, priceOfSession FROM sessions"
				+ " WHERE %s = '%s';", category, value);	

		ObservableList<Client> data = jdbcMain.jdbcSelect(sqlFindQuery);

		tableView.setItems(data);
		
		fillValueToFind.setText(null);

	}
}
