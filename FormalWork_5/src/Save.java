import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Save {
	private String fileName;
	private String str;
	
	public Save(){//无参构造
		
	}
	
	public Save(String fileName, String str){//有参构造
		this.fileName = fileName;
		this.str = str;
	}
	
	public void save() {// 存储传入的字符串到指定文件
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
