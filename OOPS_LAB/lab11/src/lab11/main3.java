package lab11;

class DisplayElementsThread extends Thread {
    private Matrix matrix;

    public DisplayElementsThread(Matrix matrix) {
        this.matrix = matrix;
    }

    public void run() {
        int[][] elements = matrix.getMatrix();
        for (int[] row : elements) {
            for (int element : row) {
                System.out.print(element + "\t");
            }
            System.out.println();
        }
    }
}

class TransposeMatrixThread extends Thread {
    private Matrix matrix;

    public TransposeMatrixThread(Matrix matrix) {
        this.matrix = matrix;
    }

    public void run() {
        int[][] elements = matrix.getMatrix();
        int rows = matrix.getRows();
        int columns = matrix.getColumns();

        int[][] transpose = new int[columns][rows];

        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                transpose[i][j] = elements[j][i];
            }
        }

        System.out.println("Transpose of the matrix:");
        for (int[] row : transpose) {
            for (int element : row) {
                System.out.print(element + "\t");
            }
            System.out.println();
        }
    }
}

public class main3 {
    public static void main(String[] args) throws InterruptedException {
        int[][] matrixElements = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        Matrix matrix = new Matrix(matrixElements);

        Thread t1 = new DisplayElementsThread(matrix);
        Thread t2 = new TransposeMatrixThread(matrix);

        t1.start();
        t2.start();

        // Check if t1 and t2 threads are alive
        System.out.println("Thread t1 is alive: " + t1.isAlive());
        System.out.println("Thread t2 is alive: " + t2.isAlive());

        // Wait for t1 and t2 threads to complete
        t1.join();
        t2.join();

        // Check if t1 and t2 threads are alive after completion
        System.out.println("Thread t1 is alive: " + t1.isAlive());
        System.out.println("Thread t2 is alive: " + t2.isAlive());

        // Continue with other threads if needed.
    }
}
