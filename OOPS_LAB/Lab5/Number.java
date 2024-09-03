public class Number {
    private double value;

    // Constructor to initialize the value
    public Number(double value) {
        this.value = value;
    }

    // Method to check if the number is zero
    public boolean isZero() {
        return value == 0;
    }

    // Method to check if the number is positive
    public boolean isPositive() {
        return value > 0;
    }

    // Method to check if the number is negative
    public boolean isNegative() {
        return value < 0;
    }

    // Method to check if the number is odd
    public boolean isOdd() {
        return value % 2 != 0;
    }

    // Method to check if the number is even
    public boolean isEven() {
        return value % 2 == 0;
    }

    // Method to check if the number is prime
    public boolean isPrime() {
        if (value <= 1) {
            return false;
        }
        if (value <= 3) {
            return true;
        }
        if (value % 2 == 0 || value % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= value; i += 6) {
            if (value % i == 0 || value % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    // Method to check if the number is an Armstrong number
    public boolean isArmstrong() {
        int n = (int) value;
        int sum = 0;
        int temp = n;
        int numberOfDigits = (int) Math.log10(n) + 1;

        while (temp > 0) {
            int digit = temp % 10;
            sum += Math.pow(digit, numberOfDigits);
            temp /= 10;
        }

        return sum == n;
    }

    public static void main(String[] args) {
        Number num = new Number(153);

        System.out.println("Is Zero: " + num.isZero());
        System.out.println("Is Positive: " + num.isPositive());
        System.out.println("Is Negative: " + num.isNegative());
        System.out.println("Is Odd: " + num.isOdd());
        System.out.println("Is Even: " + num.isEven());
        System.out.println("Is Prime: " + num.isPrime());
        System.out.println("Is Armstrong: " + num.isArmstrong());
    }
}
