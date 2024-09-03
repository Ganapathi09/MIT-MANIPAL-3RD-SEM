package program;


//User-defined exception class
class MyCustomException extends Exception {
public MyCustomException(String message) {
   super(message);
}
}

public class main4 {
public static void main(String[] args) {
   try {
       // Simulating a situation where the custom exception might be thrown
       int age = -1;

       if (age < 0) {
           // Throwing the custom exception with a custom error message
           throw new MyCustomException("Age cannot be negative");
       }

       // Rest of the code (will not be executed if the exception is thrown)
       System.out.println("Age: " + age);
   } catch (MyCustomException e) {
       // Handling the custom exception and printing the error message
       System.out.println("Error: " + e.getMessage());
   }
}
}
