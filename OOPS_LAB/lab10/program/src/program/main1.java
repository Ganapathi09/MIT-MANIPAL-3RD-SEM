package program;

import java.util.Scanner;

public class main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        String input = scanner.nextLine();

        try {
            int number = Integer.parseInt(input);
            System.out.println("Successfully converted input to number: " + number);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter a valid number.");
            System.out.println("Error message: " + e.getMessage());
        }

        scanner.close();
    }
}
