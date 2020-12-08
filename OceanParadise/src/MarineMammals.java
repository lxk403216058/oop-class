
public class MarineMammals extends Animal {
	
	public MarineMammals(){//º£Ñó²¸Èé¶¯Îï
		
	}
	
	public void setNumber(int number){
		this.number = number;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setAge(){
		this.age  = (int)(Math.random()*10) + 1;
	}
	
	public void setSex(String sex){
		this.sex = sex;
	}
	
	public void setType(String type){
		this.type = type;
	}
	
	public void setFeedTime(){
		this.feedTime = (int)(Math.random()*5 + 5);
	}
	
	public String toString(){
		return super.toString();
	}
	

}
