package program;

import java.util.Scanner;

public class main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1, str2;

        do {
            System.out.println("Menu:");
            System.out.println("1. Compare two strings");
            System.out.println("2. Convert uppercase to lowercase and vice-versa");
            System.out.println("3. Check if a string is a substring and replace with 'Hello'");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter first string: ");
                    scanner.nextLine(); // Consume newline
                    str1 = scanner.nextLine();
                    System.out.print("Enter second string: ");
                    str2 = scanner.nextLine();
                    if (str1.equals(str2)) {
                        System.out.println("Strings are equal.");
                    } else {
                        System.out.println("Strings are not equal.");
                    }
                    break;
                case 2:
                    System.out.print("Enter a string: ");
                    scanner.nextLine(); // Consume newline
                    String input = scanner.nextLine();
                    StringBuilder result = new StringBuilder();
                    for (char ch : input.toCharArray()) {
                        if (Character.isUpperCase(ch)) {
                            result.append(Character.toLowerCase(ch));
                        } else if (Character.isLowerCase(ch)) {
                            result.append(Character.toUpperCase(ch));
                        } else {
                            result.append(ch);
                        }
                    }
                    System.out.println("Converted string: " + result.toString());
                    break;
                case 3:
                    System.out.print("Enter the first string: ");
                    scanner.nextLine(); // Consume newline
                    str1 = scanner.nextLine();
                    System.out.print("Enter the second string: ");
                    str2 = scanner.nextLine();
                    if (str1.contains(str2) || str2.contains(str1)) {
                        String replacedString = str1.replaceAll(str2, "Hello");
                        System.out.println("Modified string: " + replacedString);
                    } else {
                        System.out.println("Entered strings are not substrings of each other.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting program. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (true);
    }
}
