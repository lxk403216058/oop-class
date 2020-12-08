import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Save {
	private String fileName;
	private String str;
	
	public Save(){//�޲ι���
		
	}
	
	public Save(String fileName, String str){//�вι���
		this.fileName = fileName;
		this.str = str;
	}
	
	public void save() {// �洢������ַ�����ָ���ļ�
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(fileName));

			out.write(str);
			out.newLine();
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
