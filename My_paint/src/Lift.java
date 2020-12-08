import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Lift extends Pane {
	 private String text = "";
	 private Rectangle rect1 = new Rectangle(0,0,100,100);
	 private Rectangle rect2 = new Rectangle(100,0,100,100);
	 private Timeline animation;
	 
	 public Lift(){
		 rect1.setFill(Color.GREEN);
		 rect2.setFill(Color.GREEN);
		 getChildren().add(rect1);
		 getChildren().add(rect2);
		 animation = new Timeline(new KeyFrame(Duration.millis(50)));
		 animation.setCycleCount(Timeline.INDEFINITE);
		 animation.play();
	 }
	 
	 public void play(){
		 animation.play();
	 }
	 
	 public void pause(){
		 animation.pause();
	 }
	 
	 public void liftRun(){
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

}
