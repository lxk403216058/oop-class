package three_exercise;

//������
public class mermaid extends staff {
	String classify = "������";
	String mermaidName = null;
	int number = 900000;
	perform[] perform;
	Interact[] interact;

	public mermaid(int age, String mermaidName, int number) {
		this.mermaidName = mermaidName;
		this.number = number + 900000;
	Interact[] temp = {new Interact("����",5,3),new Interact("����",3,1)};
	this.interact=temp;
	perform[] ans = { new perform("�赸", 5), new perform("�質", 3), new perform("��Ϊ��ĭ", 2) };
	this.perform=ans;
    }
}
