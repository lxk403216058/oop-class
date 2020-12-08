package Fx;

import java.util.ArrayList;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

//所有报名活动的信息的弹窗
public class Dialog {
	private Stage stage;
	private Scene scene;
	private ArrayList<Label> labs = new ArrayList<Label>();
	private FileOut fo = new FileOut();
	private final TableView<Person> table = new TableView<>();

	public Dialog(Scene scene) {
		this.stage = new Stage();
		this.scene = scene;
	}

	public void show() {
		fo.dataIn("ActivityMessage.txt");
		ArrayList<Person> ap = new ArrayList<>();

		for (int i = 0; i < fo.getExpression().size(); i++) {
			String[] s = fo.getExpression().get(i).split(" ");

			ap.add(new Person(s[0], s[1], s[2], s[3]));
		}

		ObservableList<Person> data = FXCollections.observableArrayList(ap);

		Label label = new Label("报名活动信息");
		label.setFont(new Font("Arial", 20));

		table.setEditable(true);

		BorderPane borderkPane = new BorderPane();
		borderkPane.setPrefWidth(400);
		borderkPane.setPrefHeight(200);

		TableColumn nameCol = new TableColumn("名字");
		nameCol.setMinWidth(60);
		nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

		TableColumn deadlineCol = new TableColumn("截止时间");
		deadlineCol.setMinWidth(60);
		deadlineCol.setCellValueFactory(new PropertyValueFactory<>("deadline"));

		TableColumn limitCol = new TableColumn("人数上限");
		limitCol.setMinWidth(60);
		limitCol.setCellValueFactory(new PropertyValueFactory<>("limit"));

		TableColumn numCol = new TableColumn("已报人数");
		numCol.setMinWidth(60);
		numCol.setCellValueFactory(new PropertyValueFactory<>("num"));

		table.setItems(data);
		table.getColumns().addAll(nameCol, deadlineCol, limitCol, numCol);

		VBox vbox = new VBox();
		vbox.setSpacing(5);
		vbox.setPadding(new Insets(10, 0, 0, 10));
		vbox.getChildren().addAll(label, table);

		borderkPane.setTop(vbox);
		borderkPane.setStyle("-fx-background-color:AQUAMARINE");

		stage.setScene(new Scene(borderkPane));
		// 取消最大化 默认：stage.setResizable(true);
		stage.setResizable(false);
		// 取消最小化 默认：stage.initOwner(null);
		stage.initOwner(scene.getWindow());
		stage.show();
	}

	public void setTitle(String title) {
		stage.setTitle(title);
	}

	public static class Person {

		private final SimpleStringProperty name;
		private final SimpleStringProperty deadline;
		private final SimpleStringProperty limit;
		private final SimpleStringProperty num;

		private Person(String fName, String lName, String eName, String sName) {
			this.name = new SimpleStringProperty(fName);
			this.deadline = new SimpleStringProperty(lName);
			this.limit = new SimpleStringProperty(eName);
			this.num = new SimpleStringProperty(sName);

		}

		public String getName() {
			return name.get();
		}

		public void setName(String fName) {
			name.set(fName);
		}

		public String getDeadline() {
			return deadline.get();
		}

		public void setDeadline(String fName) {
			deadline.set(fName);
		}

		public String getNum() {
			return num.get();
		}

		public void setNum(String fName) {
			num.set(fName);
		}

		public String getLimit() {
			return limit.get();
		}

		public void setLimit(String fName) {
			limit.set(fName);
		}

	}

}
