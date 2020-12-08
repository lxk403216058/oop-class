package Brush_Pro;

import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		Lever l ;
		Dial d ;
		Brush b ;
		
		l = (Lever)XMLBrush.getBean("lever");
		d = (Dial)XMLBrush.getBean("dial");
		b = (Brush)XMLBrush.getBean("brush");
		
		int choice = 0;
		
		while(true){
			menu();
			choice = input.nextInt();
			switch(choice){
			case 1:
				l.upPos();				
				break;
			case 2:
				l.downPos();
				break;
			case 3:
				d.upPos();
				break;
			case 4:
				d.downPos();
				break;
			default:
				System.exit(0);
				break;
			}
			b.dealSpeed(l, d);
			System.out.println("Lever's pos:" + l.getPos());
			System.out.println("Dial's pos:" + d.getPos());
			System.out.println("Brush's speed:" + b.getSpeed());
	}
		
    }
	public static void menu()
	{
		System.out.println("please input your choice:");
		System.out.println("1:Lever up");
		System.out.println("2:Lever down");
		System.out.println("3:Dial up");
		System.out.println("4:Dial down");
		System.out.println("0:exit");
	}
}
