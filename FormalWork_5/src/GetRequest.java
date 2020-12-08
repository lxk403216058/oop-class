import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GetRequest {
	private String fileName;
	private ArrayList<String[]> str = new ArrayList<String[]>();

	public GetRequest() {//无参构造

	}

	public GetRequest(String fileName) {//有参构造
		this.fileName = fileName;
	}

	public ArrayList<String[]> readFile() {//从给定文件中按行读取出请求保存于字符串数组arraylist中
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String temp = "";
			while ((temp = br.readLine()) != null) {
				String[] strs = temp.trim().split(",");
				for(int i = 0;i<strs.length;i++){
					strs[i]=strs[i].replace(" ", "");
				}
				str.add(strs);
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}
}
