


import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
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
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Start extends Application {
	private static int number = 0;
	
	public void start(Stage primaryStage){
		BorderPane pane1 = new BorderPane();
	    
		ImageView imageView = new ImageView("����԰.png");
	    Button welcome = new Button("Welcome!");
	    //Text newtext = new Text("��ӭ����������԰");
	   
	    pane1.setTop(imageView);
	    //pane.setCenter(newtext);
	    pane1.setBottom(welcome);
	    pane1.setAlignment(imageView, Pos.CENTER);
	    pane1.setAlignment(welcome, Pos.CENTER);
	   
	    Scene scene = new Scene(pane1, 1000, 700);
	    primaryStage.setTitle("Welcome"); 
	    primaryStage.setScene(scene); 
	    primaryStage.show();
	    
	    welcome.setOnAction(e ->{
	    	FlowPane pane2 = new FlowPane();
	        pane2.setPadding(new Insets(11, 12, 13, 14));
	        pane2.setHgap(5);//���ÿؼ�֮��Ĵ�ֱ�������
	        pane2.setVgap(5);//���ÿؼ�֮���ˮƽ�������
	    	Text t1 = new Text("          ��ӭ����������԰��Ʊ����");
	    	Text t2 = new Text("          ���Ƿ�Ϊ��Ա                                       ");
	    	//Text t3 = new Text("                                                     ");
	    	Button y= new Button("��");
	    	Button n = new Button("��");
	    	
	    	pane2.getChildren().add(t1);
	        pane2.getChildren().add(t2);
	        pane2.getChildren().add(y);
	 
	        pane2.getChildren().add(n);
	        Scene scene1 = new Scene(pane2, 500, 500);
	        primaryStage.setTitle("��ӭ"); 
	        primaryStage.setScene(scene1); 
	        primaryStage.show(); 
	        
	         y.setOnAction(e1 ->{ //��Ա����ID�͹�������
	      	GridPane pane3 = new GridPane();
	   		pane3.setAlignment(Pos.CENTER);
	   		pane3.setPadding(new Insets(11.5,12.5,13.5,14.5));
	   		pane3.setHgap(5.5);
	   		pane3.setVgap(5.5);
	   		pane3.add(new Label("��Ա��ţ�"),0,0);
	   		
	   		final TextField VIPID = new TextField();
	   		VIPID.setPromptText("��Ա��ţ�");
	   		pane3.add(VIPID, 2, 0);
	   		pane3.add(new Label("��Ʊ������"),0,1);
	   		 ComboBox<Integer> cbo = new ComboBox();
	   		 cbo.getItems().addAll(1,2,3,4);
	   		pane3.add(cbo, 2, 1);
	   		 Button button = new Button("ȷ��");
	   		pane3.add(button, 2, 3);
	        Scene vipscene = new Scene(pane3, 500, 500);
	        primaryStage.setTitle("��Ա��Ʊ����"); 
	        primaryStage.setScene(vipscene); 
	        primaryStage.show(); 
	       
	        button.setOnAction(e2 ->{
		    	GridPane  pane4 = new GridPane();
	    	     
	    	    Label me = new Label("�������Ʊ��Ϊ" + cbo.getValue() + "  һ����" + 120*cbo.getValue() + "Ԫ�������ڵ�Ԥ���Ϊ" + (1000 - 120*cbo.getValue()));
	    	    pane4.add(me, 0, 0);
	    	     
		    	 Button b1 = new Button("��Ʊ���");
		    	 pane4.add(b1, 0, 4);
		    	 b1.setOnAction(e3 ->{
		    		    Label [] tm = new Label[4];
		    		    tm[0] = new Label("9��00  Ѳ�α�������Ҫ��ʼ�ˣ����λ�ο;���");
		    		    tm[1] = new Label("9��10  Ѳ�α������Ͽ�ʼ�����Ƚ��еĿ��б���");
		    		    tm[2] = new Label("�����ܷ��ж��������ɣ�");
		    		    tm[3] = new Label("�������εĶ��������ɣ�");
		    		    GridPane  tpane = new GridPane();
		    		    tpane.add(tm[0], 0, 0);
		    		    tpane.add(tm[1], 0, 1);
		    		    tpane.add(tm[2], 0, 2);
		    		    Button b2 = new Button("����");
		    		    tpane.add(b2, 0, 3);
		    		    b2.setOnAction(e4 ->{
		    		    	//String[] flyName = {"airship.jpg","flyingMan.jpg","parrot.jpg","volador.jpg","goldenBrid.jpg"};
		    		    	String[] swimName = {"airship.jpg","flyingMan.jpg","volador.jpg","goldenBird.jpg","clownFish.jpg","crocodile.jpg","dolphin.jpg","shark.jpg","timg (7).jpg","seaLion.jpg","seaLion.jpg","mermaid.jpg"};
		    		    	//ImageView[] imageView1 = new ImageView[4];
		    		    	ImageView[] imageView2 = new ImageView[12];
		    		    	
		    		    	//imageView1[0] = new ImageView("airship.jpg");
		    		    	//imageView1[1] = new ImageView("flyingMan.jpg");
		    		    	//imageView1[2] = new ImageView("volador.jpg");
		    		    //imageView1[3] = new ImageView("goldenBird.jpg");
		    		    	
		    		    	//fly(primaryStage,imageView1);
		    		    	
		    		    	for (int i = 0;i < imageView2.length;i ++){
		    		    		imageView2[i] = new ImageView(swimName[i]);
		    		    	}
		    		    	swim(primaryStage,imageView2);
		    		    	
		    		    });
		    		    Scene tscene = new Scene(tpane, 500, 500);
		                primaryStage.setTitle("aaaa"); 
		                primaryStage.setScene(tscene); 
		                primaryStage.show();
		    		 });
	             
	             Scene scene2 = new Scene(pane4, 500, 500);
	             primaryStage.setTitle("Ѳ�Σ�"); 
	             primaryStage.setScene(scene2); 
	             primaryStage.show(); 
	             
	        });
	        });
	    });
	}
	

	 
	 public void swim(Stage primaryStage,ImageView[] image) {
		 Pane movepane = new Pane();
		
		 PathTransition  pt = new PathTransition();
		 movepane.getChildren().add(image[number]);
		 PathTransition  pt1 = new PathTransition(Duration.millis(2000),new Line(-200,350,1500,350),image[number]);
		 pt1.setCycleCount(1);
		 pt1.play();
		 pt1.statusProperty().addListener(e ->{
			 number ++;
			 if(number<image.length){
				 swim(primaryStage,image);
			 }
		 });
		 Scene scene2 = new Scene(movepane, 800, 750); 
		 primaryStage.setTitle("������Ӿ����"); 
        primaryStage.setScene(scene2); 
        primaryStage.show();
	}
	 
	
	public static void main(String[] args){
		launch(args);
	}

}
