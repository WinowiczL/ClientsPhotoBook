package pl.winowicz.fxmvc.buttonReactions;

import java.io.FileNotFoundException;
import java.sql.SQLException;

import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import pl.winowicz.data.Client;
import pl.winowicz.jdbc.JdbcMain;

public class LoadTableButtonReaction {

	JdbcMain jdbcMain = new JdbcMain();

	public void loadTable(TableView<Client> tableView, Button loadTableButton)
			throws SQLException, ClassNotFoundException, FileNotFoundException {

		final String sqlSelectAllQuery = ("SELECT id, firstName, lastName, description, dateOfSession, typeOfSession, priceOfSession FROM sessions");
		
		final ObservableList<Client> data = jdbcMain.jdbcSelect(sqlSelectAllQuery);

		tableView.setItems(data);
	}

}
