
public class Crocodile extends Reptile {
	private final String crocodile = "����";
	private String[] Per = {"����","����","��β"};
	private String[] In = {"���㾯��","������������","������ˢ��"};
	private String cName = "С��";
	
	public Crocodile(){//����
		setNumber(30000);
		setName("���");
		setAge();
		setSex("����");
		setType(crocodile);
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
