
public class Dial2 extends DialState{
	public Dial2(){
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