package ClassWork2;

import java.util.Scanner;

public class ClassWork3_11 {
	public static void main(String[] args) {
		int year,month;
		System.out.println("Ener the month, year:");
		Scanner input=new Scanner(System.in);
		month=input.nextInt();
		year=input.nextInt();
		if (month<=0||month>12||year<0) {
			System.out.println("You input error!");
		}
		else {
			int flag=0;
			String[] months= {"January","February","March","April","May","June","July","August","September","October","November","December"};
			if (year%4==0&&year%100!=0||year%400==0)
				flag=1;
			switch(month){
			case 1:case 3:case 5:case 7:case 8:case 10:case 12:
				System.out.println(months[month-1]+" "+year+" has 31 days");break;
			case 2:
				System.out.println(months[month-1]+" "+year+" has "+(28+flag)+" days");break;
			default:
				System.out.println(months[month-1]+" "+year+" has 30 days");
			}
		}
	}

}
