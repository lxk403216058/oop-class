
public class NewDial 
    extends AbstractDial{
	private int pos;
	
	public NewDial(){
		
	}
	
	public NewDial(int pos){
		this.pos = pos;		
	}
	
	@Override
	public int getPos(){
		return this.pos;
	}
	
	@Override
	public void upPos(){
		if(this.pos < 5){
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
