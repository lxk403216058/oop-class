
public class CatMan extends Staff{
	
	public CatMan(){//ѱ��ʦ
		
	}
	
	public CatMan(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	@Override
	public String toString(){
		return "��������ѱ��ʦ" + name + "����";
	}

}

