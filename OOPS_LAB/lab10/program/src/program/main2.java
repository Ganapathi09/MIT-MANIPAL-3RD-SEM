package program;


class ArrayOverflowException extends Exception {
    public ArrayOverflowException(String message) {
        super(message);
    }
}

public class main2 {
    public static void main(String[] args) {
        int[] array = new int[5];
        int index = 6; // Trying to access an index that is out of bounds

        try {
            if (index >= array.length) {
                throw new ArrayOverflowException("Array index out of bounds: " + index);
            }
            int value = array[index];
            System.out.println("Value at index " + index + ": " + value);
        } catch (ArrayOverflowException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}
