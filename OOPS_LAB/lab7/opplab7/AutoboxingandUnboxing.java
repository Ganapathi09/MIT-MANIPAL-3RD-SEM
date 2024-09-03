package opplab7;

public class AutoboxingandUnboxing {
    public static void main(String[] args) {
        // Autoboxing
        Integer integer = 5; // Boxing an int value
        Double doubleValue = 10.5; // Boxing a double value
        Character character = 'a'; // Boxing a char value

        // Unboxing
        int unboxedInt = integer; // Unboxing an Integer object to int
        double unboxedDouble = doubleValue; // Unboxing a Double object to double
        char unboxedChar = character; // Unboxing a Character object to char

        // Printing the values
        System.out.println("Integer: " + integer);
        System.out.println("Double: " + doubleValue);
        System.out.println("Character: " + character);

        System.out.println("Unboxed int: " + unboxedInt);
        System.out.println("Unboxed double: " + unboxedDouble);
        System.out.println("Unboxed char: " + unboxedChar);
    }
}

