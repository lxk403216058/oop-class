package three_exercise;

public class shark extends fish {

	public shark() {
		super("Ф��",1,"����",3, new trainer("ʱʱ"));
		type = "����";
		this.number = 2 + numberRange;
		getPerformance();
		getInteraction();
	}
	
	public void getPerformance() {
		perform[0] = new perform("��������", rand.nextInt(10)+5);
		perform[1] = new perform("��������", rand.nextInt(10)+5);
	}
	
	public void getInteraction() {
		interact[0] = new Interact("��������", 2, rand.nextInt(5)+5);
		interact[1] = new Interact("����תȦ", 1 , rand.nextInt(5)+5);
	}
}
