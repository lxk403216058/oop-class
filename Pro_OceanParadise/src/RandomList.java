
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

public class RandomList {
	private ArrayList<String> l = new ArrayList<String>();
	private String[] str = {"show prepare","entrance start","entrance end","10000 start","10001 start","10002 start",
			"20000 start","20001 start","20002 start","30000 start","30001 start"};
	private String fileName = "playbill.txt";
	
	public RandomList(){
		
	}
	
	public void add(){
		for (int i = 0;i < str.length;i ++){
			l.add(str[i]);
		}
	}
	
	public void ListIn(){
		add();
		try {
			Writer writer = new FileWriter(fileName, true);
			BufferedWriter bw = new BufferedWriter(writer);
			
			for (int i = 0;i < 3;i ++){
				bw.write(l.get(0) + "\r\n");
				l.remove(0);
			}
			
			int m = l.size();
			for (int i = 0;i < m;i ++){
				if (!l.isEmpty()){
					int j = (int)(Math.random()*l.size());
					bw.write(l.get(j) + "\r\n");
					l.remove(j); 
				}
			}
			bw.write("show end");

			bw.close();
			writer.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
