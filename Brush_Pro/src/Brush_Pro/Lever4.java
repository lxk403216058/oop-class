package Brush_Pro;

public class Lever4 extends Lever{
	private int pos;
	
	public Lever4(){
		
	}
	
	public Lever4(int pos){
		this.pos = pos;
	}
	
	public int getPos(){
		return pos;
	}
	
	public void upPos(){
		if(this.pos < 4){
			this.pos ++;
		}
	}
	
	public void downPos(){
		if(this.pos > 1){
			this.pos --;
		}
	}

}
