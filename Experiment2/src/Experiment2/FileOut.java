package Experiment2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;


public class FileOut {
	private String fileName;// 传入的文件名
	
	public FileOut(){
		
	}
	
	public FileOut(String fileName){
		this.fileName = fileName;
	}
	
	public SalesRecord[] fileOut(){
		ArrayList<SalesRecord> s= new ArrayList<SalesRecord>();
		try {
			Reader reader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(reader);

			String str = null;

			while ((str = bufferedReader.readLine()) != null) {
				String[] sr = str.split(" ");
				float a = Float.parseFloat(sr[4]);
				String name = sr[1];
				int unit = Integer.parseInt(sr[2]);
				Goods goods  = new Goods(name,unit);
				SalesRecord s1 = new SalesRecord(goods,a);
				s.add(s1);
				// System.out.println(string);
			}
			bufferedReader.close();
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		SalesRecord[] salesRecord = new SalesRecord[s.size()];
		for (int j = 0;j < s.size();j++){
			salesRecord[j] = s.get(j);
		}
		return salesRecord;
	}

}
