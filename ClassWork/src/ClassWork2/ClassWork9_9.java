package ClassWork2;

public class ClassWork9_9 {
	public static void main(String[] args) {
		RegularPolygon r1;
		r1=new RegularPolygon();
		System.out.println("The "+r1.getN()+" side regular polygon's perimeter is "+r1.getPerimeter()+" area is "+r1.getArea());
		
		RegularPolygon r2;
		r2=new RegularPolygon(6,4);
		System.out.println("The "+r2.getN()+" side regular polygon's perimeter is "+r2.getPerimeter()+" area is "+r2.getArea());
		
		RegularPolygon r3;
		r3=new RegularPolygon(10,4,5.6,7.8);
		System.out.println("The "+r3.getN()+" side regular polygon's perimeter is "+r3.getPerimeter()+" area is "+r3.getArea());
	}

}

class RegularPolygon{
	private int n=3;
	private double side=1;
	private double x=0;
	private double y=0;
	
	public RegularPolygon(){
		
	}
	
	public RegularPolygon(int n,double side) {
		this.n=n;
		this.side=side;
	}
	
	public RegularPolygon(int n,double side,double x,double y) {
		this.n=n;
		this.side=side;
		this.x=x;
		this.y=y;
	}
	
	public int getN(int n) {
		return n;
	}
	
	public double getSide(double side) {
		return side;
	}
	
	public double getX(double x) {
		return x;
	}
	
	public double getY(double y) {
		return y;
	}
	
	public void setData(int n,double side,double x,double y) {
		this.n=n;
		this.side=side;
		this.x=x;
		this.y=y;
	}
	
	public double getPerimeter() {
		return n*side;
	}
	
	public double getArea() {
		return (n*side*side)/(4*Math.tan(Math.PI/n));
	}
	
	public int getN() {
		return n;
	}
}