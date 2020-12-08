//±Ì—›¿‡
public class Performence {
	private String PerName;
	private int time = 0;
	
	public Performence(){
		
	}
	
	public Performence(String PerName){
		this.PerName = PerName;
		setTime();
	}
	
	public String getPerName(){
		return PerName;
	}
	
	public int getTime(){
		return time;
	}
	
	public void setPerName(String PerName){
		this.PerName = PerName;
	}
	
	public void setTime(){
		this.time = (int)(Math.random() * 5 + 1);
	}
	
	public String toString(){
		return "±Ì—›" + PerName;
	}

}
