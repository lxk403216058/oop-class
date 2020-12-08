package three_exercise;

public class crocodile extends climb {
	public crocodile() {
		super("李大笨",2,"雄性",3,new trainer("jiejie"));
		// TODO 自动生成的构造函数存根
		type = "鳄鱼";
		this.number = 1+ numberRange;
		getPerformance();
		getInteraction();
	}
	
	public void getPerformance() {
		perform[0] = new perform("极限鳄鱼", rand.nextInt(10)+5);
		perform[1] = new perform("冲吧鳄鱼", rand.nextInt(10)+5);
	}
	
	public void getInteraction() {
		interact[0] = new Interact("骑鳄鱼", 5, rand.nextInt(5)+5);
		interact[1] = new Interact("鳄鱼亲亲", 4, rand.nextInt(5)+5);
	}

}   
