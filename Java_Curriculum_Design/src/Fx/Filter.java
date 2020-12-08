package Fx;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//�Զ�ɸѡ����
public class Filter extends GridPane {
	private FileIn fi = new FileIn();
	private FileOut fo = new FileOut();

	public Filter(Stage primaryStage, Scene s) {
		set(primaryStage, s);
	}

	public void set(Stage primaryStage, Scene scene1) {
		this.setAlignment(Pos.CENTER);
		this.setPadding(new Insets(100, 12.5, 13.5, 14.5));
		this.setHgap(5);
		this.setVgap(30);

		Text t = new Text("����ɸѡ����");

		this.add(new Label("��С���䣺"), 0, 1);
		TextField tf1 = new TextField();
		this.add(tf1, 1, 1);

		this.add(new Label("������䣺"), 0, 2);
		TextField tf2 = new TextField();
		this.add(tf2, 1, 2);

		this.add(new Label("�Ա�"), 0, 3);
		TextField tf3 = new TextField();
		this.add(tf3, 1, 3);

		Button b1 = new Button("�Ա�");
		Button b2 = new Button("��С����");
		Button b3 = new Button("�������");
		Button b4 = new Button("����");

		this.add(b1, 0, 4);
		this.add(b2, 1, 4);
		this.add(b3, 2, 4);
		this.add(b4, 0, 5);
		this.setStyle("-fx-background-color:AQUAMARINE");

		fo.dataIn("SimpleUserInformation.txt");

		ArrayList<String> sex = new ArrayList<>();
		ArrayList<String> age = new ArrayList<>();
		for (int i = 0; i < fo.getExpression().size(); i++) {
			String[] s = fo.getExpression().get(i).split(" ");

			sex.add(s[3]);
			age.add(s[6]);

		}

		// ���Ա�ɸѡ��ť
		b1.setOnAction(e -> {
			ArrayList<Integer> arr = new ArrayList<>();

			for (int i = 0; i < sex.size(); i++) {
				if (tf3.getText().equals(sex.get(i))) {

					arr.add(i);
				}
			}

			for (int i = 0; i < arr.size(); i++) {
				int j = arr.get(i);
				fo.getExpression().remove(j);
			}

			fi.fileIN(fo.getExpression(), "SimpleUserInformation.txt");

			Alert alert = new Alert(AlertType.INFORMATION, "ɸѡ�ɹ���");
			alert.show();

		});

		// ����С����ɸѡ��ť
		b2.setOnAction(e -> {
			int min = Integer.valueOf(tf1.getText());

			ArrayList<Integer> arr = new ArrayList<>();

			for (int i = 0; i < age.size(); i++) {
				if (Integer.valueOf(age.get(i)) < min) {
					arr.add(i);
				}
			}

			for (int i = 0; i < arr.size(); i++) {
				int j = arr.get(i);
				fo.getExpression().remove(j);
			}

			fi.fileIN(fo.getExpression(), "SimpleUserInformation.txt");
			Alert alert = new Alert(AlertType.INFORMATION, "ɸѡ�ɹ���");
			alert.show();
		});

		// ���������ɸѡ��ť
		b3.setOnAction(e -> {
			int max = Integer.valueOf(tf2.getText());

			ArrayList<Integer> arr = new ArrayList<>();

			for (int i = 0; i < age.size(); i++) {
				if (Integer.valueOf(age.get(i)) > max) {
					arr.add(i);
				}
			}

			for (int i = 0; i < arr.size(); i++) {
				int j = arr.get(i);
				fo.getExpression().remove(j);
			}

			fi.fileIN(fo.getExpression(), "SimpleUserInformation.txt");
			Alert alert = new Alert(AlertType.INFORMATION, "ɸѡ�ɹ���");
			alert.show();
		});

		b4.setOnAction(e -> {
			primaryStage.setTitle("ͨ�ñ���ϵͳ");
			primaryStage.setScene(scene1);
			primaryStage.show();
		});

	}

}
