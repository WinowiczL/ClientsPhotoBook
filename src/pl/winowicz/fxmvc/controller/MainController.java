package pl.winowicz.fxmvc.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import pl.winowicz.data.Client;
import pl.winowicz.jdbc.JdbcMain;

public class MainController implements Initializable {

	JdbcMain jdbc = new JdbcMain();

	@FXML
	private AnchorPane anchorPane;

	@FXML
	private BorderPane borderPane;

	@FXML
	private MenuBar menuBar;

	@FXML
	private Menu menuSessions;

	@FXML
	private Menu menuHelp;

	@FXML
	private Menu menuExit;

	@FXML
	private TableView<?> tableView;

	@FXML
	private TableColumn<?, ?> columnFirstName;

	@FXML
	private TableColumn<?, ?> columnLastName;

	@FXML
	private TableColumn<?, ?> columnDescription;

	@FXML
	private TableColumn<?, ?> columnTypeOfSession;

	@FXML
	private TableColumn<?, ?> columnDateOfSession;

	@FXML
	private TableColumn<?, ?> columnPriceOfSession;

	@FXML
	private TitledPane addSessionPane;

	@FXML
	private AnchorPane addSessionAnchorPane;

	@FXML
	private TextField fillFirstName;

	@FXML
	private TextField fillLastName;

	@FXML
	private TextField fillTypeOfSession;

	@FXML
	private TextArea fillDescription;

	@FXML
	private DatePicker fillDateOfSession;

	@FXML
	private TextField fillPriceOfSession;

	@FXML
	private Button saveButton;

	@FXML
	private Button loadTableButton;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		TableColumn columnFirstName = new TableColumn("FirstName");
		TableColumn columnLastName = new TableColumn("LastName");
		TableColumn columnDescription = new TableColumn("Description");
		TableColumn columnTypeOfSession = new TableColumn("TypeOfSession");
		TableColumn columnDateOfSession = new TableColumn("DateOfSession");
		TableColumn columnPriceOfSession = new TableColumn("PriceOfSession");
		tableView.getColumns().addAll(columnFirstName, columnLastName, columnDescription,
				columnDateOfSession, columnTypeOfSession, columnPriceOfSession);
		
		
		loadTableButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				columnFirstName.setCellValueFactory(new PropertyValueFactory<Client,String>("firstName"));
				columnLastName.setCellValueFactory(new PropertyValueFactory<Client,String>("lastName"));
				columnDescription.setCellValueFactory(new PropertyValueFactory<Client,String>("description"));
				columnTypeOfSession.setCellValueFactory(new PropertyValueFactory<Client,String>("typeOfSession"));
				columnDateOfSession.setCellValueFactory(new PropertyValueFactory<Client,String>("dateOfSession"));
				columnPriceOfSession.setCellValueFactory(new PropertyValueFactory<Client,String>("priceOfSession"));
				
				tableView.setItems(jdbc.firstNameQuery());
				
			}
		});
	}
}