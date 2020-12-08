
public class ClownFish extends Fish {
	private final String clownFish = "小丑鱼";
	private String[] Per = {"水中转圈","吐泡泡","跳舞"};
	private String[] In = {"和小丑鱼合影","给小丑鱼投食","和小丑鱼握手"};
	private String cName = "张三";
	
	public ClownFish(){
		setNumber(10002);
		setName("瞅瞅");
		setAge();
		setSex("雄性");
		setType(clownFish);
		setFeedTime();
		setCatMan(cName);
		setPN(Per);
		setIn(In);
	}
	
	@Override
	public String toString(){
		return super.toString();
	}

}
