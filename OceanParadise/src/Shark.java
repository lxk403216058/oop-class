
public class Shark extends Fish {
	private final String shark = "����";
	private String[] Per = {"��ʳ","��Ӿ","����"};
	private String[] In = {"�ۿ��������","�������Ӱ","�����㹲��"};
	private String cName = "����";
	
	public Shark(){
		setNumber(10001);
		setName("ɯɯ");
		setAge();
		setSex("����");
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
