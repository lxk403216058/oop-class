import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		Lever l = new Lever();
		Dial d = new Dial();
		Brush b = new Brush();
		Agent a = new Agent1();
		
		int choice = 0;
		
		while(true){
			menu();
			choice = input.nextInt();
			switch(choice){
			case 1:
				l.setstate();
				l.getstate().uppos();		
				break;
			case 2:
				l.setstate();
				l.getstate().downpos();
				break;
			case 3:
				d.setstate();
				d.getstate().uppos();
				break;
			case 4:
				d.setstate();
				d.getstate().downpos();
				break;
			default:
				System.exit(0);
				break;
			}
			a.dealSpeed(l, d, b);
			
			System.out.println("Lever's pos:" + l.getpos());
			System.out.println("Dial's pos:" + d.getpos());
			System.out.println("Brush's speed:" + b.getSpeed());
				
		}
	}
	
	private static void menu()
	{
		System.out.println("please input your choice:");
		System.out.println("1:Lever up");
		System.out.println("2:Lever down");
		System.out.println("3:Dial up");
		System.out.println("4:Dial down");
		System.out.println("0:exit");
	}

}

