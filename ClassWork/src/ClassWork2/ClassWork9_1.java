package ClassWork2;

public class ClassWork9_1 {
	public static void main(String[] args) {
		Rectangle r1,r2;
		r1=new Rectangle(4,40);
		System.out.println("width: "+r1.width+" height: "+r1.height+" area: "+r1.getArea()+" perimeter: "+r1.getPerimeter());
		r2 = new Rectangle(3.5,35.9);
		System.out.println("width: "+r2.width+" height: "+r2.height+" area: "+r2.getArea()+" perimeter: "+r2.getPerimeter());
	}
}
class Rectangle{
	double width=1,height=1;
	
	public Rectangle() {
	}
	
	public Rectangle(double width,double height) {
		this.width=width;
		this.height=height;
	}
	
	double getArea() {
		return width*height;
	}
	
	double getPerimeter() {
		return 2*(width+height);
	}
}
