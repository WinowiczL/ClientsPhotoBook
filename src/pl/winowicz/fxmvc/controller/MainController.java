package pl.winowicz.fxmvc.controller;

import java.net.URL;
import java.sql.SQLException;
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
	private TableView<Client> tableView;

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
		
		TableColumn<Client, String> columnFirstName = new TableColumn("FirstName");
		TableColumn<Client, String> columnLastName = new TableColumn("LastName");
		TableColumn<Client, String> columnDescription = new TableColumn("Description");
		TableColumn<Client, String> columnTypeOfSession = new TableColumn("TypeOfSession");
		TableColumn<Client, String> columnDateOfSession = new TableColumn("DateOfSession");
		TableColumn<Client, String> columnPriceOfSession = new TableColumn("PriceOfSession");
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
				
				try {
					tableView.setItems(jdbc.loadTable());
				} catch (ClassNotFoundException | SQLException | InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

								
			}
		});
		
	}
}