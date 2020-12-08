
public class Lever4 extends LeverState{

	Lever4(){
		pos = 4;
	}
	@Override
	public void uppos() {
		System.out.println("已经是最高档，无法升�?");
		
	}

	@Override
	public void downpos() {
		pos--;
		
	}

}