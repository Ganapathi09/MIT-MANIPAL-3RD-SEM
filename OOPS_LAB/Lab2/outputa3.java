public class outputa3 {
    public static void main(String[] args) {
        // Declare and initialize a boolean variable x
        boolean x = true;

        // Attempt to assign the boolean value to an int variable y without casting
        // This will result in a compilation error
        // int y = x;

        // Assign the boolean value to an int variable y with casting
        int y = (x ? 1 : 0);

        // Print the value of y
        System.out.println("y (int): " + y);
    }
}
