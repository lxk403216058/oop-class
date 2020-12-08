package three_exercise;

public class uglyfish extends fish{
  public uglyfish() {
	   super( "基德", 1, "雄性", 1,new trainer("JOJO"));
		// TODO 自动生成的构造函数存根
		type = "小丑鱼";
		this.number = 1 + numberRange;
		getPerformance();
		getInteraction();
		
	}
	public void getPerformance() {
		perform[0] = new perform("小丑吓人", rand.nextInt(10)+5);
		perform[1] = new perform("小丑转圈", rand.nextInt(10)+5);
	}
	public void getInteraction() {
		interact[0] = new Interact("小丑亲亲", 2, rand.nextInt(5)+5);
		interact[1] = new Interact("小丑吐水", 2 , rand.nextInt(5)+5);
	}
	
}





