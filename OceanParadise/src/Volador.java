
public class Volador extends Fish {
	private final String volador = "����";
	private String[] Per = {"����","չ��","��ˮ"};
	private String[] In = {"�ͷ����Ӱ","������Ͷʳ","�ۿ���������"};
	private String cName = "�Ͼ�";
	
	
	public Volador(){
		setNumber(10000);
		setName("�Ʒ�");
		setAge();
		setSex("����");
		setType(volador);
		setFeedTime();
		setCatMan(cName);
		setPN(Per);
		setIn(In);
	}
	
	public String toString(){
		return super.toString();
	}

}
