
public class Animal {
	protected int number;
	protected String type;
	protected String name;
	protected String sex;
	protected int age;
	protected int feedTime;
	protected boolean isFeeded = false;
	protected CatMan c ;
	protected Performence[] P = new Performence[3];
	protected Interaction[] I = new Interaction[3];
	
	public Animal(){
		
	}
	
	public void setPN(String[] str){
		for (int i = 0;i < str.length;i ++){
			P[i] = new Performence(str[i]);
		}
	}
	
	public void setIn(String[] str1){
		for (int i = 0;i < str1.length ;i ++){
			I[i] = new Interaction(str1[i]);
		}
	}
	
	public void setCatMan(String str){
		c = new CatMan(str);
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
	
	public void setIsFeeded(){
		this.isFeeded = true;
	}
	
	public String toString(){
		return "今天表演的" + type +"名叫" + name + ", "+ age + "岁，"+ sex + "," + c.toString() + name +"出场";
	}

}
