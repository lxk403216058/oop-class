package ClassWork2;

public class ClassWork9_8 {
	public static void main(String[] args) {
		Fan f1,f2;
		final int SLOW=1,MEDIUM=2,FAST=3;
		
		f1 = new Fan();
		f1.setData(FAST,true,10,"yellow");
		System.out.println(f1.toString());
		f2 = new Fan();
		f2.setData(MEDIUM, false, 5, "blue");
		System.out.println(f2.toString());
	}

}

class Fan{
	
	final int SLOW=1,MEDIUM=2,FAST=3;
	private int speed=SLOW;
	private boolean on=false;
	private  double radius=5;
	String color="blue";
	
	public void setData(int speed,boolean on,double radius,String color) {
		this.speed=speed;
		this.on=on;
		this.radius=radius;
		this.color=color;
	}
	
	
	//public void getData(int speed,boolean on,double radius,String color) {}
	
	public int getSpeed(int speed) {
		return speed;
	}
	
	public boolean getOn(boolean On) {
		return on;
	}
	
	public double getRadius(double radius) {
		return radius;
	}
	
	public String getColor(String color) {
		return color;
	}
	
	public Fan() {
	}
	
public String toString(){
	if (on==true)
		return "Fan's speed is "+speed+" ,color is "+color+" ,radius is "+radius;
	return "Fan is off , fan's color is "+color+" , radius is "+radius;
}
}