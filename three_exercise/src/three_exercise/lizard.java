package three_exercise;

public class lizard extends climb{
	
	public lizard() {
		super("ʱʱ", 2, "����", 3,new trainer("meimei"));
		// TODO �Զ����ɵĹ��캯�����
		type = "����";
		this.number = 2 + numberRange;
		getPerformance();
		getInteraction();
	}
	
	public void getPerformance() {
		perform[0] = new perform("����ιʳ", rand.nextInt(10)+5);
		perform[1] = new perform("��������", rand.nextInt(10)+5);
	}
	
	public void getInteraction() {
		interact[0] = new Interact("����תȦ", 5, rand.nextInt(5)+5);
		interact[1] = new Interact("��������", 4, rand.nextInt(5)+5);
	}

}   

