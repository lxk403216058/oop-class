import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.text.*;

import java.util.ArrayList;

import javafx.animation.KeyFrame;
import javafx.beans.property.DoubleProperty;
import javafx.collections.ObservableList;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Dianti extends BorderPane {
	private int width = 160;
	private int height = 300;
	private int x1 = 240, y1 = 200;
	private int x2 = 560, y2 = 500;
	private Rectangle rec1 = new Rectangle(x1, y1, width, y1 + height);
	private Rectangle rec2 = new Rectangle(x2 - width, y2 - height, width, y2);
	private Rectangle rec = new Rectangle(240, 200, 320, 500);
	private Polygon polygon1 = new Polygon();
	private Polygon polygon2 = new Polygon();
	private double[] str1 = { 0, 70, 50, 20, 100, 70, 75, 70, 75, 170, 25, 170, 25, 70 };
	private double[] str2 = { 0, 290, 25, 290, 25, 190, 75, 190, 75, 290, 100, 290, 50, 340 };

	private int flor = 1;
	private Text text1 = new Text(560, 100, "当前电梯人数：");
	private Text number = new Text(700, 100, "0");
	private Text floor = new Text(380, 130, flor + "");
	int flag = 1;
	int times = 0;
	int num = 0;
	ObservableList<Double> list1 = polygon1.getPoints();
	ObservableList<Double> list2 = polygon2.getPoints();
	int index = 0;

	private Timeline animation;
	private Timeline animation1;
	private Timeline animation2;

	public Dianti() {
		rec1.setFill(Color.GRAY);
		rec1.setStroke(Color.BLACK);
		rec2.setFill(Color.GRAY);
		rec2.setStroke(Color.BLACK);
		rec.setFill(Color.WHITE);
		rec.setStroke(Color.BLACK);

		number.setFont(Font.font(35));
		floor.setFont(Font.font(50));
		for (int i = 0; i < str1.length; i++) {
			list1.add(str1[i]);
		}
		polygon1.setFill(Color.WHITE);
		polygon1.setStroke(Color.BLACK);

		for (int i = 0; i < str2.length; i++) {
			list2.add(str2[i]);
		}
		polygon2.setFill(Color.WHITE);
		polygon2.setStroke(Color.BLACK);

		getChildren().add(rec);
		getChildren().add(rec1);
		getChildren().add(rec2);
		getChildren().add(text1);
		getChildren().add(number);
		getChildren().add(floor);
		getChildren().add(polygon1);
		getChildren().add(polygon2);

		animation = new Timeline(new KeyFrame(Duration.millis(10), e -> open()));
		animation.setCycleCount(Timeline.INDEFINITE);

		animation1 = new Timeline(new KeyFrame(Duration.millis(10), e -> setpolygon(polygon1)));
		animation1.setCycleCount(Timeline.INDEFINITE);

		animation2 = new Timeline(new KeyFrame(Duration.millis(10), e -> setpolygon(polygon2)));
		animation2.setCycleCount(Timeline.INDEFINITE);
	}

	public void cnum(int str) {
		number.setText("" + str);
	}

	public void cfloor(int str) {
		floor.setText("" + str);
	}

	public void play() {
		animation.play();
	}

	public void pause() {
		animation.pause();
	}

	protected void open() {

		if (flag == 1 && width > 0) {
			width -= 1;
			if (width == 0) {
				flag = 0;
			}
		}
		if (flag == 0 && width < 160) {
			width += 1;
		}

		rec1.setWidth(width);
		rec2.setX(x2 - width);
		rec2.setWidth(width);
	}

	public void setpolygon(Polygon polygon) {
		if (polygon.getFill() == Color.WHITE) {
			polygon.setFill(Color.RED);
		} else if (polygon.getFill() == Color.RED) {
			polygon.setFill(Color.WHITE);
		}
	}

	public void run1(ArrayList<String> liftcommand) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (index != liftcommand.size()) {

					if (flor < Integer.valueOf(liftcommand.get(index + 1))) {
						flor++;
						Platform.runLater(new Runnable() {
							@Override
							public void run() {
								floor.setText(flor + "");
								animation1.play();
								animation2.pause();
							}
						});
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else if (flor > Integer.valueOf(liftcommand.get(index + 1))) {
						flor--;
						Platform.runLater(new Runnable() {
							@Override
							public void run() {
								floor.setText(flor + "");
								animation1.pause();
								animation2.play();
							}
						});
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
						Platform.runLater(new Runnable() {
							public void run() {
								animation1.pause();
								animation2.pause();
								polygon1.setFill(Color.WHITE);
								polygon2.setFill(Color.WHITE);
							}
						});
						flag = 1;
						play();
						try {
							Thread.sleep(4500);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					index += 3;
				}
			}
		}).start();
		
	}
}
