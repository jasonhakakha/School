public class Triangle extends GeometricObject{
	private double side1;
	private double side2;
	private double side3;
	
	public Triangle(double side1, double side2, double side3){
		if(side1 + side2 <= side3 || side1 + side3 <= side2 || side2 + side3 <= side1)
			throw IllegalTriangleException(side1, side2, side3);
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}
	public double getSide1(){
		return side1;
	}
	public double getside2(){
		return side2;
	}
	public double getside3(){
		return side3;
	}
	public String toString(){
		return "side1=" + side1 + "\nside2=" + side2 + "\nside3=" + side3;
	}
}
