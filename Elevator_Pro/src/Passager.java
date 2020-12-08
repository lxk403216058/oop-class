
public class Passager {
	private static float number;
	private int liftnum;
	private float waitingTime;
	private static float sumTime = 0; 
	private float averTime;
	
	public Passager(){
		
	}
	
	public void passagerIn(){
		number ++;
		liftnum ++;
	}
	
	public void passagerOut(){
		liftnum --;
	}
	
	public float getSumTime(){
		return sumTime;
	}
	
	public float getNumber(){
		return number;
	}
	
	public void getWaiting(float inTime,float outTime){
		this.waitingTime = outTime - inTime;
		sumTime += waitingTime; 
	}
	
	public void averageTime(){
		averTime = sumTime / (float)number;
	}
	
	public boolean overload(){
		return liftnum <= 13;
	}
	
	public float getWritingTime(){
		return waitingTime;
	}
	
	public float getAverTime(){
		return averTime;
	}

}
