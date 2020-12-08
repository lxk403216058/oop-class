package Elevator;

public class Lift {
	private String type = "STILL";
	private int button;
	private static int floor = 1;
	private float t;
	private Time T;

	public Lift() {

	}

	public Lift(int button, float t) {
		this.button = button;
		this.t = t;
	}

	public String getType() {
		if (button > floor){
			type = "UP";
		}
		else if(button < floor){
			type = "DOWN";
		}else{
			type = "STILL";
		}
			
		return type;
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

	public int getDiffence() {
		if (floor > button) {
			return floor - button;
		}
		return button - floor;
	}
}
