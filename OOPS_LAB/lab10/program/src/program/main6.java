package program;

import java.util.Scanner;

public class main6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        double number = scanner.nextDouble();

        if (number >= 0) {
            double squareRoot = Math.sqrt(number);
            System.out.println("Square root of " + number + " is: " + squareRoot);
        } else {
            System.out.println("Cannot calculate square root of a negative number.");
        }

        scanner.close();
    }
}
