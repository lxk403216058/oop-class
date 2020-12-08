
public class SeaLion extends MarineMammals {
	private final String seaLion = "海狮";
	private String[] Per = {"倒立行走","敬礼","360度旋转"};
	private String[] In = {"与海狮接吻","和海狮相互投球","海狮向你鞠躬"};
	private String cName = "刘六";
	
	public SeaLion(){
		setNumber(20000);
		setName("思思");
		setAge();
		setSex("雌性");
		setType(seaLion);
		setFeedTime();
		setCatMan(cName);
		setPN(Per);
		setIn(In);
	}
	
	public String toString(){
		return super.toString();
	}

}
