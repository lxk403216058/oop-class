package three_exercise;

public class sealion extends lactation{
	public sealion() {
		super("蛋糕",2,"雌性",3,new trainer("xixi"));
		// TODO Auto-generated constructor stub
		type = "海师";
		this.number = 1+ numberRange;
		getperform();
		getInteract();
	}

	private void getInteract() {
		// TODO Auto-generated method stub
		interact[0] = new Interact("海师喂食", 3, rand.nextInt(5)+5);
		interact[1] = new Interact("海师游水", 3, rand.nextInt(5)+5);
	}

	private void getperform() {
		// TODO Auto-generated method stub
		perform[0] = new perform("海狮吐水", rand.nextInt(10)+5);
		perform[1] = new perform("海狮亲亲", rand.nextInt(10)+5);
	}

}