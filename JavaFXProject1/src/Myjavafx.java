

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.shape.*;
import javafx.scene.Scene;

public class Myjavafx extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		Circle circle = new Circle(100,100,25);
		Ellipse ellipse = new Ellipse(180,100,25,20);
		Rectangle rect = new Rectangle(260,75,50,50);
		
		HBox hBox = new HBox(4);
		BorderPane borderPane = new BorderPane();
		
		hBox.setAlignment(Pos.CENTER);
		
		Button btCircle = new Button("Circle");
		Button btRectangle = new Button("Rectangle");
		Button btEllipse = new Button("Ellipse");
		Button btClear = new Button("Clear");
		
		hBox.getChildren().add(btCircle);
		hBox.getChildren().add(btEllipse);
		hBox.getChildren().add(btRectangle);
		hBox.getChildren().add(btClear);
		
		btCircle.setOnAction(e->{
		circle.setFill(Color.GREEN);
		if (!borderPane.getChildren().contains(circle))
		borderPane.getChildren().add(circle);
		});
		
		btEllipse.setOnAction(e->{
		ellipse.setFill(Color.BLUE);
		if (!borderPane.getChildren().contains(ellipse))
		borderPane.getChildren().add(ellipse);
		});
		
		btRectangle.setOnAction(e->{
		rect.setFill(Color.RED);
		if (!borderPane.getChildren().contains(rect))
		borderPane.getChildren().add(rect);
		});
		
		btClear.setOnAction(e->{
			borderPane.getChildren().remove(circle);
			borderPane.getChildren().remove(rect);
			borderPane.getChildren().remove(ellipse);
		});
		
		borderPane.setBottom(hBox);
		Scene scene = new Scene(borderPane,400,300);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args){
		launch(args);
	}
}

