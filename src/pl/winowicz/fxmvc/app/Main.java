package pl.winowicz.fxmvc.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	
	public static Stage window;
	
	@Override
	public void start(Stage stage) throws Exception {
		window = stage;
		Parent parent1 = (Parent) FXMLLoader.load(getClass().getResource("/pl/winowicz/fxmvc/view/LoginPane.fxml"));
		Scene scene1 = new Scene(parent1);
		stage.setScene(scene1);
		stage.setTitle("Login Page");
		stage.show();		
		
		// add

	}

	public static void main(String[] args) {
		launch(args);
	}
}
