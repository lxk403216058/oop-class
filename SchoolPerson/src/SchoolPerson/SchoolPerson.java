package SchoolPerson;

import java.util.Scanner;

public class SchoolPerson {
	public static void main(String[] args){
		Scanner enter = new Scanner(System.in);
		
		System.out.println("����:����(String),��ַ(String),�ֻ���(String),�����ʼ�(String)");
		String name="";
		String add="";
		String number="";
		String email="";
		name=enter.next();
		add=enter.next();
		number=enter.next();
		email=enter.next();
		Person per=new Person(name,add,number,email);
		
		System.out.println(per.toString());
		
		System.out.println("ѧ��:����(String),��ַ(String),�ֻ���(String),�����ʼ�(String),ѧ���꼶(int 1-4)");
		name=enter.next();
		add=enter.next();
		number=enter.next();
		email=enter.next();
		int grade=enter.nextInt();
		Student stu=new Student(name,add,number,email,grade);
		
		System.out.println(stu.toString());
		
		System.out.println("��Ա:����(String),��ַ(String),�ֻ���(String),�����ʼ�(String),�칫��(String),����(double)");
		name=enter.next();
		add=enter.next();
		number=enter.next();
		email=enter.next();
		String office=enter.next();
		double salary=enter.nextDouble();
		Empoloyee emp=new Empoloyee(name,add,number,email,office,salary);
		
		System.out.println(emp.toString());
		
		System.out.println("��ְ��:����(String),��ַ(String),�ֻ���(String),�����ʼ�(String),�칫��(String),����(Double),�칫ʱ��(double)");
		name=enter.next();
		add=enter.next();
		number=enter.next();
		email=enter.next();
		office=enter.next();
		salary=enter.nextDouble();
		double officeHour=enter.nextDouble();
		Faculty fac=new Faculty(name,add,number,email,office,salary,officeHour);
		
		System.out.println(fac.toString());
		
		System.out.println("ְԱ:����(String),��ַ(String),�ֻ���(String),�����ʼ�(String),�칫��(String),����(Double),ְ��ƺ�(String)");
		name=enter.next();
		add=enter.next();
		number=enter.next();
		email=enter.next();
		office=enter.next();
		salary=enter.nextDouble();
		String area=enter.next();
		Staff sta=new Staff(name,add,number,email,office,salary,area);
		
		System.out.println(sta.toString());
	}
	
}
