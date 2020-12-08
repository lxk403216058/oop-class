package Brush_Pro;

public class Lever5 extends Lever{
	private int pos;
	
    public Lever5(){
		
	}
	
	public Lever5(int pos){
		this.pos = pos;
	}
	
	public int getPos(){
		return pos;
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
