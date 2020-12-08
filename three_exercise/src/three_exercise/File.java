package three_exercise;

//�����ļ���������
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintStream;
public class File {
		InputStream inputFile;//�ļ�����
		PrintStream outputFile;//�ļ����
		Scanner fileInput;
		public File(){//��Ĺ���
			inputFile = System.in;
			outputFile = System.out;
		}
		public boolean openRead(String filename){//���ļ��Ķ���
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
		public boolean openWrite(String filename){// ���ļ������
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