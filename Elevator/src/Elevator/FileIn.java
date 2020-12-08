package Elevator;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class FileIn {
	private String fileName;// ������ļ���

	public FileIn() {

	}

	public FileIn(String fileName) {
		this.fileName = fileName;
	}

	// ����������ļ�
	public void dataOut(String str) {
		try {
			Writer writer = new FileWriter(fileName, true);
			BufferedWriter bw = new BufferedWriter(writer);

			bw.write(str + "\r\n");

			bw.close();
			writer.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
