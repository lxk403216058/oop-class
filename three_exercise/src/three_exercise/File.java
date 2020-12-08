package three_exercise;

//用于文件操作的类
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintStream;
public class File {
		InputStream inputFile;//文件输入
		PrintStream outputFile;//文件输出
		Scanner fileInput;
		public File(){//类的构造
			inputFile = System.in;
			outputFile = System.out;
		}
		public boolean openRead(String filename){//打开文件的读入
			try{
				inputFile = new FileInputStream(filename);
//				outputFile = new PrintStream("output.txt");
				fileInput = new Scanner(inputFile);
				return true;
			}
			catch (Exception e){
				return false;
			}
		}
		public boolean openWrite(String filename){// 打开文件的输出
			try{
//				inputFile = new FileInputStream("input.txt");
				outputFile = new PrintStream(filename);
				return true;
			}
			catch (Exception e){
				return false;
			}
		}
		public void output(String s){
			outputFile.println(s);
		}
		public String input(){
//			Scanner fileInput = new Scanner(inputFile);
			if (fileInput.hasNext()){
				String k = fileInput.nextLine();
				return k;
			}
			else
			{
				return null;
			}
		}
		public boolean hasnext(){
			return fileInput.hasNext();
		}
}