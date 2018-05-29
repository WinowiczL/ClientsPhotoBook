package pl.winowicz.fxmvc.buttonReactions;

import java.io.FileNotFoundException;
import java.sql.SQLException;

import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import pl.winowicz.data.Client;
import pl.winowicz.jdbc.JdbcMain;

public class OrderByButtonReaction {

	JdbcMain jdbcMain = new JdbcMain();

	public void orderByReaction(ComboBox<String> orderByComboBox, TableView<Client> tableView)
			throws ClassNotFoundException, SQLException, InterruptedException, FileNotFoundException {

		String value = orderByComboBox.getValue();

		final String sqlOrderQuery = String.format(
				"SELECT id, firstName, lastName, description, dateOfSession, typeOfSession, priceOfSession FROM sessions"
						+ " ORDER BY %s", value);

		ObservableList<Client> data = jdbcMain.jdbcSelect(sqlOrderQuery);

		tableView.setItems(data);

	}
}
