//互动类
public class Interaction {
	private String name;
	private int time;
	private int num;
	
	public Interaction(){
		
	}
	
	public Interaction(String name){
		this.name = name;
		setNum();
		setTime();
		
	}
	
	public String getName(){
		return name;
	}
	
	public int getTime(){
		return time;
	}
	
	public int getNum(){
		return num;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setTime(){
		this.time = (int)(Math.random() * 5 + 1);
	}
	
	public void setNum(){
		this.num = (int)(Math.random() * 5 + 1);
	}
	
	public String toString(){
		return "现在我们征选" + num + "名幸运观众" + name;
	}

}

