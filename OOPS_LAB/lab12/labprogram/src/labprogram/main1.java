package labprogram;

import java.util.Arrays;

public class main1 {
    public static <T> void swapElements(T[] array, int index1, int index2) {
        if (index1 >= 0 && index1 < array.length && index2 >= 0 && index2 < array.length) {
            T temp = array[index1];
            array[index1] = array[index2];
            array[index2] = temp;
        } else {
            System.out.println("Invalid indices");
        }
    }

    public static void main(String[] args) {
        Integer[] integerArray = {1, 2, 3, 4, 5};
        String[] stringArray = {"apple", "banana", "cherry", "date", "elderberry"};

        System.out.println("Original Integer Array: " + Arrays.toString(integerArray));
        swapElements(integerArray, 1, 3);
        System.out.println("Array after swapping elements: " + Arrays.toString(integerArray));

        System.out.println("Original String Array: " + Arrays.toString(stringArray));
        swapElements(stringArray, 0, 4);
        System.out.println("Array after swapping elements: " + Arrays.toString(stringArray));
    }
}
