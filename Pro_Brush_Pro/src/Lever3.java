
public class Lever3 extends LeverState{

	Lever3(){
		pos = 3;
	}
	@Override
	public void uppos() {
	    pos++;
		
	}

	@Override
	public void downpos() {
		pos--;
		
	}
}
