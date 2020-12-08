
public class Dial 
    extends AbstractDial{
	private int pos;
	
	public Dial(){
		
	}
	
	public Dial(int pos){
		this.pos = pos;		
	}
	
	@Override
	public int getPos(){
		return this.pos;
	}
	
	@Override
	public void upPos(){
		if(this.pos < 3){
			this.pos ++;
		}
	}
	
	@Override
	public void downPos(){
		if(this.pos > 1){
			this.pos --;
		}
	}

}
