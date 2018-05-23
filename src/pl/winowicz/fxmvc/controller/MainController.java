package pl.winowicz.fxmvc.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class MainController implements Initializable {

	@FXML
	private AnchorPane anchorPane;

	@FXML
	private BorderPane borderPane;

	@FXML
	private MenuBar menuBar;

	@FXML
	private Menu menuSessions;

	@FXML
	private MenuItem addClient;

	@FXML
	private MenuItem deleteClient;

	@FXML
	private MenuItem findClient;

	@FXML
	private Menu menuHelp;

	@FXML
	private Menu menuExit;

	@FXML
	private TableView<?> tableView;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}
}
