package ClassWork2;

import java.util.Scanner;

public class ClassWork3_1 {
	public static void main(String[] args) {
		double a,b,c;
		System.out.println("Enter a,b,c:");
		Scanner input=new Scanner(System.in);
		a=input.nextDouble();
		b=input.nextDouble();
		c=input.nextDouble();
		double delta=Math.pow((b*b-4*a*c), 0.5);
		if (delta>=0) {
			double root1,root2;
			root1=(-b+delta)/2*a;
			root2=(-b-delta)/2*a;
			if (root1==root2) {
				System.out.println("The equation has one root "+root1);
			}
			else {
				System.out.println("The equation has two roots "+root1+" and "+root2);
			}
		}
		else {
			System.out.println("The equation has no real roots");
		}
	}

}
