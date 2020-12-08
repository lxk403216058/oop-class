package Fx;

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

//�������Ϣ���ӽ���
public class Increase1 extends GridPane {
	private FileIn fi = new FileIn();

	public Increase1(Stage primaryStage, Scene s) {
		set(primaryStage, s);
	}

	public void set(Stage primaryStage, Scene scene1) {
		this.setAlignment(Pos.CENTER);
		this.setPadding(new Insets(20, 12.5, 13.5, 14.5));
		this.setHgap(5);
		this.setVgap(30);

		this.add(new Label("����ƣ�"), 0, 0);
		TextField name = new TextField();
		this.add(name, 1, 0);

		this.add(new Label("��ֹʱ�䣺"), 0, 1);
		TextField time = new TextField();
		this.add(time, 1, 1);

		this.add(new Label("�������ޣ�"), 0, 2);
		TextField num = new TextField();
		this.add(num, 1, 2);

		Button b4 = new Button("ȷ��");
		this.add(b4, 1, 3);
		b4.setMaxSize(200, 200);
		b4.setStyle("-fx-background-color:YELLOWGREEN");

		Button b5 = new Button("����");
		this.add(b5, 1, 4);
		b5.setMaxSize(200, 200);
		b5.setStyle("-fx-background-color:YELLOWGREEN");

		this.setStyle("-fx-background-color:AQUAMARINE");

		// ���Ӱ�ť
		b4.setOnAction(e -> {
			String information = name.getText() + " " + time.getText() + " " + num.getText() + " " + "0";
			fi.fileIn(information, "ActivityMessage.txt");
			Alert alert = new Alert(AlertType.INFORMATION, "���ӳɹ���");
			alert.show();
		});

		// ���ذ�ť
		b5.setOnAction(e -> {
			primaryStage.setTitle("ͨ�ñ���ϵͳ");
			primaryStage.setScene(scene1);
			primaryStage.show();
		});

	}

}
