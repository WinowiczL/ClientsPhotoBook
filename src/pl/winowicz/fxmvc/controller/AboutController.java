package pl.winowicz.fxmvc.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class AboutController implements Initializable {
	
	ChooseScene chooseScene = new ChooseScene();

	@FXML
	private Button backToMainPaneButton;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		backToMainPaneButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					chooseScene.setSceneMainPane();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
	}

}