
public class ClownFish extends Fish {
	private final String clownFish = "С����";
	private String[] Per = {"ˮ��תȦ","������","����"};
	private String[] In = {"��С�����Ӱ","��С����Ͷʳ","��С��������"};
	private String cName = "����";
	
	public ClownFish(){
		setNumber(10002);
		setName("���");
		setAge();
		setSex("����");
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
