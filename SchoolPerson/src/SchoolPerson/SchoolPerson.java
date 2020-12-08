package SchoolPerson;

import java.util.Scanner;

public class SchoolPerson {
	public static void main(String[] args){
		Scanner enter = new Scanner(System.in);
		
		System.out.println("个人:名字(String),地址(String),手机号(String),电子邮件(String)");
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
		
		System.out.println("学生:名字(String),地址(String),手机号(String),电子邮件(String),学生年级(int 1-4)");
		name=enter.next();
		add=enter.next();
		number=enter.next();
		email=enter.next();
		int grade=enter.nextInt();
		Student stu=new Student(name,add,number,email,grade);
		
		System.out.println(stu.toString());
		
		System.out.println("雇员:名字(String),地址(String),手机号(String),电子邮件(String),办公室(String),工资(double)");
		name=enter.next();
		add=enter.next();
		number=enter.next();
		email=enter.next();
		String office=enter.next();
		double salary=enter.nextDouble();
		Empoloyee emp=new Empoloyee(name,add,number,email,office,salary);
		
		System.out.println(emp.toString());
		
		System.out.println("教职工:名字(String),地址(String),手机号(String),电子邮件(String),办公室(String),工资(Double),办公时间(double)");
		name=enter.next();
		add=enter.next();
		number=enter.next();
		email=enter.next();
		office=enter.next();
		salary=enter.nextDouble();
		double officeHour=enter.nextDouble();
		Faculty fac=new Faculty(name,add,number,email,office,salary,officeHour);
		
		System.out.println(fac.toString());
		
		System.out.println("职员:名字(String),地址(String),手机号(String),电子邮件(String),办公室(String),工资(Double),职务称号(String)");
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
