package three_exercise;

public class crocodile extends climb {
	public crocodile() {
		super("���",2,"����",3,new trainer("jiejie"));
		// TODO �Զ����ɵĹ��캯�����
		type = "����";
		this.number = 1+ numberRange;
		getPerformance();
		getInteraction();
	}
	
	public void getPerformance() {
		perform[0] = new perform("��������", rand.nextInt(10)+5);
		perform[1] = new perform("�������", rand.nextInt(10)+5);
	}
	
	public void getInteraction() {
		interact[0] = new Interact("������", 5, rand.nextInt(5)+5);
		interact[1] = new Interact("��������", 4, rand.nextInt(5)+5);
	}

}   
