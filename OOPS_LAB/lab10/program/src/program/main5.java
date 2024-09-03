package program;

import java.util.Scanner;

public class main5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows and columns of the matrix: ");
        int n = scanner.nextInt();

        int[][] matrix = new int[n][n];

        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        boolean isSquareMatrix = isSquare(matrix);

        if (isSquareMatrix) {
            System.out.println("The given matrix is a square matrix.");
        } else {
            System.out.println("The given matrix is not a square matrix.");
        }

        scanner.close();
    }

    public static boolean isSquare(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        return rows == columns;
    }
}
