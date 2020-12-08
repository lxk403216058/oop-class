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

//��ѯ�������Ϣ����
public class Check2 extends GridPane {
	private FileOut fo = new FileOut();

	public Check2(Stage primaryStage, Scene s) {
		set(primaryStage, s);
	}

	public void set(Stage primaryStage, Scene scene1) {
		this.setAlignment(Pos.CENTER);
		this.setPadding(new Insets(20, 12.5, 13.5, 14.5));
		this.setHgap(5);
		this.setVgap(15);

		this.add(new Label("������Ʋ�ѯ��"), 0, 0);
		TextField tf1 = new TextField();
		this.add(tf1, 1, 0);

		Button b1 = new Button("ȷ��");
		Button b2 = new Button("����");

		this.add(b1, 1, 1);
		this.add(b2, 0, 1);

		this.setStyle("-fx-background-color:AQUAMARINE");

		fo.dataIn("ActivityMessage.txt");
		ArrayList<String> name = new ArrayList<>();
		for (int i = 0; i < fo.getExpression().size(); i++) {
			String[] s = fo.getExpression().get(i).split(" ");
			name.add(s[0]);
		}

		// ȷ����ť
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

				this.add(new Label("��ֹʱ�䣺"), 0, 3);
				this.add(new Label("�������ޣ�"), 0, 4);
				this.add(new Label("�ѱ�������"), 0, 5);

				TextField t1 = new TextField(s[1]);
				TextField t2 = new TextField(s[2]);
				TextField t3 = new TextField(s[3]);

				this.add(t1, 1, 3);
				this.add(t2, 1, 4);
				this.add(t3, 1, 5);

			} else {
				Alert alert = new Alert(AlertType.WARNING, "û�л��Ϣ");
				alert.show();
			}
		});

		// ���ذ�ť
		b2.setOnAction(e -> {
			primaryStage.setTitle("ͨ�ñ���ϵͳ");
			primaryStage.setScene(scene1);
			primaryStage.show();
		});
	}

}
