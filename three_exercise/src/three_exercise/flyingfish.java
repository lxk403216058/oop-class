package three_exercise;

public class flyingfish extends fish{


	public flyingfish() {
		super("ŸªŸª", 1, "¥∆–‘", 3,new trainer("xuxu"));
		// TODO Auto-generated constructor stub
		type = "∑…”„";
		this.number = 3+ numberRange;
		getperform();
		getInteract();
	}

	private void getInteract() {
		// TODO Auto-generated method stub
		interact[0] = new Interact("∑…”„Œπ ≥", 3, rand.nextInt(5)+5);
		interact[1] = new Interact("∑…”„”ŒÀÆ", 3, rand.nextInt(5)+5);
	}

	private void getperform() {
		// TODO Auto-generated method stub
		perform[0] = new perform("Õ¬ÀÆ", rand.nextInt(10)+5);
		perform[1] = new perform("∑…”„∑…∏À", rand.nextInt(10)+5);
	}

}
