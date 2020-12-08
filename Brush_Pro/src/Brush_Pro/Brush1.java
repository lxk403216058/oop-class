package Brush_Pro;

public class Brush1 extends Brush{
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
			}
			break;
		case 3:
			setSpeed(30);
			break;
		case 4:
			setSpeed(60);
			break;		
		}
	}
	
	public int getSpeed(){
		return speed;
	}
	
	public void setSpeed(int speed){
		this.speed = speed;
	}

}
