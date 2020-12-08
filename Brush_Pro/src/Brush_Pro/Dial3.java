package Brush_Pro;

public class Dial3 implements Dial{
	private int pos = 1;
	
	public Dial3(){
		
	}
	
	public Dial3(int pos){
		this.pos = pos;		
	}
	
	public int getPos(){
		return this.pos;
	}
	
	public void upPos(){
		if(this.pos < 3){
			this.pos ++;
		}
	}
	
	public void downPos(){
		if(this.pos > 1){
			this.pos --;
		}
	}

}
