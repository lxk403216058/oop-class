package SchoolPerson;

public class Empoloyee 
    extends Person{
	private String office;
	private double salary;
	
	public Empoloyee(){
		
	}
	
	public Empoloyee(String name,String adderss,String phoneNumber,String email,String office,double salary){
		setName(name);
		setAdderss(adderss);
		setPhoneNumber(phoneNumber);
		setEmail(email);
		this.office = office;
		this.salary = salary;
	}
	
	public String getOffice(){
		return office;
	}
	
	public double getSalary(){
		return salary;
	}
	
	public void setOffice(String office){
		this.office = office;
	}
	
	public void setSalary(double salary){
		this.salary = salary;
	}
	
	public String toString(){
		return super.toString() + " 雇员办公室: " + office + " 工资: " + salary ; 
	}

}
