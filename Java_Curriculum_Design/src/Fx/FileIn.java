package Fx;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

//���������ļ���
public class FileIn {

	public FileIn() {

	}

	public FileIn(String fileName) {
		// this.fileName = fileName;
	}

	// �����������ļ�(׷����)
	public void fileIn(String str, String fileName) {
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

	// ����������ļ�(������)
	public void filein(String str, String fileName) {
		try {
			Writer writer = new FileWriter(fileName);
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

	public void fileIN(ArrayList<String> str, String fileName) {
		try {
			Writer writer = new FileWriter(fileName);
			BufferedWriter bw = new BufferedWriter(writer);

			for (int i = 0; i < str.size(); i++) {
				bw.write(str.get(i) + "\r\n");
			}

			bw.close();
			writer.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
