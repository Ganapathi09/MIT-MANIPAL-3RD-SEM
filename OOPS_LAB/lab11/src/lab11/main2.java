package lab11;

class Matrix {
    private int[][] matrix;

    public Matrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public int getRows() {
        return matrix.length;
    }

    public int getColumns() {
        return matrix[0].length;
    }
}

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

// Similar classes for finding maximum value, principal diagonal, and non-diagonal elements can be created here.

public class main2 {
    public static void main(String[] args) {
        int[][] matrixElements = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        Matrix matrix = new Matrix(matrixElements);

        Thread t1 = new DisplayElementsThread(matrix);
        Thread t2 = new TransposeMatrixThread(matrix);

        // Create and start threads for finding maximum value, principal diagonal, and non-diagonal elements here.

        t1.start();
        t2.start();

        // Start threads for finding maximum value, principal diagonal, and non-diagonal elements here.
    }
}
