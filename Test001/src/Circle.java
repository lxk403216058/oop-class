
public class Circle {
	private double radius;
	
	
	public void setRadius(double radius) {
		this.radius=radius;
	}
	
	public Circle() {
		this.radius = 4.5;
	}
	public Circle(double radius) {//重载   参数不同
		this.radius=radius;
	}
	public double getRadius() {
		return radius;
	}
	public double getArea() {
		
		double area=0;
		area=0;
		area=Math.PI*Math.pow(radius, 2);
		return area;
	}
	
	

}
