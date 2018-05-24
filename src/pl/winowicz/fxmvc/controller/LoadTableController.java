package pl.winowicz.fxmvc.controller;

import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import pl.winowicz.data.Client;
import pl.winowicz.jdbc.JdbcMain;

public class LoadTableController {

	public void loadTable(TableView<Client> tableView, Button loadTableButton) {

		JdbcMain jdbc = new JdbcMain();
		TableColumn<Client, String> columnFirstName = new TableColumn("FirstName");
		TableColumn<Client, String> columnLastName = new TableColumn("LastName");
		TableColumn<Client, String> columnDescription = new TableColumn("Description");
		TableColumn<Client, String> columnTypeOfSession = new TableColumn("TypeOfSession");
		TableColumn<Client, String> columnDateOfSession = new TableColumn("DateOfSession");
		TableColumn<Client, String> columnPriceOfSession = new TableColumn("PriceOfSession");
		tableView.getColumns().addAll(columnFirstName, columnLastName, columnDescription, columnDateOfSession,
				columnTypeOfSession, columnPriceOfSession);

		columnFirstName.setCellValueFactory(new PropertyValueFactory<Client, String>("firstName"));
		columnLastName.setCellValueFactory(new PropertyValueFactory<Client, String>("lastName"));
		columnDescription.setCellValueFactory(new PropertyValueFactory<Client, String>("description"));
		columnTypeOfSession.setCellValueFactory(new PropertyValueFactory<Client, String>("typeOfSession"));
		columnDateOfSession.setCellValueFactory(new PropertyValueFactory<Client, String>("dateOfSession"));
		columnPriceOfSession.setCellValueFactory(new PropertyValueFactory<Client, String>("priceOfSession"));

		try {
			tableView.setItems(jdbc.loadTable());
		} catch (ClassNotFoundException | SQLException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
