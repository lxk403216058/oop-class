
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

public class PlaybillIn {
	private String fileName = "playbill.txt";
	private ArrayList<String> expression = new ArrayList<String>();
	
	
	public ArrayList<String> getExpression() {
		return expression;
	}

	// 将数据重文件中读入
	public void dataIn() {
		try {
			Reader reader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(reader);

			String string = null;

			while ((string = bufferedReader.readLine()) != null) {
				//System.out.println(string);
				expression.add(string);
				// System.out.println(string);
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
