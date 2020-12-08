import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class Main extends Application {
	public void start(Stage primaryStage) {

		String fileName = "request.txt";
		GetRequest Request = new GetRequest(fileName);
		ArrayList<String[]> strs = Request.readFile();
		Request Request1 = new Request();
		enqueue(strs, Request1);// �������
		Agent_1 agent = new Agent_1(Request1);
		agent.Start();
		agent.SaveOutput();
		ArrayList<String> liftcommand = agent.getcommand();

		for(int i = 0 ;i<liftcommand.size();i++){
			System.out.println(liftcommand.get(i));
		}
		
		System.out.println("�������гɹ������ڹ���Ŀ¼�²鿴���output.txt");

		VBox button = new VBox(40);
		button.setAlignment(Pos.BOTTOM_RIGHT);

		Button btstart = new Button();
		Button btpause = new Button();
		Button btexit = new Button();
		btstart.setText("��ʼ");
		btpause.setText("��ͣ");
		btexit.setText("�˳�");

		button.getChildren().add(btstart);
		button.getChildren().add(btpause);
		button.getChildren().add(btexit);

		Dianti dianti = new Dianti();

		btstart.setOnAction(e -> dianti.run1(liftcommand));
		btpause.setOnAction(e -> dianti.pause());
		btexit.setOnAction(e -> System.exit(0));
		dianti.setCenter(button);

		Scene scene = new Scene(dianti, 800, 800);
		primaryStage.setTitle("����"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show();

		dianti.requestFocus();
	}

	public static void main(String[] args) {// ���������ۺϵ���
		Application.launch(args);
	}

	public static void enqueue(ArrayList<String[]> strs, Request request) {// ����õ����������ݺ�¥��
		for (int i = 0; i < strs.size(); i++) {// ����õ������ȷ���¥��������
			String[] str = strs.get(i);
			request.addRequest(str);
		}
	}

}
