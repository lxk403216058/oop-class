package ClassWork2;

import java.util.Scanner;

public class ClassWork3_29 {
	public static void main(String[] args) {
		double x1,y1,x2,y2,r1,r2;
		
		Scanner input=new Scanner(System.in);
		System.out.println("Enter circle's center  x-,y-coordinates,and radius:");
		x1=input.nextDouble();
		y1=input.nextDouble();
		r1=input.nextDouble();
		System.out.println("Enter circle's center  x-,y-coordinates,and radius:");
		x2=input.nextDouble();
		y2=input.nextDouble();
		r2=input.nextDouble();
		
		double d;
		d=Math.pow((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2), 0.5);
		if (d<=(Math.abs(r1-r2))) {
			if (r1>r2)
				System.out.println("Circle2 is inside circle1");
			else
				System.out.println("Circle1 is inside circle");
		}
		else if(d>=Math.abs(r1-r2)&&d<=(r1+r2))
			System.out.println("Circle1 overlaps circle2");
		else 
			System.out.println("Circle dose not overlaps circle");
		
	}

}
