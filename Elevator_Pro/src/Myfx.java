import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Myfx extends Application {
	@Override
	public void start(Stage primaryStage){
		String fileName1 = "request.txt";
		String fileName2 = "result.txt";
		RequestIn r = new RequestIn(fileName1);
		ArrayList<Integer> positionE = new ArrayList<Integer>();// �����ʽ����ָ���λ��
		ArrayList<Integer> positionR = new ArrayList<Integer>();// ����ָ��ʱ������λ��
		ArrayList<String> message = new ArrayList<String>();// �洢������Ϣ
		r.dataIn();
		Check c = new Check();
		Request req = new Request();

		if (!r.getExpression().get(r.getExpression().size() - 1).equals("RUN")) {// ������һ��ָ���RUN������˳�
			//System.out.println("gg");
			System.exit(0);
		}
		r.getExpression().remove(r.getExpression().size()-1);

		for (int i = 0; i < r.getExpression().size() - 1; i++) {
			if (!c.check(r.getExpression().get(i))) {// ��ָ����и�ʽ�жϲ���������λ��
				r.getExpression().remove(i);
				message.add(c.toString());
				positionE.add(i);
				i--;
			}
		}

		for (int i = 0; i < r.getExpression().size(); i++) {
			if (!req.checkRepeat(r.getExpression().get(i))) {// �Ը�ʽ��ȷ��ʱ�䲻��ȷ��ָ������жϲ���סλ��
				positionR.add(i);
			}
		}

		Queue q = new Queue();
		for (int i = 0; i < req.getStr().size(); i++) {// ��������ȷָ�����
			String[] s = req.getStr().get(0).split(",");
			String s1 = s[s.length - 1].replace(")", "");
			if (s1 == "0") {
				System.exit(0);
			}
			q.add(req.getStr().get(i));
		}
		NewDispatcher d = new NewDispatcher();
		d.dealRequest(q);;// ��������ָ��ʱ�䲢���
		FileIn f = new FileIn(fileName2);
		int n = 0;

		for (int i = 0; i < r.getExpression().size(); i++) {
			int flag = 0;
			for (int j = 0; j < positionE.size(); j++) {
				if (positionE.get(j) == i) {// ��������ʽ��ָ��
					f.dataOut(message.get(j));
					flag = 1;
					break;
				}
			}

			for (int j = 0; j < positionR.size(); j++) {
				if (positionR.get(j) == i) {// �����ָ���ʽ��ȷ��ʱ�䲻��ȷ�Ĵ���ָ��
					flag = 1;
					break;
				}
			}
			if (flag == 0) {// �����ȷ����
				f.dataOut(d.getMessage().get(n++));
			}
		}
		float average = d.getPassager().getSumTime()/d.getPassager().getNumber();
		f.dataOut("�˿͵�ƽ���ȴ�ʱ�䣺" + average);
		
		
		
		
		VBox vBox = new VBox(15);
		vBox.setPadding(new Insets(200,50,0,0));
		
		Text t1 = new Text(600,100,"��ǰ��������:");
		t1.setFont(Font.font("����",FontWeight.BOLD,FontPosture.ITALIC,20));
		
		
		
		Button b1 = new Button("��ʼ");
		Button b2 = new Button("��ͣ");
		Button b3 = new Button("�˳�");
		LiftPane lift = new LiftPane();
		
		
		vBox.getChildren().add(b1);
		vBox.getChildren().add(b2);
		vBox.getChildren().add(b3);
		lift.setRight(vBox);
		lift.getChildren().add(t1);
		
		
		b1.setOnAction(e ->{
			lift.run1(d.getType(), d.getFloor(), d.getFlag());
		});
		
		b2.setOnAction(e ->{
			lift.pause();
		});
		
		b3.setOnAction(e ->{
			System.exit(0);
		});
		
		Scene scene = new Scene(lift, 800, 500);
	    primaryStage.setTitle("Lift"); // Set the stage title
	    primaryStage.setScene(scene); // Place the scene in the stage
	    primaryStage.show(); // Display the stage
	}
	
	public static void main(String[] args){
		launch(args);
	}

}
