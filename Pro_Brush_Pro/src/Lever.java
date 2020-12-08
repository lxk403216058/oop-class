
public class Lever {
	private LeverState state;
	
	public Lever(){
		state = new Lever1();
	}
	public void setstate(){
		switch(getpos()){
		case 1:
			state = new Lever1();
			break;
		case 2:
			state = new Lever2();
			break;
		case 3:
			state = new Lever3();
			break;
		case 4:
			state = new Lever4();
			break;
		}
	}
	public LeverState getstate(){
		return state;
	}
	public int getpos(){
		return state.getpos();
	}

}