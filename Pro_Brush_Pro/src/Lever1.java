
public class Lever1 extends LeverState{

	Lever1(){
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
