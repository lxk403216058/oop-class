package Test2;

public class Time {
	private static float time = 0;
	
	public Time(){
		
	}
	
	public float getTime(){
		return time;
	}
	
	public void setTime(float t){
		time = t;
	}
	
	public void runTime(){
		time = (float)(time + 0.5);
	}
	
	public void ocTime(){
		time = time + 1;
	}

}
