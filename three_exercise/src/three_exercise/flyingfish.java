package three_exercise;

public class flyingfish extends fish{


	public flyingfish() {
		super("ٻٻ", 1, "����", 3,new trainer("xuxu"));
		// TODO Auto-generated constructor stub
		type = "����";
		this.number = 3+ numberRange;
		getperform();
		getInteract();
	}

	private void getInteract() {
		// TODO Auto-generated method stub
		interact[0] = new Interact("����ιʳ", 3, rand.nextInt(5)+5);
		interact[1] = new Interact("������ˮ", 3, rand.nextInt(5)+5);
	}

	private void getperform() {
		// TODO Auto-generated method stub
		perform[0] = new perform("��ˮ", rand.nextInt(10)+5);
		perform[1] = new perform("����ɸ�", rand.nextInt(10)+5);
	}

}
