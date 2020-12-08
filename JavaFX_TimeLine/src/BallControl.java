import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.animation.KeyFrame;
import javafx.scene.control.Label;

public class BallControl extends Application {
	@Override
	public void start(Stage primaryStage) {
		BallPane ballPane = new BallPane();
		ballPane.setOnMousePressed(e -> ballPane.pause());
		ballPane.setOnMouseReleased(e -> ballPane.play());
		ballPane.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.UP) {
				ballPane.increaseSpeed();
			} else if (e.getCode() == KeyCode.DOWN) {
				ballPane.decreaseSpeed();
			}
		});
		Scene scene = new Scene(ballPane, 250, 150);
		primaryStage.setTitle("BounceBallControl");
		primaryStage.setScene(scene);
		primaryStage.show();
		ballPane.requestFocus();
	}
	
	public static void main(String[] args){
		Application.launch(args);
	}
}
