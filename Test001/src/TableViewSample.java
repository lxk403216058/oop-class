

import java.util.ArrayList;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
 
public class TableViewSample extends Application {
 
    private final TableView<Person> table = new TableView<>();
   
   
    public static void main(String[] args) {
        launch(args);
    }
 
    @Override
    public void start(Stage stage) {
    	Person p =  new Person("22222"," 22222"," 救护解 ","男"," 362202199808039489" ,"2009/09/09"," 10"," 蓝桥杯");
    	
    	ArrayList<Person> ap = new ArrayList<>();
    	
    	ap.add(p);
    	
    	ObservableList<Person> data =
    		        FXCollections.observableArrayList(
    		           ap
    		        );
    	
    	
        
        BorderPane bPane = new BorderPane();
        bPane.setStyle("-fx-background-color:AQUAMARINE");
 
        final Label label = new Label("已报名人员信息");
        label.setFont(new Font("Arial", 20));
 
        table.setEditable(true);
 
        TableColumn accountCol = new TableColumn("账号");
        accountCol.setMinWidth(60);
        accountCol.setCellValueFactory(
                new PropertyValueFactory<>("account"));
 
        TableColumn passwordCol = new TableColumn("密码");
        passwordCol.setMinWidth(60);
        passwordCol.setCellValueFactory(
                new PropertyValueFactory<>("password"));
 
        TableColumn nameCol = new TableColumn("姓名");
        nameCol.setMinWidth(50);
        nameCol.setCellValueFactory(
                new PropertyValueFactory<>("name"));
        
        TableColumn sexCol = new TableColumn("性别");
        sexCol.setMinWidth(30);
        sexCol.setCellValueFactory(
                new PropertyValueFactory<>("sex"));
        
        TableColumn numCol = new TableColumn("身份证号");
        numCol.setMinWidth(200);
        numCol.setCellValueFactory(
                new PropertyValueFactory<>("num"));
        
        TableColumn brithdayCol = new TableColumn("生日");
        brithdayCol.setMinWidth(100);
        brithdayCol.setCellValueFactory(
                new PropertyValueFactory<>("brithday"));
        
        TableColumn ageCol = new TableColumn("年龄");
        ageCol.setMinWidth(30);
        ageCol.setCellValueFactory(
                new PropertyValueFactory<>("age"));
        
        TableColumn Col = new TableColumn("报名的活动");
        Col.setMinWidth(50);
        Col.setCellValueFactory(
                new PropertyValueFactory<>("col"));
 
        table.setItems(data);
        table.getColumns().addAll(accountCol, passwordCol, nameCol,sexCol,numCol,brithdayCol,ageCol,Col);
 
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table);
        
        bPane.setTop(vbox);
        
        Label l = new Label("输入你要删除人所在的行数：");
        TextField tf = new TextField();
        HBox hbox = new HBox();
        
        hbox.setPadding(new Insets(0,30,30,0));
        
        hbox.getChildren().addAll(l,tf);
        bPane.setBottom(hbox);
        
        
 
        //((Group) scene.getRoot()).getChildren().addAll(vbox);
        Scene scene = new Scene(bPane , 710, 599);
        stage.setTitle("");
        stage.setScene(scene);
        stage.show();
    }
 
    public static class Person {
 
        private final SimpleStringProperty account;
        private final SimpleStringProperty password;
        private final SimpleStringProperty name;
        private final SimpleStringProperty sex;
        private final SimpleStringProperty num;
        private final SimpleStringProperty brithday;
        private final SimpleStringProperty age;
        private final SimpleStringProperty col;
 
        private Person(String fName, String lName, String eName,String sName,String nName,String bName,String aName,String cName) {
            this.account = new SimpleStringProperty(fName);
            this.password = new SimpleStringProperty(lName);
            this.name = new SimpleStringProperty(eName);
            this.sex = new SimpleStringProperty(sName);
            this.num = new SimpleStringProperty(nName);
            this.brithday = new SimpleStringProperty(bName);
            this.age = new SimpleStringProperty(aName);
            this.col = new SimpleStringProperty(cName);
        }
 
        public String getAccount() {
            return account.get();
        }
 
        public void setAccount(String fName) {
            account.set(fName);
        }
 
        public String getPassword() {
            return password.get();
        }
 
        public void setLastName(String fName) {
            password.set(fName);
        }
 
        public String getName() {
            return name.get();
        }
 
        public void setEmail(String fName) {
            name.set(fName);
        }
        
        public String getSex() {
            return sex.get();
        }
 
        public void setSex(String fName) {
            sex.set(fName);
        }
        
        public String getNum() {
            return num.get();
        }
 
        public void setNum(String fName) {
        	num.set(fName);
        }
       
        public String getBrithday() {
            return brithday.get();
        }
        
        public void setBrithday(String fName) {
            brithday.set(fName);
        }
        
        public String getAge() {
            return age.get();
        }
        
        public void setAge(String fName) {
            age.set(fName);
        }
        
        public String getCol() {
            return col.get();
        }
        
        public void setCol(String fName) {
            col.set(fName);
        }
        
    }
} 

