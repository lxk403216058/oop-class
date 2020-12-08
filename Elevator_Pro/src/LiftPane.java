import java.util.ArrayList;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class LiftPane extends BorderPane {
	private Rectangle rect1 = new Rectangle(250, 100, 150, 250);
	private Rectangle rect2 = new Rectangle(400, 100, 150, 250);
	private Timeline animation;
	private Polygon p1 = new Polygon();
	private Polygon p2 = new Polygon();
	private int flag2 = 0;
	private int flag = 0;
	private int number = 0;
	private int floorn = 1;
	private int people = 0;
	private Text t2 = new Text(170, 200, "" + floorn);
	private Text t3 = new Text(740, 110, "0");

	public LiftPane() {
		rect1.setFill(Color.GREEN);
		rect2.setFill(Color.GREEN);

		p1.getPoints().addAll(new Double[] { 125.0, 125.0, 100.0, 145.0, 115.0, 145.0, 115.0, 175.0, 135.0, 175.0,
				135.0, 145.0, 150.0, 145.0 });
		p1.setStroke(Color.BLACK);
		p2.getPoints().addAll(new Double[] { 115.0, 200.0, 115.0, 230.0, 100.0, 230.0, 125.0, 250.0, 150.0, 230.0,
				135.0, 230.0, 135.0, 200.0 });
		p1.setStroke(Color.BLACK);
		t2.setFont(Font.font("ËÎÌו", FontWeight.BOLD, FontPosture.ITALIC, 50));
		t3.setFont(Font.font("ËÎÌו", FontWeight.BOLD, FontPosture.ITALIC, 50));
		getChildren().add(rect1);
		getChildren().add(rect2);
		getChildren().add(t2);
		getChildren().add(t3);
		getChildren().add(p1);
		getChildren().add(p2);
		animation = new Timeline(new KeyFrame(Duration.millis(5), e -> liftRun()));

		animation.setCycleCount(Timeline.INDEFINITE);
	}

	public void play() {
		animation.play();
	}

	public void pause() {
		animation.pause();
	}

	public int judge() {
		int flag = 0;
		if (rect2.getWidth() == 0) {
			flag = 1;
		}
		return flag;
	}

	public void run1(ArrayList<String> type, ArrayList<Integer> floor, ArrayList<Integer> flag1) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (number != type.size()) {
					if (floorn < floor.get(number)) {
						floorn++;
						Platform.runLater(new Runnable() {
							public void run() {
								t2.setText(floorn + "");
								p1.setFill(Color.GREEN);
								p2.setFill(Color.WHITE);
								p2.setStroke(Color.GREEN);
							}
						});
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else if (floorn > floor.get(number)) {
						floorn--;
						Platform.runLater(new Runnable() {
							public void run() {
								t2.setText(floorn + "");
								p1.setFill(Color.WHITE);
								p1.setStroke(Color.GREEN);
								p2.setFill(Color.GREEN);
							}
						});
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else {
						people += flag1.get(number);
						Platform.runLater(new Runnable() {
							public void run() {
								t3.setText(people + "");
								
							}
						});
						number++;
						flag = 0;
						animation.play();
						try {
							Thread.sleep(1800);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}

				}
			}
		}).start();
	}

	public void run2(ArrayList<String> type, ArrayList<Integer> floor, ArrayList<Integer> flag) {

		new Thread(new Runnable() {
			@Override
			public void run() {

				try {

					if (floorn < floor.get(number)) {

						p1.setFill(Color.GREEN);
					} else if (floorn > floor.get(number)) {
						p2.setFill(Color.GREEN);
					}
					while (floorn != floor.get(number)) {
						if (floorn < floor.get(number)) {
							floorn++;
						} else {
							floorn--;
						}

						t2.setText(floorn + "");

						Thread.sleep(1000);
					}
					p1.setFill(Color.BLACK);
					p2.setFill(Color.BLACK);
					animation.play();
//					flag2 = flag2 + flag1.get(number);
					t3.setText("" + flag2);
					number++;
				} catch (InterruptedException ex) {
				}
			}

		}).start();
	}

	public void liftRun() {

		if (rect1.getWidth() > 0 && flag == 0) {
			rect1.setWidth(rect1.getWidth() - 1);
		}

		if (rect2.getWidth() > 0 && flag == 0) {
			rect2.setX(rect2.getX() + 1);
			rect2.setWidth(rect2.getWidth() - 1);
		}

		if (rect2.getWidth() == 0) {
			flag = 1;
		}

		if (rect1.getWidth() <= 150 && flag == 1) {
			rect1.setWidth(rect1.getWidth() + 1);
		}
		if (rect2.getWidth() <= 150 && flag == 1) {
			rect2.setX(rect2.getX() - 1);
			rect2.setWidth(rect2.getWidth() + 1);
		}

	}

}
