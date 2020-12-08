
public class Lizard extends Reptile {
	private final String lizard = "òáòæ";
	private String[] Per = {"±äÉ«","ÅÀ±Ú","¶ÏÎ²"};
	private String[] In = {"¸§Ãşòáòæ","Ç×ÎÇòáòæ","ÓëòáòæºÏÓ°"};
	private String cName = "ÍõÎå";
	
	
	public Lizard(){//òáòæ
		setNumber(30001);
		setName("ÒÀÒÀ");
		setAge();
		setSex("´ÆĞÔ");
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
