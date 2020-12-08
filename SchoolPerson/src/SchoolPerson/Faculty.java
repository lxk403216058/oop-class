package SchoolPerson;

public class Faculty 
    extends Empoloyee{
	private double ofHours;
	
	public Faculty(){
		
	}
	
	public Faculty(String name,String adderss,String phoneNumber,String email,String office,double salary,double ofHours){
		setName(name);
		setAdderss(adderss);
		setPhoneNumber(phoneNumber);
		setEmail(email);
		setOffice(office);
		setSalary(salary);
		this.ofHours = ofHours;
	}
	
	public double getOfHours(){
		return ofHours;
	}
	
	 public void setOfHours(double ofHours){
		 this.ofHours = ofHours;
	 }
	 
	 
	 public String toString(){
		 return super.toString() + "教职工工作时间: " + ofHours ;
	 }

}
