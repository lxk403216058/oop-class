package Experiment2;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;


public class FileIn {
	private String fileName;
	
	public FileIn(){
		
	}
	
	public FileIn(String fileName){
		this.fileName = fileName;
	}
	
	public void fileIn(SalesRecord[] salesRecord){
		try {
			Writer writer = new FileWriter(fileName);
			BufferedWriter bw = new BufferedWriter(writer);
			for (int i = 0;i < salesRecord.length;i ++){
			    bw.write(salesRecord[i].getRecord()+" "+salesRecord[i].getGoods().getGoodsName()+" " +salesRecord[i].getGoods().getUnitprice()
			    		+" "+salesRecord[i].getGoods().getBarCode()+" " + salesRecord[i].getAmount() +" " +salesRecord[i].getFare()+"\r\n");
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
