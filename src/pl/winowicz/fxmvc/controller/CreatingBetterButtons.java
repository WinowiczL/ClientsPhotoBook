package pl.winowicz.fxmvc.controller;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import pl.winowicz.data.Client;

public class CreatingBetterButtons {

	public void createBetterButtons(TableView<Client> tableView, ComboBox<String> orderByComboBox, ComboBox<String> findComboBox) {
		
		findComboBox.getItems().addAll("firstName", "lastName", "priceOfSession");
		findComboBox.setPromptText("Find By");
		
		orderByComboBox.getItems().addAll("firstName", "lastName", "priceOfSession");
		orderByComboBox.setPromptText("Order By");

		TableColumn<Client, String> columnFirstName = new TableColumn<Client, String>("FirstName");
		TableColumn<Client, String> columnLastName = new TableColumn<Client, String>("LastName");
		TableColumn<Client, String> columnDescription = new TableColumn<Client, String>("Description");
		TableColumn<Client, String> columnTypeOfSession = new TableColumn<Client, String>("TypeOfSession");
		TableColumn<Client, String> columnDateOfSession = new TableColumn<Client, String>("DateOfSession");
		TableColumn<Client, String> columnPriceOfSession = new TableColumn<Client, String>("PriceOfSession");
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
