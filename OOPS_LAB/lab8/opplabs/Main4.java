package opplabs;

abstract class Shapee {
	  protected abstract double calculateArea();

	  public double getArea() {
	    return calculateArea();
	  }
	}

	class Square extends Shapee {
	  private double sideLength;

	  public Square(double sideLength) {
	    this.sideLength = sideLength;
	  }

	  @Override
	  protected double calculateArea() {
	    return sideLength * sideLength;
	  }
	}

	class Triangle extends Shapee {
	  private double base;
	  private double height;

	  public Triangle(double base, double height) {
	    this.base = base;
	    this.height = height;
	  }

	  @Override
	  protected double calculateArea() {
	    return 0.5 * base * height;
	  }
	}

	public class Main4 {
	  public static void main(String[] args) {
	    Square square = new Square(5);
	    Triangle triangle = new Triangle(10, 5);

	    System.out.println("Area of square: " + square.getArea());
	    System.out.println("Area of triangle: " + triangle.getArea());
	  }
	}
