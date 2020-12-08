

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class FlashText extends Application {
  private String text = "";
  Rectangle rect1 = new Rectangle(0,0,100,100);
  Rectangle rect2 = new Rectangle(100,0,100,100);
  
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {   
    Pane pane = new Pane();
    Label lblText = new Label("Programming is fun");
    rect1.setStroke(Color.BLACK);
    rect1.setFill(Color.RED);
    rect2.setStroke(Color.BLUE);
    rect2.setFill(Color.BLACK);
    
    pane.getChildren().add(rect1);
    pane.getChildren().add(rect2);
    
    new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          while (true) {
            if (rect1.getWidth() > 0){
            	rect1.setWidth(rect1.getWidth() - 1);
            }
            if (rect2.getWidth() > 0){
            	rect2.setX(rect2.getX() + 1);
            	rect2.setWidth(rect2.getWidth() - 1);
            }
            
            Thread.sleep(200);
          }
        }
        catch (InterruptedException ex) {
        }
      }
    }).start();
    
    // Create a scene and place it in the stage
    Scene scene = new Scene(pane, 200, 200);
    primaryStage.setTitle("FlashText"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
  }

  public static void main(String[] args) {
    launch(args);
  }
}
