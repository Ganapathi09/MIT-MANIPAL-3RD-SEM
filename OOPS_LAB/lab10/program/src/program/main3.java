package program;


import java.util.Scanner;

public class main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Student's Name, Roll Number, and Marks in three subjects
        System.out.print("Enter Student's Name: ");
        String name = scanner.nextLine();

        int rollNumber = 0;
        try {
            System.out.print("Enter Roll Number: ");
            rollNumber = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid Roll Number! Please enter a valid number.");
            return;
        }

        int[] marks = new int[3];
        for (int i = 0; i < 3; i++) {
            try {
                System.out.print("Enter Marks in Subject " + (i + 1) + ": ");
                marks[i] = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid Marks! Please enter a valid number.");
                return;
            }
        }

        // Calculate Percentage
        int totalMarks = marks[0] + marks[1] + marks[2];
        double percentage = (double) totalMarks / 3;

        // Determine Grade based on Percentage
        char grade;
        if (percentage >= 90) {
            grade = 'A';
        } else if (percentage >= 80) {
            grade = 'B';
        } else if (percentage >= 70) {
            grade = 'C';
        } else if (percentage >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        // Output: Percentage, Grade
        System.out.println("Percentage: " + percentage);
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}
