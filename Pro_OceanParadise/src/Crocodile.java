
public class Crocodile extends Reptile implements Swim {
	private final String crocodile = "öùÓã";
	private String[] Per = {"·­¹ö","ÅØÏø","°ÚÎ²"};
	private String[] In = {"öùÓã¾¯¸æ","½ü´¦¹ÛÉÍöùÓã","°ïöùÓãË¢ÑÀ"};
	private String cName = "Ğ¡Íõ";
	
	public Crocodile(){//öùÓã
		setNumber(30000);
		setName("¶ğ¶ğ");
		setAge();
		setSex("´ÆĞÔ");
		setType(crocodile);
		setFeedTime();
		setCatMan(cName);
		setPN(Per);
		setIn(In);
	}
	
	public String swim(){
		return "öùÓãÓÎ¹ı";
	}
	
	@Override
	public String toString(){
		return super.toString();
	}

}
