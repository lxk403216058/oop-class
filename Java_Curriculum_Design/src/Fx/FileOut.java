package Fx;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

//�����ݴ��ļ�����
public class FileOut {

	// private String fileName;// ������ļ���
	private ArrayList<String> expression = new ArrayList<String>();

	public ArrayList<String> getExpression() {
		return expression;
	}

	public FileOut() {
		// this.fileName = fileName;
	}

	// ���ļ��е�ָ�����
	public void dataIn(String fileName) {
		try {
			Reader reader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(reader);
			String string = null;

			while ((string = bufferedReader.readLine()) != null) {

				expression.add(string);

			}
			bufferedReader.close();
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
