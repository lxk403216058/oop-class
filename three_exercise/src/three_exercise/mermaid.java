package three_exercise;

//美人鱼
public class mermaid extends staff {
	String classify = "美人鱼";
	String mermaidName = null;
	int number = 900000;
	perform[] perform;
	Interact[] interact;

	public mermaid(int age, String mermaidName, int number) {
		this.mermaidName = mermaidName;
		this.number = number + 900000;
	Interact[] temp = {new Interact("握手",5,3),new Interact("拍照",3,1)};
	this.interact=temp;
	perform[] ans = { new perform("舞蹈", 5), new perform("歌唱", 3), new perform("化为泡沫", 2) };
	this.perform=ans;
    }
}
