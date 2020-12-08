
public class Dial {
	private DialState state;
	
	public Dial(){
		state = new Dial1();
	}
	
	public void setstate(){
		switch(getpos()){
		case 1:
			state = new Dial1();
			break;
		case 2:
			state = new Dial2();
			break;
		case 3:
			state = new Dial3();
			break;
		}
	}
	
	public DialState getstate(){
		return state;
	}
	
	public int getpos(){
		return state.getpos();
	}

}

