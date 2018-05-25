package pl.winowicz.fxmvc.controller;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import pl.winowicz.fxmvc.app.Main;

public class ChooseScene {

	public void setSceneMainPane() throws IOException {
		Parent parent = (Parent) FXMLLoader.load(getClass().getResource("/pl/winowicz/fxmvc/view/MainPane.fxml"));
		Scene scene = new Scene(parent);
		Main.window.setScene(scene);
		Main.window.setTitle("Main Page");
		Main.window.show();
	}
	
	public void setSceneAboutPane() throws IOException {
		Parent parent = (Parent) FXMLLoader.load(getClass().getResource("/pl/winowicz/fxmvc/view/AboutPane.fxml"));
		Scene scene = new Scene(parent);
		Main.window.setScene(scene);
		Main.window.setTitle("About Pane");
		Main.window.show();
	}
}