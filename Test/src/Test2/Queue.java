package Test2;

import java.util.ArrayList;

public class Queue {
	private int size = 0;
	private ArrayList<String> f = new ArrayList<String>();
	
	public Queue(){
		
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public String getQueue(int i){
		return f.get(i);
	}
	
	public void remove(int i){
		f.remove(i);
	}
	
	public ArrayList<String> getF(){
		return f;
	}
	
	public void setF(ArrayList<String> f){
		this.f = f;
	}
	
	public void add(String str){
		f.add(str);
		size ++;
	}
	
	public void add(int index,String str){
		f.add(index, str);
		size ++;
	}
	
	public String poll(){
		if (isEmpty()){
			System.out.println("©у╤сап");
			return "";
		}
		String str = f.get(0);
		f.remove(0);
		size --;
		
		return str;
	}
	
	public int getSize(){
		return f.size();
	}

}