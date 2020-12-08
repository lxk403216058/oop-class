package Elevator;

public class Floor {
	private int floor = 1;
	private static int perFloor = 1;
	private String button = "UP";
	private float time;
	private Time T;

	public Floor() {

	}

	public Floor(int floor, String button, float time) {
		this.floor = floor;
		this.button = button;
		this.time = time;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public int getFloor() {
		return floor;
	}

	public String getButton() {
		return button;
	}

	public void setButton(String button) {
		this.button = button;
	}

	public float getTime() {
		return time;
	}

	public void setT() {
		T.setTime(time);
	}

	public int getDiffence() {
		if (perFloor > floor) {
			return perFloor - floor;
		}
		return floor - perFloor;
	}

	public void setTime(float time) {
		this.time = time;
	}

	public void setPerFloor(int floor) {
		perFloor = floor;
	}

}
