package three_exercise;

public class sealion extends lactation{
	public sealion() {
		super("����",2,"����",3,new trainer("xixi"));
		// TODO Auto-generated constructor stub
		type = "��ʦ";
		this.number = 1+ numberRange;
		getperform();
		getInteract();
	}

	private void getInteract() {
		// TODO Auto-generated method stub
		interact[0] = new Interact("��ʦιʳ", 3, rand.nextInt(5)+5);
		interact[1] = new Interact("��ʦ��ˮ", 3, rand.nextInt(5)+5);
	}

	private void getperform() {
		// TODO Auto-generated method stub
		perform[0] = new perform("��ʨ��ˮ", rand.nextInt(10)+5);
		perform[1] = new perform("��ʨ����", rand.nextInt(10)+5);
	}

}