package Brush_Pro;

public class Dial5 implements Dial{
	private int pos = 1;
	
	public Dial5(){
		
	}
	
	public Dial5(int pos){
		this.pos = pos;		
	}
	
	public int getPos(){
		return this.pos;
	}
	
	public void upPos(){
		if(this.pos < 5){
			this.pos ++;
		}
	}
	
	public void downPos(){
		if(this.pos > 1){
			this.pos --;
		}
	}
	

}
