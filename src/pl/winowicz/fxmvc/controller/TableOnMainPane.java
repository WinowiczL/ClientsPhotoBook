package pl.winowicz.fxmvc.controller;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import pl.winowicz.data.Client;

public class TableOnMainPane {

	public void createTableOnMainPane(TableView<Client> tableView) {

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

	}

}
