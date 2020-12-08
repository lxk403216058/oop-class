package Nextdate;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int y,m,d;
		
		System.out.println("请输入年月日（yyyy mm dd）:");
		
		y = input.nextInt();
		m = input.nextInt();
		d = input.nextInt();
		
		NextDate nextDate = new NextDate(y, m, d);
		nextDate.nextdate();
		
	}

}
