package SchoolPerson;

public class Student 
   extends Person{
	private final String Freshman = "Freshman";
	private final String Sophomore = "Sophomore";
	private final String Junior = "Junior";
	private final String Senior = "Senior";
	private String classes;
	private int lever;
	
	public Student(){
		
	}
	
	public Student(String name,String adderss,String phoneNumber,String email,int lever){
		this.lever = lever;
		setName(name);
		setAdderss(adderss);
		setPhoneNumber(phoneNumber);
		setEmail(email);
	}
	
	public String getClasses(){
		return classes;
	}
	
	public int getLever(){
		return lever;
	}
	
	public void setLever(int lever){
		this.lever = lever;
	}
	
	public String judge(){
		if (lever == 1){
			return Freshman;
		}
		else if (lever == 2){
			return Sophomore;
		}
		else if (lever == 3){
			return Junior;
		}
		else {
			return Senior;
		}
	}
	
	public String toString(){
		return super.toString() + " 学生年级: " + judge();
	}

}
