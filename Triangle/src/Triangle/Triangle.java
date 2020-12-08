package Triangle;

import java.util.Scanner;

public class Triangle {
	public static void main(String[] args){
		double side1 = 0,side2 = 0,side3 = 0;
		boolean filled;
		String color;
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the triangle's three sides: ");

		side1 = input.nextDouble();
		side2 = input.nextDouble();
		side3 = input.nextDouble();
		System.out.println("Enter the triangle's color: ");
		color = input.next();
		System.out.println("Whether the triangle's color is filled(Enter ture or false): ");
		filled = input.hasNext();
		TriangleGeometricObject triangle = new TriangleGeometricObject(side1,side2,side3,color,filled);
		System.out.println("The triangle's area: " + triangle.getArea() + " perimeter: " + triangle.getPerimeter());
		System.out.println(triangle.toString());
		System.out.println("The triangle's color: " + triangle.getColor());
		if (filled){
			System.out.println("The triangle does filled");
		}
		else {
			System.out.println("The triangle doesn't filled");
		}
	}

}
