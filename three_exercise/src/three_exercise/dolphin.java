package three_exercise;

public class dolphin extends lactation{
	public dolphin() {
		super("笑笑",3,"雄性",1,new trainer("didi"));
		// TODO Auto-generated constructor stub
		type = "海豚";
		this.number = 3 + numberRange;
		getperform();
		getInteract();
	}

	private void getInteract() {
		// TODO Auto-generated method stub
		interact[0] = new Interact("海豚喂食", 3, rand.nextInt(5)+5);
		interact[1] = new Interact("海豚游水", 3, rand.nextInt(5)+5);
	}

	private void getperform() {
		// TODO Auto-generated method stub
		perform[0] = new perform("海豚吐水", rand.nextInt(10)+5);
		perform[1] = new perform("海豚亲亲", rand.nextInt(10)+5);
	}

}