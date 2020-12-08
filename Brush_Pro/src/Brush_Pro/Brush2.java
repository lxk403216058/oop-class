package Brush_Pro;

public class Brush2 extends Brush{
	private int speed;
	
	public void dealSpeed(Lever l,Dial d){
		switch(l.getPos()){
		case 1:
			setSpeed(0);
			break;
		case 2:
			switch(d.getPos()){
			case 1:
				setSpeed(4);
				break;
			case 2:
				setSpeed(6);
				break;
			case 3:
				setSpeed(12);
				break;
			case 4:
				setSpeed(18);
				break;
			case 5:
				setSpeed(25);
				break;
			}
			break;
		case 3:
			setSpeed(30);
			break;
		case 4:
			setSpeed(60);
			break;	
		case 5:
			setSpeed(90);
			break;
		}
	}
	
	public void setSpeed(int speed){
		this.speed = speed;
	}
	
	public int getSpeed(){
		return speed;
	}

}
