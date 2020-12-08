package SchoolPerson;

public class Staff 
   extends Empoloyee{
	private String title;
	
	public Staff(){
		
	}
	
	public Staff(String name,String adderss,String phoneNumber,String email,String office,double salary,String title){
		setName(name);
		setAdderss(adderss);
		setPhoneNumber(phoneNumber);
		setEmail(email);
		setOffice(office);
		setSalary(salary);
		this.title = title;
	}
	
	public String getTitle(){
		return title;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	
	public String toString(){
		return super.toString() + "职员职务称号: " + title;  
	}

}
