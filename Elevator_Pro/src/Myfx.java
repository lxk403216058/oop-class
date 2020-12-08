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
		ArrayList<Integer> positionE = new ArrayList<Integer>();// 储存格式错误指令的位置
		ArrayList<Integer> positionR = new ArrayList<Integer>();// 储存指令时序错误的位置
		ArrayList<String> message = new ArrayList<String>();// 存储错误信息
		r.dataIn();
		Check c = new Check();
		Request req = new Request();

		if (!r.getExpression().get(r.getExpression().size() - 1).equals("RUN")) {// 如果最后一个指令不是RUN则程序退出
			//System.out.println("gg");
			System.exit(0);
		}
		r.getExpression().remove(r.getExpression().size()-1);

		for (int i = 0; i < r.getExpression().size() - 1; i++) {
			if (!c.check(r.getExpression().get(i))) {// 对指令进行格式判断并储存所在位置
				r.getExpression().remove(i);
				message.add(c.toString());
				positionE.add(i);
				i--;
			}
		}

		for (int i = 0; i < r.getExpression().size(); i++) {
			if (!req.checkRepeat(r.getExpression().get(i))) {// 对格式正确但时间不正确德指令进行判断并记住位置
				positionR.add(i);
			}
		}

		Queue q = new Queue();
		for (int i = 0; i < req.getStr().size(); i++) {// 将所有正确指令入队
			String[] s = req.getStr().get(0).split(",");
			String s1 = s[s.length - 1].replace(")", "");
			if (s1 == "0") {
				System.exit(0);
			}
			q.add(req.getStr().get(i));
		}
		NewDispatcher d = new NewDispatcher();
		d.dealRequest(q);;// 计算所有指令时间并输出
		FileIn f = new FileIn(fileName2);
		int n = 0;

		for (int i = 0; i < r.getExpression().size(); i++) {
			int flag = 0;
			for (int j = 0; j < positionE.size(); j++) {
				if (positionE.get(j) == i) {// 输出错误格式的指令
					f.dataOut(message.get(j));
					flag = 1;
					break;
				}
			}

			for (int j = 0; j < positionR.size(); j++) {
				if (positionR.get(j) == i) {// 输出对指令格式正确但时间不正确的错误指令
					flag = 1;
					break;
				}
			}
			if (flag == 0) {// 输出正确内容
				f.dataOut(d.getMessage().get(n++));
			}
		}
		float average = d.getPassager().getSumTime()/d.getPassager().getNumber();
		f.dataOut("乘客的平均等待时间：" + average);
		
		
		
		
		VBox vBox = new VBox(15);
		vBox.setPadding(new Insets(200,50,0,0));
		
		Text t1 = new Text(600,100,"当前电梯人数:");
		t1.setFont(Font.font("宋体",FontWeight.BOLD,FontPosture.ITALIC,20));
		
		
		
		Button b1 = new Button("开始");
		Button b2 = new Button("暂停");
		Button b3 = new Button("退出");
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
