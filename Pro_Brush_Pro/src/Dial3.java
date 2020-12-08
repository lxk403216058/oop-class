
public class Dial3 extends DialState{
	public Dial3(){
		pos = 3;
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