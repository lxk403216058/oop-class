
public class Airship implements Fly {
	private int score;
	
	public Airship(){
		
	}
	
	public void setScore(){
		this.score =(int)(Math.random()*10 + 1);
	}
	
	public int getScore(){
		return score;
	}
	
	public String fly(){
		return "·ÉÍ§·É¹ý";
	}

}
