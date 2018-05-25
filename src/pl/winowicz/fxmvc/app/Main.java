package pl.winowicz.fxmvc.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage stage) throws Exception {

		Parent parent1 = (Parent) FXMLLoader.load(getClass().getResource("/pl/winowicz/fxmvc/view/MainPane.fxml"));
		Scene scene1 = new Scene(parent1);
		stage.setScene(scene1);
		stage.setTitle("Main Page");
		stage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
