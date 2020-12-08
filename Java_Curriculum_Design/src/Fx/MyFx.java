package Fx;

import java.util.ArrayList;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MyFx extends Application {

	private FileIn fi = new FileIn();
	private FileOut fo = new FileOut();

	public void start(Stage primaryStage) {
		BorderPane bPane = new BorderPane();
		GridPane gPane = new GridPane();

		gPane.setHgap(5);// ��¼����
		gPane.setVgap(30);

		bPane.setStyle("-fx-background-color:AQUAMARINE");// ���ñ�����ɫ

		gPane.setAlignment(Pos.TOP_CENTER);
		gPane.setPadding(new Insets(100, 12.5, 13.5, 14.5));
		Text t1 = new Text("ͨ�ñ���ϵͳ");
		t1.setFont(Font.font("����", FontWeight.BOLD, FontPosture.ITALIC, 30));
		gPane.add(t1, 1, 0);

		gPane.add(new Label("      �˺ţ�"), 0, 1);
		TextField account = new TextField();
		gPane.add(account, 1, 1);

		gPane.add(new Label("      ���룺"), 0, 2);
		TextField password = new TextField();
		gPane.add(password, 1, 2);

		gPane.add(new Label("�û����ͣ�"), 0, 3);
		ObservableList<String> message = FXCollections.observableArrayList("��ͨ�û�", "�����������", "ϵͳ����Ա");
		ComboBox<String> cbo1 = new ComboBox<>(message);
		cbo1.getSelectionModel().select(0);
		gPane.add(cbo1, 1, 3);

		fo.dataIn("ActivityMessage.txt");
		ArrayList<RegistrationActivity> ar = new ArrayList<>();

		for (int i = 0; i < fo.getExpression().size(); i++) {
			String m[] = fo.getExpression().get(i).split(" ");
			String tag = m[0];
			String deadline = m[1];
			String numberLimit = m[2];
			int num = Integer.valueOf(m[3]);
			if (m[2].equals(m[3])) {

			} else {
				ar.add(new RegistrationActivity(tag, deadline, numberLimit, num));
			}

		}

		gPane.add(new Label("�ѡ��"), 0, 4);
		ArrayList<String> mess = new ArrayList<>();
		for (int i = 0; i < ar.size(); i++) {
			mess.add(ar.get(i).getTag());
		}
		ObservableList<String> message1 = FXCollections.observableArrayList(mess);
		ComboBox<String> cbo2 = new ComboBox<>(message1);
		cbo2.getSelectionModel().select(0);
		gPane.add(cbo2, 1, 4);

		Button b1 = new Button("��¼");
		b1.setMaxSize(200, 200);
		b1.setStyle("-fx-background-color:YELLOWGREEN");
		gPane.add(b1, 1, 5);

		bPane.setCenter(gPane);

		Button b2 = new Button("ע���˺�");
		bPane.setBottom(b2);
		b2.setStyle("-fx-background-color:AQUAMARINE");

		Button bu = new Button("�鿴���Ϣ");
		bu.setMaxSize(200, 200);
		bu.setStyle("-fx-background-color:YELLOWGREEN");
		gPane.add(bu, 1, 6);

		Scene scene1 = new Scene(bPane, 710, 599);
		primaryStage.setTitle("ͨ�ñ���ϵͳ");
		primaryStage.setScene(scene1);
		primaryStage.show();

		bu.setOnAction(e -> { // �������б��������Ϣ
			Dialog dia = new Dialog(scene1);
			dia.show();
		});

		b1.setOnAction(e -> {
			fo.getExpression().clear();
			fo.dataIn("InitiatorAccount.txt");
			String[] m = fo.getExpression().get(0).split(" ");
			Initiator ir = new Initiator(m[0], m[1]);

			fo.getExpression().clear();
			fo.dataIn("AdministratorAccount.txt");
			String[] aa = fo.getExpression().get(0).split(" ");
			Administrator as = new Administrator(aa[0], aa[1]);

			fo.getExpression().clear();
			fo.dataIn("SimpleUserAccount.txt");
			ArrayList<SimpleUser> su = new ArrayList<>();
			for (int i = 0; i < fo.getExpression().size(); i++) {
				String[] sua = fo.getExpression().get(i).split(" ");
				su.add(new SimpleUser(sua[0], sua[1]));
			}

			int flag = 0;
			for (int i = 0; i < su.size(); i++) {
				if (account.getText().equals(su.get(i).account) && password.getText().equals(su.get(i).password)) {
					flag = 1;
					break;
				}
			}

			String str;
			str = cbo1.getValue();
			GridPane gPane1 = new GridPane();
			gPane1.setAlignment(Pos.TOP_CENTER);
			gPane1.setPadding(new Insets(100, 12.5, 13.5, 14.5));
			gPane1.setHgap(5);
			gPane1.setVgap(30);

			if (str.equals("��ͨ�û�") && flag == 1) {// ��ͨ�û���¼����
				gPane1.add(new Label("������"), 0, 1);
				TextField name = new TextField();
				gPane1.add(name, 1, 1);

				gPane1.add(new Label("�Ա�"), 0, 2);
				TextField sex = new TextField();
				gPane1.add(sex, 1, 2);

				gPane1.add(new Label("���֤�ţ�"), 0, 5);
				TextField num = new TextField();
				gPane1.add(num, 1, 5);

				gPane1.add(new Label("�������ڣ�"), 0, 4);
				TextField birthday = new TextField();
				gPane1.add(birthday, 1, 4);

				gPane1.add(new Label("���䣺"), 0, 3);
				TextField age = new TextField();
				gPane1.add(age, 1, 3);

				// ȷ����ť
				Button b4 = new Button("ȷ��");
				gPane1.add(b4, 1, 6);
				b4.setMaxSize(200, 200);
				b4.setStyle("-fx-background-color:YELLOWGREEN");

				// ���ذ�ť
				Button b5 = new Button("����");
				gPane1.add(b5, 1, 7);
				b5.setMaxSize(200, 200);
				b5.setStyle("-fx-background-color:YELLOWGREEN");

				gPane1.setStyle("-fx-background-color:AQUAMARINE");
				Scene scene2 = new Scene(gPane1, 710, 599);
				primaryStage.setTitle("ͨ�ñ���ϵͳ");
				primaryStage.setScene(scene2);
				primaryStage.show();

				b4.setOnAction(e1 -> {
					int flag1 = 0;
					int j = 0;
					for (int i = 0; i < ar.size(); i++) {
						if (cbo2.getValue().equals(ar.get(i).getTag())) {
							flag1 = 1;
							j = i;
							break;
						}
					}

					String information = account.getText() + " " + password.getText() + " " + name.getText() + " "
							+ sex.getText() + " " + num.getText() + " " + birthday.getText() + " " + age.getText() + " "
							+ cbo2.getValue();
					fi.fileIn(information, "SimpleUserInformation.txt");

					if (flag1 == 1) {
						ar.get(j).setNum();
					}
					ArrayList<String> information1 = new ArrayList<>();
					for (int i = 0; i < ar.size(); i++) {
						information1.add(ar.get(i).getTag() + " " + ar.get(i).getDeadline() + " "
								+ ar.get(i).getNumberLimit() + " " + ar.get(i).getNum());
					}

					fi.fileIN(information1, "ActivityMessage.txt");

					Alert alert = new Alert(AlertType.INFORMATION, "��ϲ�㣬�����ɹ���");
					alert.show();

				});

				b5.setOnAction(e1 -> {
					primaryStage.setTitle("ͨ�ñ���ϵͳ");
					primaryStage.setScene(scene1);
					primaryStage.show();
				});

				// ����������߽���
			} else if (str.equals("�����������") && ir.getAccount().equals(account.getText())
					&& ir.getPassword().equals(password.getText())) {

				Button search = new Button("��ѯ");
				Button increase = new Button("����");
				Button delete = new Button("ɾ��");
				Button filter = new Button("ɸѡ");
				Button exit = new Button("�˳�");
				Button review = new Button("���");
				Button b4 = new Button("����");
				Button change = new Button("����");

				search.setMinSize(200, 50);
				increase.setMinSize(200, 50);
				delete.setMinSize(200, 50);
				filter.setMinSize(200, 50);
				exit.setMinSize(200, 50);
				review.setMinSize(200, 50);
				change.setMinSize(200, 50);
				;
				b4.setMinSize(200, 50);
				;

				gPane1.add(search, 0, 0);
				gPane1.add(increase, 1, 0);
				gPane1.add(delete, 0, 1);
				gPane1.add(change, 1, 1);
				gPane1.add(filter, 0, 2);
				gPane1.add(review, 1, 2);
				gPane1.add(exit, 0, 3);
				gPane1.add(b4, 1, 3);

				gPane1.setStyle("-fx-background-color:AQUAMARINE");
				Scene scene2 = new Scene(gPane1, 710, 599);
				primaryStage.setTitle("ͨ�ñ���ϵͳ");
				primaryStage.setScene(scene2);
				primaryStage.show();

				// ��ѯ��ť
				search.setOnAction(e1 -> {
					Check2 check2 = new Check2(primaryStage, scene2);

					Scene scene3 = new Scene(check2, 710, 599);
					primaryStage.setTitle("ͨ�ñ���ϵͳ");
					primaryStage.setScene(scene3);
					primaryStage.show();
				});

				// ���Ӱ�ť
				increase.setOnAction(e1 -> {
					Increase1 in = new Increase1(primaryStage, scene2);

					Scene scene3 = new Scene(in, 710, 599);
					primaryStage.setTitle("ͨ�ñ���ϵͳ");
					primaryStage.setScene(scene3);
					primaryStage.show();
				});

				// ɾ����ť
				delete.setOnAction(e1 -> {
					Delete1 delete1 = new Delete1(primaryStage, scene2);

					Scene scene3 = new Scene(delete1, 710, 599);
					primaryStage.setTitle("ͨ�ñ���ϵͳ");
					primaryStage.setScene(scene3);
					primaryStage.show();
				});

				// ���İ�ť
				change.setOnAction(e1 -> {
					Change1 cha = new Change1(primaryStage, scene2);

					Scene scene3 = new Scene(cha, 710, 599);
					primaryStage.setTitle("ͨ�ñ���ϵͳ");
					primaryStage.setScene(scene3);
					primaryStage.show();
				});

				// ɸѡ��ť
				filter.setOnAction(e1 -> {
					GridPane gPane4 = new GridPane();
					gPane4.setStyle("-fx-background-color:AQUAMARINE");
					gPane4.setAlignment(Pos.CENTER);
					gPane4.setPadding(new Insets(100, 12.5, 13.5, 14.5));
					gPane4.setHgap(5);
					gPane4.setVgap(30);

					Button filter1 = new Button("�Զ�ɸѡ");
					Button filter2 = new Button("�˹�ɸѡ");
					Button b3 = new Button("����");
					Button b7 = new Button("�˳�");

					filter1.setMinSize(200, 50);
					filter2.setMinSize(200, 50);
					b3.setMinSize(200, 50);
					b7.setMinSize(200, 50);

					gPane4.add(filter1, 0, 0);
					gPane4.add(filter2, 0, 1);
					gPane4.add(b3, 0, 2);
					gPane4.add(b7, 0, 3);

					Scene scene3 = new Scene(gPane4, 710, 599);
					primaryStage.setTitle("ͨ�ñ���ϵͳ");
					primaryStage.setScene(scene3);
					primaryStage.show();

					// �Զ�ɸѡ��ť
					filter1.setOnAction(e2 -> {
						Filter fil = new Filter(primaryStage, scene3);

						Scene scene4 = new Scene(fil, 710, 599);
						primaryStage.setTitle("ͨ�ñ���ϵͳ");
						primaryStage.setScene(scene4);
						primaryStage.show();
					});

					// �˹�ɸѡ��ť
					filter2.setOnAction(e2 -> {
						Filter1 fil = new Filter1(primaryStage, scene3);

						Scene scene4 = new Scene(fil, 710, 599);
						primaryStage.setTitle("ͨ�ñ���ϵͳ");
						primaryStage.setScene(scene4);
						primaryStage.show();
					});

					// ���ذ�ť
					b3.setOnAction(e2 -> {
						primaryStage.setTitle("ͨ�ñ���ϵͳ");
						primaryStage.setScene(scene2);
						primaryStage.show();
					});

					// �˳���ť
					b7.setOnAction(e2 -> {
						System.exit(0);
					});
				});

				// ��˰�ť
				review.setOnAction(e1 -> {
					Review review1 = new Review(primaryStage, scene2);

					Scene scene3 = new Scene(review1, 710, 599);
					primaryStage.setTitle("ͨ�ñ���ϵͳ");
					primaryStage.setScene(scene3);
					primaryStage.show();
				});

				// �˳���ť
				exit.setOnAction(e1 -> {
					System.exit(0);
				});

				// �������
				b4.setOnAction(e1 -> {
					primaryStage.setTitle("ͨ�ñ���ϵͳ");
					primaryStage.setScene(scene1);
					primaryStage.show();
				});

				// ϵͳ����Ա��½����
			} else if (str.equals("ϵͳ����Ա") && as.getAccount().equals(account.getText())
					&& as.getPassword().equals(password.getText())) {
				Button search = new Button("��ѯ");
				Button increase = new Button("����");
				Button delete = new Button("ɾ��");
				Button change = new Button("����");
				Button exit = new Button("�˳�");
				Button b4 = new Button("����");

				search.setMinSize(200, 50);
				increase.setMinSize(200, 50);
				delete.setMinSize(200, 50);
				change.setMinSize(200, 50);
				exit.setMinSize(200, 50);
				b4.setMinSize(200, 50);

				gPane1.add(search, 0, 0);
				gPane1.add(increase, 0, 1);
				gPane1.add(delete, 0, 2);
				gPane1.add(change, 0, 3);
				gPane1.add(exit, 0, 4);
				gPane1.add(b4, 0, 5);

				gPane1.setStyle("-fx-background-color:AQUAMARINE");
				Scene scene2 = new Scene(gPane1, 710, 599);
				primaryStage.setTitle("ͨ�ñ���ϵͳ");
				primaryStage.setScene(scene2);
				primaryStage.show();

				// ��ѯ��ť
				search.setOnAction(e1 -> {
					Check1 check1 = new Check1(primaryStage, scene2);

					Scene scene3 = new Scene(check1, 710, 599);
					primaryStage.setTitle("ͨ�ñ���ϵͳ");
					primaryStage.setScene(scene3);
					primaryStage.show();
				});

				// ����
				increase.setOnAction(e1 -> {
					Increase in = new Increase(primaryStage, scene2);

					Scene scene3 = new Scene(in, 710, 599);
					primaryStage.setTitle("ͨ�ñ���ϵͳ");
					primaryStage.setScene(scene3);
					primaryStage.show();
				});

				// ɾ��
				delete.setOnAction(e1 -> {
					Delete delete1 = new Delete(primaryStage, scene2);

					Scene scene3 = new Scene(delete1, 710, 599);
					primaryStage.setTitle("ͨ�ñ���ϵͳ");
					primaryStage.setScene(scene3);
					primaryStage.show();
				});

				// ����
				change.setOnAction(e1 -> {
					Change cha = new Change(primaryStage, scene2);

					Scene scene3 = new Scene(cha, 710, 599);
					primaryStage.setTitle("ͨ�ñ���ϵͳ");
					primaryStage.setScene(scene3);
					primaryStage.show();
				});

				// ����
				b4.setOnAction(e1 -> {
					primaryStage.setTitle("ͨ�ñ���ϵͳ");
					primaryStage.setScene(scene1);
					primaryStage.show();
				});

				// �˳�
				exit.setOnAction(e1 -> {
					System.exit(0);
				});

			} else {

				// �˺Ż����������ʾ����
				Alert alert = new Alert(AlertType.WARNING, "�˺Ż��������");
				alert.show();
			}

		});

		// ��ͨ�û�ע�����
		b2.setOnAction(e -> {
			GridPane gPane2 = new GridPane();
			gPane2.setHgap(5);
			gPane2.setVgap(30);

			gPane2.setAlignment(Pos.TOP_CENTER);
			gPane2.setPadding(new Insets(100, 12.5, 13.5, 14.5));
			Text t2 = new Text("��ͨ�û�ע��ҳ��");
			t2.setFont(Font.font("����", FontWeight.BOLD, FontPosture.ITALIC, 30));
			gPane2.add(t2, 1, 0);

			gPane2.add(new Label("�˺ţ�"), 0, 1);
			TextField account1 = new TextField();
			gPane2.add(account1, 1, 1);

			gPane2.add(new Label("���룺"), 0, 2);
			TextField password1 = new TextField();
			gPane2.add(password1, 1, 2);

			Button b3 = new Button("ȷ��");
			b3.setMaxSize(250, 100);
			b3.setStyle("-fx-background-color:YELLOWGREEN");
			gPane2.add(b3, 1, 3);
			gPane2.setStyle("-fx-background-color:AQUAMARINE");

			Button b4 = new Button("����");
			b4.setMaxSize(250, 100);
			b4.setStyle("-fx-background-color:YELLOWGREEN");
			gPane2.add(b4, 1, 4);

			// ���ؽ���
			b4.setOnAction(e1 -> {
				primaryStage.setTitle("ͨ�ñ���ϵͳ");
				primaryStage.setScene(scene1);
				primaryStage.show();
			});

			Scene scene2 = new Scene(gPane2, 710, 599);
			primaryStage.setTitle("ͨ�ñ���ϵͳ");
			primaryStage.setScene(scene2);
			primaryStage.show();

			// �����˺�
			account1.textProperty().addListener((observable, oldValue, newValue) -> {
				String trimed = newValue.trim();

				if (!trimed.matches("[1-9]{1}[0-9]{0,8}")) {

					trimed = trimed.replaceAll("[^1-9]{1}[^0-9]{0,8}", "");
					account1.setText(trimed);
					Alert alert = new Alert(AlertType.WARNING, "�˺Ų���Ϊ�գ����ܳ���9λ���з�����");
					alert.show();
				}

			});

			// ȷ����ť
			b3.setOnAction(e1 -> {
				String s = password1.getText();

				fo.getExpression().clear();
				fo.dataIn("SimpleUserAccount.txt");
				int flag = 0;

				for (int i = 0; i < fo.getExpression().size(); i++) {
					String[] judge = fo.getExpression().get(i).split(" ");
					if (account1.getText().equals(judge[0])) {
						flag = 1;
						break;
					}
				}

				if (s.equals("")) {
					Alert alert = new Alert(AlertType.WARNING, "���벻��Ϊ�գ�");
					alert.show();

				} else if (flag != 1) {
					String ap = account1.getText() + " " + password1.getText();
					fi.fileIn(ap, "SimpleUserAccount.txt");

					Alert alert = new Alert(AlertType.INFORMATION, "ע��ɹ������ص�¼���档");
					alert.show();

					primaryStage.setTitle("ͨ�ñ���ϵͳ");
					primaryStage.setScene(scene1);
					primaryStage.show();
				} else {

					// �˺�ע��ɹ�����
					Alert alert = new Alert(AlertType.WARNING, "���˺���ע��");
					alert.show();
				}

			});

			String mes = account1.getText() + password1.getText();
		});
	}

	public static void main(String[] args) {
		launch(args);
	}

}
