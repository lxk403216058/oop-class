package com.bank.view;
//֪ͨ�кŽ��棬3������,ÿ������4������,1��˳��к�,2����ǰ������ŶӺ�ת�����������ڶ�Ӧҵ��Ķ���β,3ָ����ĳһ��,4���½е�ǰ��

import java.awt.Toolkit;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class WindowsNotice extends Application {
	public void start(final Stage primaryStage) {

		Image image = new Image("file:4.png");
		ImageView imageview = new ImageView(image);

		Text t = new Text();
		Text t1 = new Text("");
		Text t2 = new Text();
		Label l = new Label("����ҵ��");
		Label l3 = new Label("(һ�Ŵ���)");
		l.setFont(Font.font("Time New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));
		l3.setFont(Font.font("Time New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));
		Button b1 = new Button("˳��");
		Button b2 = new Button("ת�ƴ���");
		Button b3 = new Button("ָ���к�");
		Button b4 = new Button("�غ�");

		Label l1 = new Label("�Թ�ҵ��");
		Label l4 = new Label("(���Ŵ���)");
		l1.setFont(Font.font("Time New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));
		l4.setFont(Font.font("Time New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));

		Button b5 = new Button("˳��");
		Button b6 = new Button("ת�ƴ���");
		Button b7 = new Button("ָ���к�");
		Button b8 = new Button("�غ�");

		Label l2 = new Label("��ɫҵ��");
		Label l5 = new Label("(���Ŵ���)");
		l2.setFont(Font.font("Time New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));
		l5.setFont(Font.font("Time New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));
		Button b9 = new Button("˳��");
		Button b10 = new Button("ת�ƴ���");
		Button b11 = new Button("ָ���к�");
		Button b12 = new Button("�غ�");

		b1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				PersonLogin personlogin = new PersonLogin();
				personlogin.start(new Stage());

			}
		});

		b5.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				PersonLogin personlogin = new PersonLogin();
				personlogin.start(new Stage());

			}
		});

		b9.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				PersonLogin personlogin = new PersonLogin();
				personlogin.start(new Stage());

			}
		});

		l.setLayoutX(160);
		l.setLayoutY(100);
		l3.setLayoutX(155);
		l3.setLayoutY(125);
		t.setLayoutX(50);
		t.setLayoutY(100);
		t.minHeight(150);
		t.minHeight(150);
		b1.setLayoutX(110);
		b1.setLayoutY(340);
		b4.setLayoutX(110);
		b4.setLayoutY(390);
		b3.setLayoutX(190);
		b3.setLayoutY(390);
		b2.setLayoutX(190);
		b2.setLayoutY(340);

		l1.setLayoutX(340);
		l1.setLayoutY(100);
		l4.setLayoutX(330);
		l4.setLayoutY(125);
		t1.setLayoutX(300);
		t1.setLayoutY(100);
		t1.minHeight(150);
		t1.minHeight(150);
		b5.setLayoutX(300);
		b5.setLayoutY(340);
		b8.setLayoutX(300);
		b8.setLayoutY(390);
		b7.setLayoutX(380);
		b7.setLayoutY(390);
		b6.setLayoutX(380);
		b6.setLayoutY(340);

		l2.setLayoutX(530);
		l2.setLayoutY(100);
		l5.setLayoutX(525);
		l5.setLayoutY(125);
		t2.setLayoutX(550);
		t2.setLayoutY(100);
		t2.minHeight(150);
		t2.minHeight(150);
		b9.setLayoutX(490);
		b9.setLayoutY(340);
		b12.setLayoutX(490);
		b12.setLayoutY(390);
		b10.setLayoutX(560);
		b10.setLayoutY(340);
		b11.setLayoutX(560);
		b11.setLayoutY(390);

		Pane p = new Pane();
		p.getChildren().add(imageview);
		p.getChildren().add(t);
		p.getChildren().add(l);
		p.getChildren().add(l3);
		p.getChildren().add(b1);
		p.getChildren().add(b2);
		p.getChildren().add(b3);
		p.getChildren().add(b4);

		p.getChildren().add(t1);
		p.getChildren().add(l1);
		p.getChildren().add(l4);
		p.getChildren().add(b5);
		p.getChildren().add(b8);
		p.getChildren().add(b7);
		p.getChildren().add(b6);

		p.getChildren().add(t2);
		p.getChildren().add(l2);
		p.getChildren().add(l5);
		p.getChildren().add(b9);
		p.getChildren().add(b12);
		p.getChildren().add(b10);
		p.getChildren().add(b11);

		Scene s = new Scene(p, 750, 500);
		primaryStage.setTitle("");
		primaryStage.getIcons().add(new Image("file:2.jpg"));// ���ô������Ͻ���ʾ��ͼƬ

		primaryStage.setScene(s);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);

	}
}
