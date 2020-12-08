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

		gPane.setHgap(5);// 登录界面
		gPane.setVgap(30);

		bPane.setStyle("-fx-background-color:AQUAMARINE");// 设置背景颜色

		gPane.setAlignment(Pos.TOP_CENTER);
		gPane.setPadding(new Insets(100, 12.5, 13.5, 14.5));
		Text t1 = new Text("通用报名系统");
		t1.setFont(Font.font("宋体", FontWeight.BOLD, FontPosture.ITALIC, 30));
		gPane.add(t1, 1, 0);

		gPane.add(new Label("      账号："), 0, 1);
		TextField account = new TextField();
		gPane.add(account, 1, 1);

		gPane.add(new Label("      密码："), 0, 2);
		TextField password = new TextField();
		gPane.add(password, 1, 2);

		gPane.add(new Label("用户类型："), 0, 3);
		ObservableList<String> message = FXCollections.observableArrayList("普通用户", "报名活动发起者", "系统管理员");
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

		gPane.add(new Label("活动选择："), 0, 4);
		ArrayList<String> mess = new ArrayList<>();
		for (int i = 0; i < ar.size(); i++) {
			mess.add(ar.get(i).getTag());
		}
		ObservableList<String> message1 = FXCollections.observableArrayList(mess);
		ComboBox<String> cbo2 = new ComboBox<>(message1);
		cbo2.getSelectionModel().select(0);
		gPane.add(cbo2, 1, 4);

		Button b1 = new Button("登录");
		b1.setMaxSize(200, 200);
		b1.setStyle("-fx-background-color:YELLOWGREEN");
		gPane.add(b1, 1, 5);

		bPane.setCenter(gPane);

		Button b2 = new Button("注册账号");
		bPane.setBottom(b2);
		b2.setStyle("-fx-background-color:AQUAMARINE");

		Button bu = new Button("查看活动信息");
		bu.setMaxSize(200, 200);
		bu.setStyle("-fx-background-color:YELLOWGREEN");
		gPane.add(bu, 1, 6);

		Scene scene1 = new Scene(bPane, 710, 599);
		primaryStage.setTitle("通用报名系统");
		primaryStage.setScene(scene1);
		primaryStage.show();

		bu.setOnAction(e -> { // 弹出所有报名活动的信息
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

			if (str.equals("普通用户") && flag == 1) {// 普通用户登录界面
				gPane1.add(new Label("姓名："), 0, 1);
				TextField name = new TextField();
				gPane1.add(name, 1, 1);

				gPane1.add(new Label("性别："), 0, 2);
				TextField sex = new TextField();
				gPane1.add(sex, 1, 2);

				gPane1.add(new Label("身份证号："), 0, 5);
				TextField num = new TextField();
				gPane1.add(num, 1, 5);

				gPane1.add(new Label("出生日期："), 0, 4);
				TextField birthday = new TextField();
				gPane1.add(birthday, 1, 4);

				gPane1.add(new Label("年龄："), 0, 3);
				TextField age = new TextField();
				gPane1.add(age, 1, 3);

				// 确定按钮
				Button b4 = new Button("确定");
				gPane1.add(b4, 1, 6);
				b4.setMaxSize(200, 200);
				b4.setStyle("-fx-background-color:YELLOWGREEN");

				// 返回按钮
				Button b5 = new Button("返回");
				gPane1.add(b5, 1, 7);
				b5.setMaxSize(200, 200);
				b5.setStyle("-fx-background-color:YELLOWGREEN");

				gPane1.setStyle("-fx-background-color:AQUAMARINE");
				Scene scene2 = new Scene(gPane1, 710, 599);
				primaryStage.setTitle("通用报名系统");
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

					Alert alert = new Alert(AlertType.INFORMATION, "恭喜你，报名成功！");
					alert.show();

				});

				b5.setOnAction(e1 -> {
					primaryStage.setTitle("通用报名系统");
					primaryStage.setScene(scene1);
					primaryStage.show();
				});

				// 报名活动发起者界面
			} else if (str.equals("报名活动发起者") && ir.getAccount().equals(account.getText())
					&& ir.getPassword().equals(password.getText())) {

				Button search = new Button("查询");
				Button increase = new Button("增加");
				Button delete = new Button("删除");
				Button filter = new Button("筛选");
				Button exit = new Button("退出");
				Button review = new Button("审核");
				Button b4 = new Button("返回");
				Button change = new Button("更改");

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
				primaryStage.setTitle("通用报名系统");
				primaryStage.setScene(scene2);
				primaryStage.show();

				// 查询按钮
				search.setOnAction(e1 -> {
					Check2 check2 = new Check2(primaryStage, scene2);

					Scene scene3 = new Scene(check2, 710, 599);
					primaryStage.setTitle("通用报名系统");
					primaryStage.setScene(scene3);
					primaryStage.show();
				});

				// 增加按钮
				increase.setOnAction(e1 -> {
					Increase1 in = new Increase1(primaryStage, scene2);

					Scene scene3 = new Scene(in, 710, 599);
					primaryStage.setTitle("通用报名系统");
					primaryStage.setScene(scene3);
					primaryStage.show();
				});

				// 删除按钮
				delete.setOnAction(e1 -> {
					Delete1 delete1 = new Delete1(primaryStage, scene2);

					Scene scene3 = new Scene(delete1, 710, 599);
					primaryStage.setTitle("通用报名系统");
					primaryStage.setScene(scene3);
					primaryStage.show();
				});

				// 更改按钮
				change.setOnAction(e1 -> {
					Change1 cha = new Change1(primaryStage, scene2);

					Scene scene3 = new Scene(cha, 710, 599);
					primaryStage.setTitle("通用报名系统");
					primaryStage.setScene(scene3);
					primaryStage.show();
				});

				// 筛选按钮
				filter.setOnAction(e1 -> {
					GridPane gPane4 = new GridPane();
					gPane4.setStyle("-fx-background-color:AQUAMARINE");
					gPane4.setAlignment(Pos.CENTER);
					gPane4.setPadding(new Insets(100, 12.5, 13.5, 14.5));
					gPane4.setHgap(5);
					gPane4.setVgap(30);

					Button filter1 = new Button("自动筛选");
					Button filter2 = new Button("人工筛选");
					Button b3 = new Button("返回");
					Button b7 = new Button("退出");

					filter1.setMinSize(200, 50);
					filter2.setMinSize(200, 50);
					b3.setMinSize(200, 50);
					b7.setMinSize(200, 50);

					gPane4.add(filter1, 0, 0);
					gPane4.add(filter2, 0, 1);
					gPane4.add(b3, 0, 2);
					gPane4.add(b7, 0, 3);

					Scene scene3 = new Scene(gPane4, 710, 599);
					primaryStage.setTitle("通用报名系统");
					primaryStage.setScene(scene3);
					primaryStage.show();

					// 自动筛选按钮
					filter1.setOnAction(e2 -> {
						Filter fil = new Filter(primaryStage, scene3);

						Scene scene4 = new Scene(fil, 710, 599);
						primaryStage.setTitle("通用报名系统");
						primaryStage.setScene(scene4);
						primaryStage.show();
					});

					// 人工筛选按钮
					filter2.setOnAction(e2 -> {
						Filter1 fil = new Filter1(primaryStage, scene3);

						Scene scene4 = new Scene(fil, 710, 599);
						primaryStage.setTitle("通用报名系统");
						primaryStage.setScene(scene4);
						primaryStage.show();
					});

					// 返回按钮
					b3.setOnAction(e2 -> {
						primaryStage.setTitle("通用报名系统");
						primaryStage.setScene(scene2);
						primaryStage.show();
					});

					// 退出按钮
					b7.setOnAction(e2 -> {
						System.exit(0);
					});
				});

				// 审核按钮
				review.setOnAction(e1 -> {
					Review review1 = new Review(primaryStage, scene2);

					Scene scene3 = new Scene(review1, 710, 599);
					primaryStage.setTitle("通用报名系统");
					primaryStage.setScene(scene3);
					primaryStage.show();
				});

				// 退出按钮
				exit.setOnAction(e1 -> {
					System.exit(0);
				});

				// 返回那妞
				b4.setOnAction(e1 -> {
					primaryStage.setTitle("通用报名系统");
					primaryStage.setScene(scene1);
					primaryStage.show();
				});

				// 系统管理员登陆界面
			} else if (str.equals("系统管理员") && as.getAccount().equals(account.getText())
					&& as.getPassword().equals(password.getText())) {
				Button search = new Button("查询");
				Button increase = new Button("增加");
				Button delete = new Button("删除");
				Button change = new Button("更改");
				Button exit = new Button("退出");
				Button b4 = new Button("返回");

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
				primaryStage.setTitle("通用报名系统");
				primaryStage.setScene(scene2);
				primaryStage.show();

				// 查询按钮
				search.setOnAction(e1 -> {
					Check1 check1 = new Check1(primaryStage, scene2);

					Scene scene3 = new Scene(check1, 710, 599);
					primaryStage.setTitle("通用报名系统");
					primaryStage.setScene(scene3);
					primaryStage.show();
				});

				// 增加
				increase.setOnAction(e1 -> {
					Increase in = new Increase(primaryStage, scene2);

					Scene scene3 = new Scene(in, 710, 599);
					primaryStage.setTitle("通用报名系统");
					primaryStage.setScene(scene3);
					primaryStage.show();
				});

				// 删除
				delete.setOnAction(e1 -> {
					Delete delete1 = new Delete(primaryStage, scene2);

					Scene scene3 = new Scene(delete1, 710, 599);
					primaryStage.setTitle("通用报名系统");
					primaryStage.setScene(scene3);
					primaryStage.show();
				});

				// 更改
				change.setOnAction(e1 -> {
					Change cha = new Change(primaryStage, scene2);

					Scene scene3 = new Scene(cha, 710, 599);
					primaryStage.setTitle("通用报名系统");
					primaryStage.setScene(scene3);
					primaryStage.show();
				});

				// 返回
				b4.setOnAction(e1 -> {
					primaryStage.setTitle("通用报名系统");
					primaryStage.setScene(scene1);
					primaryStage.show();
				});

				// 退出
				exit.setOnAction(e1 -> {
					System.exit(0);
				});

			} else {

				// 账号或密码错误提示界面
				Alert alert = new Alert(AlertType.WARNING, "账号或密码错误");
				alert.show();
			}

		});

		// 普通用户注册界面
		b2.setOnAction(e -> {
			GridPane gPane2 = new GridPane();
			gPane2.setHgap(5);
			gPane2.setVgap(30);

			gPane2.setAlignment(Pos.TOP_CENTER);
			gPane2.setPadding(new Insets(100, 12.5, 13.5, 14.5));
			Text t2 = new Text("普通用户注册页面");
			t2.setFont(Font.font("宋体", FontWeight.BOLD, FontPosture.ITALIC, 30));
			gPane2.add(t2, 1, 0);

			gPane2.add(new Label("账号："), 0, 1);
			TextField account1 = new TextField();
			gPane2.add(account1, 1, 1);

			gPane2.add(new Label("密码："), 0, 2);
			TextField password1 = new TextField();
			gPane2.add(password1, 1, 2);

			Button b3 = new Button("确定");
			b3.setMaxSize(250, 100);
			b3.setStyle("-fx-background-color:YELLOWGREEN");
			gPane2.add(b3, 1, 3);
			gPane2.setStyle("-fx-background-color:AQUAMARINE");

			Button b4 = new Button("返回");
			b4.setMaxSize(250, 100);
			b4.setStyle("-fx-background-color:YELLOWGREEN");
			gPane2.add(b4, 1, 4);

			// 返回界面
			b4.setOnAction(e1 -> {
				primaryStage.setTitle("通用报名系统");
				primaryStage.setScene(scene1);
				primaryStage.show();
			});

			Scene scene2 = new Scene(gPane2, 710, 599);
			primaryStage.setTitle("通用报名系统");
			primaryStage.setScene(scene2);
			primaryStage.show();

			// 监听账号
			account1.textProperty().addListener((observable, oldValue, newValue) -> {
				String trimed = newValue.trim();

				if (!trimed.matches("[1-9]{1}[0-9]{0,8}")) {

					trimed = trimed.replaceAll("[^1-9]{1}[^0-9]{0,8}", "");
					account1.setText(trimed);
					Alert alert = new Alert(AlertType.WARNING, "账号不能为空，不能超过9位或含有非数字");
					alert.show();
				}

			});

			// 确定按钮
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
					Alert alert = new Alert(AlertType.WARNING, "密码不能为空！");
					alert.show();

				} else if (flag != 1) {
					String ap = account1.getText() + " " + password1.getText();
					fi.fileIn(ap, "SimpleUserAccount.txt");

					Alert alert = new Alert(AlertType.INFORMATION, "注册成功，返回登录界面。");
					alert.show();

					primaryStage.setTitle("通用报名系统");
					primaryStage.setScene(scene1);
					primaryStage.show();
				} else {

					// 账号注册成功弹窗
					Alert alert = new Alert(AlertType.WARNING, "此账号已注册");
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
