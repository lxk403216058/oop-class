
public class Shark extends Fish {
	private final String shark = "鲨鱼";
	private String[] Per = {"捕食","游泳","出海"};
	private String[] In = {"观看鲨鱼獠牙","与鲨鱼合影","和鲨鱼共舞"};
	private String cName = "梁八";
	
	public Shark(){
		setNumber(10001);
		setName("莎莎");
		setAge();
		setSex("雌性");
		setType(shark);
		setFeedTime();
		setCatMan(cName);
		setPN(Per);
		setIn(In);
	}
	
	public String toString(){
		return super.toString();
	}

}
