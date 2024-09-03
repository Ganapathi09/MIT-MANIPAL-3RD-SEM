import java.util.Scanner;

public class readinput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read an integer from the keyboard
        System.out.print("Enter an integer: ");
        int intValue = scanner.nextInt();

        // Read a double from the keyboard
        System.out.print("Enter a double: ");
        double doubleValue = scanner.nextDouble();

        // Read a character from the keyboard
        System.out.print("Enter a character: ");
        char charValue = scanner.next().charAt(0);

        // Perform conversions
        byte byteValueFromInt = (byte) intValue;
        int intValueFromChar = (int) charValue;
        byte byteValueFromDouble = (byte) doubleValue;
        int intValueFromDouble = (int) doubleValue;

        // Display the results
        System.out.println("Converted values:");
        System.out.println("int to byte: " + byteValueFromInt);
        System.out.println("char to int: " + intValueFromChar);
        System.out.println("double to byte: " + byteValueFromDouble);
        System.out.println("double to int: " + intValueFromDouble);

        // Close the scanner
        scanner.close();
    }
}
