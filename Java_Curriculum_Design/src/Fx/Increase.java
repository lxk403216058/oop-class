package Fx;

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

//普通用户增加界面
public class Increase extends GridPane {
	private FileIn fi = new FileIn();
	
	public Increase(Stage primaryStage , Scene s){
		set(primaryStage,s);
	}
	
	public void set(Stage primaryStage,Scene scene1){
		this.setAlignment(Pos.CENTER);
		this.setPadding(new Insets(20,12.5,13.5,14.5));
    	this.setHgap(5);
		this.setVgap(30);
		
		this.add(new Label("账号："), 0, 0);
   		TextField account =new TextField();
   		this.add(account, 1, 0);
   		
   		this.add(new Label("密码："), 0, 1);
   		TextField password =new TextField();
   		this.add(password, 1, 1);
		
		this.add(new Label("姓名："), 0, 2);
   		TextField name =new TextField();
   		this.add(name, 1, 2);
   		
   		this.add(new Label("性别："), 0, 3);
   		TextField sex =new TextField();
   		this.add(sex, 1, 3);
   		
   		this.add(new Label("年龄："), 0, 4);
   		TextField age =new TextField();
   		this.add(age, 1, 4);
   		
   		this.add(new Label("出生日期："), 0, 5);
   		TextField birthday =new TextField();
   		this.add(birthday, 1, 5);
   		
   		this.add(new Label("身份证号："), 0, 6);
   		TextField num =new TextField();
   		this.add(num, 1, 6);
   		
   		this.add(new Label("参加活动"), 0, 7);
   		TextField acivity = new TextField();
   		this.add(acivity, 1, 7);
   		
   		//确定按钮
   		Button b4 = new Button("确定");
   		this.add(b4, 1, 8);
   		b4.setMaxSize(200, 200);
		b4.setStyle("-fx-background-color:YELLOWGREEN");
   		
		//返回按钮
   		Button b5 = new Button("返回");
   		this.add(b5, 1, 9);
   		b5.setMaxSize(200, 200);
		b5.setStyle("-fx-background-color:YELLOWGREEN");
		
		this.setStyle("-fx-background-color:AQUAMARINE"); 
		
		b4.setOnAction(e -> {
			String information ="\r\n"+ account.getText() +" " + password.getText() + " "
		       		+ name.getText() + " " + sex.getText() + " " + num.getText() + " " + birthday.getText() 
		       		+ " "+ age.getText() + " " + acivity.getText();
		       			fi.fileIn(information, "SimpleUserInformation.txt");
		     
		       			
		    String str = account.getText() + " " + password.getText();
		    fi.fileIn(str, "SimpleUserAccount.txt");
		       			Alert alert = new Alert(AlertType.INFORMATION,"增加成功！");
		       			alert.show();
		});
		
		b5.setOnAction(e -> { 
			primaryStage.setTitle("通用报名系统"); 
			primaryStage.setScene(scene1); 
			primaryStage.show();
		});
	}

}
