
public class Lever2 extends LeverState{

	Lever2(){
		pos = 2;
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
