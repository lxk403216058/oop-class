package Elevator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

public class RequestIn {
	private String fileName;// ������ļ���
	private ArrayList<String> expression = new ArrayList<String>();

	public ArrayList<String> getExpression() {
		return expression;
	}

	public RequestIn(String fileName) {
		this.fileName = fileName;
	}

	// ���ļ��е�ָ�����
	public void dataIn() {
		try {
			Reader reader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(reader);
			String string = null;

			while ((string = bufferedReader.readLine()) != null) {

				expression.add(string.replace(" ", ""));

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
