package program;



import java.util.Arrays;
import java.util.Scanner;

public class main3 {

	
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        String inputString;

	        System.out.print("Enter a string: ");
	        inputString = scanner.nextLine();

	        int choice;
	        do {
	            System.out.println("\n--- Menu ---");
	            System.out.println("1. Check if the string is a palindrome");
	            System.out.println("2. Write the string in alphabetical order");
	            System.out.println("3. Reverse the string");
	            System.out.println("4. Concatenate the original string and its reverse");
	            System.out.println("5. Exit");
	            System.out.print("Enter your choice: ");
	            choice = scanner.nextInt();

	            switch (choice) {
	                case 1:
	                    if (isPalindrome(inputString)) {
	                        System.out.println("The string is a palindrome.");
	                    } else {
	                        System.out.println("The string is not a palindrome.");
	                    }
	                    break;
	                case 2:
	                    String sortedString = sortStringAlphabetically(inputString);
	                    System.out.println("The string in alphabetical order: " + sortedString);
	                    break;
	                case 3:
	                    String reversedString = reverseString(inputString);
	                    System.out.println("The reversed string: " + reversedString);
	                    break;
	                case 4:
	                    String concatenatedString = concatenateStringWithReverse(inputString);
	                    System.out.println("The concatenated string: " + concatenatedString);
	                    break;
	                case 5:
	                    System.out.println("Exiting the program...");
	                    break;
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        } while (choice != 5);

	        scanner.close();
	    }

	    private static boolean isPalindrome(String str) {
	        String reversedString = reverseString(str);
	        return str.equalsIgnoreCase(reversedString);
	    }

	    private static String sortStringAlphabetically(String str) {
	        char[] charArray = str.toCharArray();
	        Arrays.sort(charArray);
	        return new String(charArray);
	    }

	    private static String reverseString(String str) {
	        StringBuilder reversedString = new StringBuilder(str);
	        return reversedString.reverse().toString();
	    }

	    private static String concatenateStringWithReverse(String str) {
	        String reversedString = reverseString(str);
	        return str + reversedString;
	    }
	}

