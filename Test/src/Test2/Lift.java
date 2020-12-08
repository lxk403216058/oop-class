package Test2;

public class Lift implements Lift_sport {
	private String type = "STILL";
	private int button;
	private int floor = 1;
	private float t;
	private Time T;

	public Lift() {

	}

	public Lift(int button, float t) {
		this.button = button;
		this.t = t;
	}
	
	public int LiftDown(){
		floor --;
		return floor;
	}
	
	public int LiftUp(){
		floor ++;
		return floor;
	}

	public String getType() {
		return type;
	}
	
	public void setType(String type){
		this.type = type;
	}

	public int getButton() {
		return button;
	}

	public void setButton(int button) {
		this.button = button;
	}

	public float getT() {
		return t;
	}

	public void setT() {
		T.setTime(t);
	}

	public void setFloor(int f) {
		floor = f;
	}
	
	public int getFloor(){
		return floor;
	}
	
	public int getDiffence(){
		return Math.abs(button- floor);
	}
}
