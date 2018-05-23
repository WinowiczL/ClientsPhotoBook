package pl.winowicz.fxmvc.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.winowicz.fxmvc.controller.LoginController;
import pl.winowicz.fxmvc.controller.MainController;

public class Main extends Application {

	LoginController lc = new LoginController();

	@Override
	public void start(Stage stage) throws Exception {

		Parent parent1 = (Parent) FXMLLoader.load(getClass().getResource("/pl/winowicz/fxmvc/view/LoginPane.fxml"));
		Scene scene1 = new Scene(parent1);
		stage.setScene(scene1);
		stage.setTitle("Login Page");
		stage.show();

		if (lc.goodPass) {
			Parent parent2 = (Parent) FXMLLoader.load(getClass().getResource("/pl/winowicz/fxmvc/view/MainPane.fxml"));
			Scene scene2 = new Scene(parent2);
			stage.setScene(scene2);
			stage.setTitle("Your Sessions");
			stage.show();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
