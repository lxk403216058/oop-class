
public class FlyingMan implements Fly {
	private int score;
	
	public FlyingMan(){
		
	}
	
	public void setScore(){
		this.score =(int)(Math.random()*10 + 1);
	}
	
	public int getScore(){
		return score;
	}
	
	public String fly(){
		return "���˷ɹ�";
	}

}
