package lab11;

class SharedResource {
    void printNumbers() {
        synchronized (this) {
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
                try {
                    Thread.sleep(500); // Simulating some time-consuming task
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class MyThread1 extends Thread {
    SharedResource sharedResource;

    public MyThread1(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    public void run() {
        sharedResource.printNumbers();
    }
}

class MyThread2 extends Thread {
    SharedResource sharedResource;

    public MyThread2(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    public void run() {
        sharedResource.printNumbers();
    }
}

public class main52 {// SynchronizedStatementExample
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        MyThread1 thread1 = new MyThread1(sharedResource);
        MyThread2 thread2 = new MyThread2(sharedResource);

        thread1.start();
        thread2.start();
    }
}
