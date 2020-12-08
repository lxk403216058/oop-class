
public class Dolphin extends MarineMammals {
	private final String dolphin = "海豚";
	private String[] Per = {"顶球","转圈","跃龙门"};
	private String[] In = {"与海豚握手","和海豚接吻","给海豚拍照"};
	private String cName = "李四";
	
	public Dolphin(){
		setNumber(20001);
		setName("屯屯");
		setAge();
		setSex("雄性");
		setType(dolphin);
		setFeedTime();
		setCatMan(cName);
		setPN(Per);
		setIn(In);
	}
	
	public String toString(){
		return super.toString();
	}

}
