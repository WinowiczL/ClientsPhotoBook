package pl.winowicz.fxmvc.controller;

import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import pl.winowicz.data.Client;
import pl.winowicz.jdbc.LoadTableQuery;

public class LoadTableController {

	public void loadTable(TableView<Client> tableView, Button loadTableButton) {
		
		LoadTableQuery jdbc = new LoadTableQuery();

		try {
			tableView.setItems(jdbc.loadTable());
		} catch (ClassNotFoundException | SQLException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
