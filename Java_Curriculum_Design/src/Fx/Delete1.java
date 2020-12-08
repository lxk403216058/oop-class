package Fx;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

//删除报名活动界面
public class Delete1 extends GridPane {
	private FileOut fo = new FileOut();
	private FileIn fi = new FileIn();

	public Delete1(Stage primaryStage, Scene s) {
		set(primaryStage, s);
	}

	public void set(Stage primaryStage, Scene scene1) {
		this.setAlignment(Pos.CENTER);
		this.setPadding(new Insets(20, 12.5, 13.5, 14.5));
		this.setHgap(5);
		this.setVgap(15);

		this.add(new Label("按活动名称查询："), 0, 0);
		TextField tf1 = new TextField();
		this.add(tf1, 1, 0);

		Button b1 = new Button("确定");
		Button b2 = new Button("返回");
		Button b3 = new Button("删除");

		this.add(b1, 1, 1);
		this.add(b2, 0, 1);
		this.add(b3, 2, 1);

		this.setStyle("-fx-background-color:AQUAMARINE");

		fo.dataIn("ActivityMessage.txt");
		ArrayList<String> name = new ArrayList<>();
		for (int i = 0; i < fo.getExpression().size(); i++) {
			String[] s = fo.getExpression().get(i).split(" ");
			name.add(s[0]);
		}

		// 确定按钮
		b1.setOnAction(e -> {
			int flag1 = 0;
			int j = 0;

			for (int i = 0; i < name.size(); i++) {
				if (name.get(i).equals(tf1.getText())) {
					flag1 = 1;
					j = i;
					break;
				}

			}

			if (flag1 == 1) {
				String[] s = fo.getExpression().get(j).split(" ");

				this.add(new Label("截止时间："), 0, 3);
				this.add(new Label("人数上限："), 0, 4);
				this.add(new Label("已报人数："), 0, 5);

				TextField t1 = new TextField(s[1]);
				TextField t2 = new TextField(s[2]);
				TextField t3 = new TextField(s[3]);
				// setConstraints(TextField.);

				this.add(t1, 1, 3);
				this.add(t2, 1, 4);
				this.add(t3, 1, 5);
			} else {
				Alert alert = new Alert(AlertType.WARNING, "此活动信息不存在！");
				alert.show();
			}
		});

		// 返回按钮
		b2.setOnAction(e -> {
			primaryStage.setTitle("通用报名系统");
			primaryStage.setScene(scene1);
			primaryStage.show();
		});

		// 删除按钮
		b3.setOnAction(e -> {
			int flag1 = 0;
			int j = 0;

			for (int i = 0; i < name.size(); i++) {
				if (name.get(i).equals(tf1.getText())) {
					flag1 = 1;
					j = i;
					break;
				}

			}

			fo.getExpression().remove(j);
			fi.fileIN(fo.getExpression(), "ActivityMessage.txt");

			// 删除成功按钮
			Alert alert = new Alert(AlertType.INFORMATION, "删除成功！");
			alert.show();

		});

	}

}
