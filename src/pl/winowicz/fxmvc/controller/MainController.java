package pl.winowicz.fxmvc.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Menu;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import pl.winowicz.data.Client;
import pl.winowicz.fxmvc.app.Main;
import pl.winowicz.fxmvc.buttonReactions.FindSessionButtonReaction;
import pl.winowicz.fxmvc.buttonReactions.LoadTableButtonReaction;
import pl.winowicz.fxmvc.buttonReactions.OrderByButtonReaction;
import pl.winowicz.fxmvc.buttonReactions.SaveSessionButtonReaction;

public class MainController implements Initializable {

	LoadTableButtonReaction loadTableButtonReaction = new LoadTableButtonReaction();
	SaveSessionButtonReaction saveSessionController = new SaveSessionButtonReaction();
	CreatingBetterButtons creatingBetterButtons = new CreatingBetterButtons();
	OrderByButtonReaction orderByButtonReaction = new OrderByButtonReaction();
	FindSessionButtonReaction findSessionButtonReaction = new FindSessionButtonReaction();
	ChooseScene chooseScene = new ChooseScene();
	Main mc = new Main();

	@FXML
	private AnchorPane anchorPane;

	@FXML
	private BorderPane borderPane;

	@FXML
	private Menu menuSessions;

	@FXML
	private Button exitButton;

	@FXML
	private Button aboutButton;

	@FXML
	private TableView<Client> tableView;

	@FXML
	private TitledPane addSessionPane;

	@FXML
	private AnchorPane addSessionAnchorPane;
	
	@FXML
	private TextField fillId;

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

	@FXML
	private ComboBox<String> orderByComboBox;

	@FXML
	private TextField fillValueToFind;

	@FXML
	private ComboBox<String> findComboBox;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		creatingBetterButtons.createBetterButtons(tableView, orderByComboBox, findComboBox);

		exitButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Main.window.close();
			}
		});

		aboutButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					chooseScene.setSceneAboutPane();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		orderByComboBox.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					orderByButtonReaction.orderByReaction(orderByComboBox, tableView);
				} catch (ClassNotFoundException | SQLException | InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		findComboBox.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					findSessionButtonReaction.findSession(findComboBox, tableView, fillValueToFind);
				} catch (ClassNotFoundException | SQLException | InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		loadTableButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					loadTableButtonReaction.loadTable(tableView, loadTableButton);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		saveButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					saveSessionController.saveSession(fillId, fillFirstName, fillLastName, fillDescription, fillDateOfSession,
							fillTypeOfSession, fillPriceOfSession);
					loadTableButtonReaction.loadTable(tableView, loadTableButton);
				} catch (ClassNotFoundException | SQLException | InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

	}
}