
public class Dial1 extends DialState{
	public Dial1(){
		pos = 1;
	}
	@Override
	public void uppos() {
		pos++;
		
	}

	@Override
	public void downpos() {
		System.out.println("已经是最低档，无法降�?");
	}


}