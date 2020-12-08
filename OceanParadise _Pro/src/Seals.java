
public class Seals extends MarineMammals {
	private final String seals = "海豹";
	private String[] Per = {"水中芭蕾","陆地华尔兹","呼啦圈"};
	private String[] In = {"和海豹握手","抚摸海豹","与海豹接吻"};
	private String cName = "周七";
	
	public Seals(){
		setNumber(20002);
		setName("宝宝");
		setAge();
		setSex("雄性");
		setType(seals);
		setFeedTime();
		setCatMan(cName);
		setPN(Per);
		setIn(In);
	}
	
	public String toString(){
		return super.toString();
	}

}
