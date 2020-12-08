package Test2;

import java.util.ArrayList;

public class Passager {
	private static int number;
	private int liftnum;
	private float waitingTime;
	private static float sumTime; 
	private float averTime;
	private static ArrayList<Float> w = new ArrayList<Float>();
	
	public Passager(){
		
	}
	
	public void passagerIn(){
		number ++;
		liftnum ++;
	}
	
	public void passagerOut(){
		liftnum --;
	}
	
	public void getWaiting(float inTime,float outTime){
		this.waitingTime = outTime - inTime;
		sumTime += waitingTime; 
		w.add(waitingTime);
	}
	
	public void averageTime(){
		averTime = sumTime / number;
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
