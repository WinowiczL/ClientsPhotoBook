package pl.winowicz.fxmvc.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class LoginController implements Initializable {

	ChooseScene chooseScene = new ChooseScene();

	@FXML
	private AnchorPane loginAnchorPane;

	@FXML
	private Button selectButton;

	@FXML
	private Label passLabel;

	@FXML
	private PasswordField passField;

	@FXML
	private ImageView imageView;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		selectButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (passField.getText().equals("library")) {
					try {
						chooseScene.setSceneMainPane();
					} catch (IOException e) {
						e.printStackTrace();
					}

				}
			}
		});

	}
}
