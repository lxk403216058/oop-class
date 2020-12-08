
public class NewLever 
    extends AbstractLever{
	private int pos;
	
    public NewLever(){
		
	}
	
	public NewLever(int pos){
		this.pos = pos;
	}
	
	@Override
	public int getPos(){
		return pos;
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
