package Fx;

import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.util.ArrayList;

//��ѯ��ͨ�û����Ϣ��
public class Check1 extends GridPane {
	private FileOut fo = new FileOut();

	public Check1(Stage primaryStage, Scene s) {
		set(primaryStage, s);
	}

	public void set(Stage primaryStage, Scene scene1) {
		this.setAlignment(Pos.CENTER);
		this.setPadding(new Insets(20, 12.5, 13.5, 14.5));
		this.setHgap(5);
		this.setVgap(15);

		this.add(new Label("��������ѯ��"), 0, 0);
		TextField tf1 = new TextField();
		this.add(tf1, 1, 0);

		this.add(new Label("���˺Ų�ѯ��"), 0, 1);
		TextField tf2 = new TextField();
		this.add(tf2, 1, 1);

		Button b1 = new Button("ȷ��");
		Button b2 = new Button("����");

		this.add(b1, 1, 2);
		this.add(b2, 0, 2);

		this.setStyle("-fx-background-color:AQUAMARINE");

		fo.dataIn("SimpleUserInformation.txt");

		ArrayList<String> name = new ArrayList<>();
		ArrayList<String> account = new ArrayList<>();
		for (int i = 0; i < fo.getExpression().size(); i++) {
			String[] s = fo.getExpression().get(i).split(" ");
			name.add(s[2]);
			account.add(s[0]);
		}

		b1.setOnAction(e -> {
			// System.out.println("1");
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

				this.add(new Label("�˺ţ�"), 0, 3);
				this.add(new Label("���룺"), 0, 4);
				this.add(new Label("������"), 0, 5);
				this.add(new Label("�Ա�"), 0, 6);
				this.add(new Label("���䣺"), 0, 7);
				this.add(new Label("���֤�ţ�"), 0, 8);
				this.add(new Label("�������ڣ�"), 0, 9);
				this.add(new Label("���Ϣ��"), 0, 10);

				TextField t1 = new TextField(s[0]);
				TextField t2 = new TextField(s[1]);
				TextField t3 = new TextField(s[2]);
				TextField t4 = new TextField(s[3]);
				TextField t5 = new TextField(s[6]);
				TextField t6 = new TextField(s[4]);
				TextField t7 = new TextField(s[5]);
				TextField t8 = new TextField(s[7]);

				// setConstraints(TextField.);

				this.add(t1, 1, 3);
				this.add(t2, 1, 4);
				this.add(t3, 1, 5);
				this.add(t4, 1, 6);
				this.add(t5, 1, 7);
				this.add(t6, 1, 8);
				this.add(t7, 1, 9);
				this.add(t8, 1, 10);

			} else {
				Alert alert = new Alert(AlertType.WARNING, "���û������ڻ�δ����");
				alert.show();
			}

		});

		b2.setOnAction(e -> {
			primaryStage.setTitle("ͨ�ñ���ϵͳ");
			primaryStage.setScene(scene1);
			primaryStage.show();
		});

	}

}
