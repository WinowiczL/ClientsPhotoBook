package pl.winowicz.fxmvc.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class AboutController implements Initializable {

	ChooseScene chooseScene = new ChooseScene();

	@FXML
	private Button backToMainPaneButton;

	@FXML
	private Button StartButton;

	@FXML
	private Button pauseButton;

	@FXML
	private Button stopButton;

	@FXML
	private MediaView mediaView;

	private MediaPlayer mediaPlayer;
	private Media media;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		String path = new File("src/pl/winowicz/fxmvc/media/HowToUse.mp4").getAbsolutePath();
		media = new Media(new File(path).toURI().toString());
		mediaPlayer = new MediaPlayer(media);
		mediaView.setMediaPlayer(mediaPlayer);
		mediaPlayer.setAutoPlay(true);
		DoubleProperty width = mediaView.fitWidthProperty();
		DoubleProperty height = mediaView.fitHeightProperty();
		width.bind(Bindings.selectDouble(mediaView.sceneProperty(), "width"));
		height.bind(Bindings.selectDouble(mediaView.sceneProperty(), "height"));

		backToMainPaneButton.setOnAction(event -> {
			try {
				chooseScene.setSceneMainPane();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
	}

}