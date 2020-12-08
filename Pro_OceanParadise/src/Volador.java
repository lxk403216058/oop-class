
public class Volador extends Fish implements Fly {
	private final String volador = "飞鱼";
	private String[] Per = {"滑翔","展翅","入水"};
	private String[] In = {"和飞鱼合影","给飞鱼投食","观看飞鱼咆哮"};
	private String cName = "老九";
	
	
	public Volador(){
		setNumber(10000);
		setName("菲菲");
		setAge();
		setSex("雌性");
		setType(volador);
		setFeedTime();
		setCatMan(cName);
		setPN(Per);
		setIn(In);
	}
	
	public String fly(){
		return "飞鱼飞过";
	}
	
	public String toString(){
		return super.toString();
	}

}
