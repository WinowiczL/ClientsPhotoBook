//package pl.winowicz.fxmvc.controller;
//
//import java.io.IOException;
//
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Scene;
//import javafx.scene.layout.VBox;
//
//public class ChooseScene {
//
//	private Scene scene;
//	private FXMLLoader loader;
//	private MainController mainController;
//
//	public ChooseScene(Scene scene) {
//		this.scene = scene;
//		setScene();
//		setController();
//	}
//
//	private void setScene() {
//		loader = new FXMLLoader();
//		loader.setLocation(getClass().getResource("/pl/winowicz/fxmvc/view/MainPane.fxml"));
//
//		try {
//			VBox vBox = loader.load();
//			scene.setRoot(vBox);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	private void setController() {
//		mainController = loader.getController();
//		mainController.setScene(scene);
//	}
//
//}
