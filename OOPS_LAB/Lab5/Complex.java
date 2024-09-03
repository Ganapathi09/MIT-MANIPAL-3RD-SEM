class Complex {
    private double real;
    private double imaginary;

    public Complex() {
        this.real = 0.0;
        this.imaginary = 0.0;
    }

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    // Method to add an integer to a complex number
    public Complex add(int num) {
        return new Complex(this.real + num, this.imaginary);
    }

    // Method to add two complex numbers
    public Complex add(Complex otherComplex) {
        double realSum = this.real + otherComplex.real;
        double imaginarySum = this.imaginary + otherComplex.imaginary;
        return new Complex(realSum, imaginarySum);
    }

    // Display the complex number
    public void display() {
        System.out.println(real + " + " + imaginary + "i");
    }

    public static void main(String[] args) {
        Complex complex1 = new Complex(3.0, 2.0);
        Complex complex2 = new Complex(1.0, 4.0);

        System.out.println("Complex Number 1:");
        complex1.display();

        System.out.println("Complex Number 2:");
        complex2.display();

        Complex sum1 = complex1.add(5);
        System.out.println("Complex Number 1 + 5:");
        sum1.display();

        Complex sum2 = complex1.add(complex2);
        System.out.println("Complex Number 1 + Complex Number 2:");
        sum2.display();
    }
}
