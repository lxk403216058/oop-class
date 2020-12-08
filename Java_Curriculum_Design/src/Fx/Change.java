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

//更改普通用户信息界面
public class Change extends GridPane {
	private FileIn fi = new FileIn();
	private FileOut fo = new FileOut();
	private String information = "";

	public Change(Stage primaryStage, Scene s) {
		set(primaryStage, s);
	}

	public void set(Stage primaryStage, Scene scene1) {
		this.setAlignment(Pos.CENTER);
		this.setPadding(new Insets(20, 12.5, 13.5, 14.5));
		this.setHgap(5);
		this.setVgap(15);

		this.add(new Label("按姓名查询："), 0, 0);
		TextField tf1 = new TextField();
		this.add(tf1, 1, 0);

		this.add(new Label("按账号查询："), 0, 1);
		TextField tf2 = new TextField();
		this.add(tf2, 1, 1);

		Button b1 = new Button("查询");
		Button b2 = new Button("返回");
		Button b3 = new Button("更改");

		this.add(b1, 1, 2);
		this.add(b2, 0, 2);
		this.add(b3, 2, 2);

		this.setStyle("-fx-background-color:AQUAMARINE");

		fo.dataIn("SimpleUserInformation.txt");

		ArrayList<String> name = new ArrayList<>();
		ArrayList<String> account = new ArrayList<>();
		for (int i = 0; i < fo.getExpression().size(); i++) {
			String[] s = fo.getExpression().get(i).split(" ");
			name.add(s[2]);
			account.add(s[0]);
		}

		this.add(new Label("账号："), 0, 3);
		this.add(new Label("密码："), 0, 4);
		this.add(new Label("姓名："), 0, 5);
		this.add(new Label("性别："), 0, 6);
		this.add(new Label("年龄："), 0, 7);// 6
		this.add(new Label("身份证号："), 0, 8);// 4
		this.add(new Label("出生日期："), 0, 9);// 5
		this.add(new Label("活动信息："), 0, 10);

		TextField t1 = new TextField();
		TextField t2 = new TextField();
		TextField t3 = new TextField();
		TextField t4 = new TextField();
		TextField t5 = new TextField();// 6
		TextField t6 = new TextField();// 4
		TextField t7 = new TextField();// 5
		TextField t8 = new TextField();

		this.add(t1, 1, 3);
		this.add(t2, 1, 4);
		this.add(t3, 1, 5);
		this.add(t4, 1, 6);
		this.add(t5, 1, 7);
		this.add(t6, 1, 8);
		this.add(t7, 1, 9);
		this.add(t8, 1, 10);
		
		//查询按钮
		b1.setOnAction(e -> {

			int flag1 = 0;
			int flag2 = 0;
			int j = 0;

			for (int i = 0; i < name.size(); i++) {
				if (name.get(i).equals(tf1.getText())) {
					flag1 = 1;
					j = i;
					break;
				}

				if (account.get(i).equals(tf2.getText())) {
					flag2 = 1;
					j = i;
					break;
				}
			}

			if (flag1 == 1 || flag2 == 1) {
				String[] s = fo.getExpression().get(j).split(" ");

				t1.setText(s[0]);
				t2.setText(s[1]);
				t3.setText(s[2]);
				t4.setText(s[3]);
				t5.setText(s[6]);
				t6.setText(s[4]);
				t7.setText(s[5]);
				t8.setText(s[7]);

			} else {
				Alert alert = new Alert(AlertType.WARNING, "此用户不存在或未报名");
				alert.show();
			}
		});
		
		//更改按钮
		b3.setOnAction(e -> {
			int flag1 = 0;
			int flag2 = 0;

			int j = 0;

			for (int i = 0; i < name.size(); i++) {
				if (name.get(i).equals(tf1.getText())) {
					flag1 = 1;
					j = i;
					break;
				}

				if (account.get(i).equals(tf2.getText())) {
					flag2 = 1;
					j = i;
					break;
				}
			}

			information = t1.getText() + " " + t2.getText() + " " + t3.getText() + " " + t4.getText() + " "
					+ t6.getText() + " " + t7.getText() + " " + t5.getText() + " " + t8.getText();

			if (flag1 == 1 || flag2 == 1) {
				fo.getExpression().remove(j);
				fo.getExpression().add(information);
				fi.fileIN(fo.getExpression(), "SimpleUserInformation.txt");
			}

			Alert alert = new Alert(AlertType.INFORMATION, "更改成功！");
			alert.show();
		});

		b2.setOnAction(e -> {
			primaryStage.setTitle("通用报名系统");
			primaryStage.setScene(scene1);
			primaryStage.show();
		});

	}

}
