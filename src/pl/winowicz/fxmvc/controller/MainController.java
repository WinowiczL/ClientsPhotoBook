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
import pl.winowicz.jdbc.LoadTableQuery;

public class MainController implements Initializable {

	LoadTableQuery jdbc = new LoadTableQuery();
	LoadTableController loadTableController = new LoadTableController();
	SaveSessionController saveSessionController = new SaveSessionController();
	TableOnMainPane tableOnMainPane = new TableOnMainPane();

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
	private TextField fillDescription;

	@FXML
	private TextField fillDateOfSession;

	@FXML
	private TextField fillPriceOfSession;

	@FXML
	private Button saveButton;

	@FXML
	private Button loadTableButton;

	@FXML
	private Button findSessionButton;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		tableOnMainPane.createTableOnMainPane(tableView);

		loadTableButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				loadTableController.loadTable(tableView, loadTableButton);
			}
		});

		saveButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					saveSessionController.saveSession(fillFirstName, fillLastName, fillDescription, fillDateOfSession,
							fillTypeOfSession, fillPriceOfSession);
				} catch (ClassNotFoundException | SQLException | InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

	}
}