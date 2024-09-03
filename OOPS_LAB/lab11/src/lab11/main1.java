package lab11;

//Implementing Runnable interface
class MyRunnable implements Runnable {
 public void run() {
     System.out.println("Thread created using Runnable interface.");
 }
}

//Extending Thread class
class MyThread extends Thread {
 public void run() {
     System.out.println("Thread created by extending Thread class.");
 }
}

public class main1 {
 public static void main(String[] args) {
     System.out.println("Menu:");
     System.out.println("1. Create Thread using Runnable interface");
     System.out.println("2. Create Thread by extending Thread class");

     java.util.Scanner scanner = new java.util.Scanner(System.in);
     System.out.print("Enter your choice: ");
     int choice = scanner.nextInt();

     switch (choice) {
         case 1:
             // Creating thread using Runnable interface
             MyRunnable myRunnable = new MyRunnable();
             Thread thread1 = new Thread(myRunnable);
             thread1.start();
             break;
         case 2:
             // Creating thread by extending Thread class
             MyThread thread2 = new MyThread();
             thread2.start();
             break;
         default:
             System.out.println("Invalid choice");
     }

     scanner.close();
 }
}
