
public class Lizard extends Reptile {
	private final String lizard = "����";
	private String[] Per = {"��ɫ","����","��β"};
	private String[] In = {"��������","��������","�������Ӱ"};
	private String cName = "����";
	
	
	public Lizard(){//����
		setNumber(30001);
		setName("����");
		setAge();
		setSex("����");
		setType(lizard);
		setFeedTime();
		setCatMan(cName);
		setPN(Per);
		setIn(In);
	}
	
	public String toString(){
		return super.toString();
	}

}
