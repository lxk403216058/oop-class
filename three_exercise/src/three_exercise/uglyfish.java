package three_exercise;

public class uglyfish extends fish{
  public uglyfish() {
	   super( "����", 1, "����", 1,new trainer("JOJO"));
		// TODO �Զ����ɵĹ��캯�����
		type = "С����";
		this.number = 1 + numberRange;
		getPerformance();
		getInteraction();
		
	}
	public void getPerformance() {
		perform[0] = new perform("С������", rand.nextInt(10)+5);
		perform[1] = new perform("С��תȦ", rand.nextInt(10)+5);
	}
	public void getInteraction() {
		interact[0] = new Interact("С������", 2, rand.nextInt(5)+5);
		interact[1] = new Interact("С����ˮ", 2 , rand.nextInt(5)+5);
	}
	
}





