
public class CatMan extends Staff{
	
	public CatMan(){//驯兽师
		
	}
	
	public CatMan(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	@Override
	public String toString(){
		return "现在有请驯兽师" + name + "带领";
	}

}
