package SchoolPerson;

public class Person {
	private String name;
	private String adderss;
	private String phoneNumber;
	private String email;
	
	public Person(){
		
	}
	
	public Person(String name,String adderss,String phoneNumber,String email){
		this.name = name;
		this.adderss = adderss;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	
	public String getName(){
		return name;
	}
	
	public String getAdderss(){
		return adderss;
	}
	
	public String getPhoneNumber(){
		return phoneNumber;
	}
	
	public String getEmail(){ 
		return email;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setAdderss(String adderss){
		this.adderss = adderss;
	}
	
	public void setPhoneNumber(String phoneNumber){
		this.phoneNumber = phoneNumber;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public String toString(){
		return "个人名字 " + name + " 地址: " + adderss + " 手机号: " + phoneNumber + " 电子邮件: " + email;
	}
}