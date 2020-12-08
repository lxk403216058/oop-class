package three_exercise;

public class lizard extends climb{
	
	public lizard() {
		super("时时", 2, "雄性", 3,new trainer("meimei"));
		// TODO 自动生成的构造函数存根
		type = "蜥蜴";
		this.number = 2 + numberRange;
		getPerformance();
		getInteraction();
	}
	
	public void getPerformance() {
		perform[0] = new perform("蜥蜴喂食", rand.nextInt(10)+5);
		perform[1] = new perform("蜥蜴跳舞", rand.nextInt(10)+5);
	}
	
	public void getInteraction() {
		interact[0] = new Interact("蜥蜴转圈", 5, rand.nextInt(5)+5);
		interact[1] = new Interact("蜥蜴亲亲", 4, rand.nextInt(5)+5);
	}

}   

