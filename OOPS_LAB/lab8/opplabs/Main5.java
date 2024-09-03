package opplabs;

interface Shape {
	  double calculateArea();
	}

	class Square implements Shape {
	  private double sideLength;

	  public Square(double sideLength) {
	    this.sideLength = sideLength;
	  }

	  @Override
	  public double calculateArea() {
	    return sideLength * sideLength;
	  }
	}

	class Triangle implements Shape {
	  private double base;
	  private double height;

	  public Triangle(double base, double height) {
	    this.base = base;
	    this.height = height;
	  }

	  @Override
	  public double calculateArea() {
	    return 0.5 * base * height;
	  }
	}

	public class Main5 {
	  public static void main(String[] args) {
	    Shape square = new Square(5);
	    Shape triangle = new Triangle(10, 5);

	    System.out.println("Area of square: " + square.calculateArea());
	    System.out.println("Area of triangle: " + triangle.calculateArea());
	  }
	}

