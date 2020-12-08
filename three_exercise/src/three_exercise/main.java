package three_exercise;
import java.io.*;
import java.util.*;
public class main {
	public static void main(String[] args){
		Random rand = new Random();   
		Scanner input = new Scanner(System.in);
		File file = new File();
		Mytime time = new Mytime();       //时间对象
		mermaid mer = new mermaid(18,"jojo",1);
	climb[] climb={new crocodile(),new lizard()};  //动物对象数组
	lactation[] lac={new dolphin(),new seal(),new sealion()};
	fish[] fish={new flyingfish(),new shark(),new uglyfish()};
	file.openWrite("input.txt");
	file.output("show prepare");
	file.output("enterance start");
	for (int i=0;i<3;i++){
		file.output(fish[i].number+"start");
	}
	for (int i=0;i<3;i++){
		file.output(lac[i].number+"start");
	}
	for (int i=0;i<2;i++){
		file.output(climb[i].number+"start");
	}
	file.output(mer.number+"ready");
	file.openRead("input.txt");
	file.openWrite("ouput.txt");
	for (int i=0;i<3;i++){
		file.output(fish[i].toString(time));
	}
	for (int i=0;i<3;i++){
		file.output(lac[i].toString(time));
	}
	for (int i=0;i<2;i++){
		file.output(climb[i].toString(time));
	}
}
}
