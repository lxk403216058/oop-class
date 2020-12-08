
public class Bird {
	protected int score;
	
	public Bird(){
		
	}
	
	public void setScore(){
		this.score =(int)(Math.random()*10 + 1);
	}
	
	public int getScore(){
		return score;
	}

}
