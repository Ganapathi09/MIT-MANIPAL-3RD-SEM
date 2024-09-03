package lab11;

class MyThread extends Thread {
    public void run() {
        System.out.println("Thread is running with priority: " + Thread.currentThread().getPriority());

        try {
            Thread.sleep(2000); // Simulate some task
        } catch (InterruptedException e) {
            System.out.println("Thread is interrupted: " + e.getMessage());
        }

        System.out.println("Thread is finished.");
    }
}

public class main4 {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();

        // Setting thread priorities
        thread1.setPriority(Thread.MAX_PRIORITY); // Thread priority 10
        thread2.setPriority(Thread.MIN_PRIORITY); // Thread priority 1

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread is interrupted: " + e.getMessage());
        }

        System.out.println("Main thread is finished.");
    }
}
