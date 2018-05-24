package pl.winowicz.fxmvc.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class MainController {

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

}
