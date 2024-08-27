
import java.util.Scanner;

public class Array_2D {

    public static void printMatrix(int matrix[][], String s) {
        System.out.println(s + "Matrix : ");
        for (int[] matrix1 : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix1[j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int[][] randomMatrix(int n, int m) {
        int randomMatrix[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //This is common way to write the {Math.random*(max-min+1)+ min} ;
                randomMatrix[i][j] = (int) (Math.random() * (9 - 1 + 1)) + 1;
                // randomMatrix[i][j] = 1;
            }
        }
        return randomMatrix;
    }

    public static int[][] TransposeMatrix(int matrix[][]) {
        int n = matrix.length;
        int m = matrix[0].length;
        //Even though this block is commented then it will work but , if matrix is in same dimension then Time complexity is reduced and the space complexity {O(1)} 
        if (n == m) {
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < m; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
            return matrix;
        }
        //Till here the code can be commented
        int TransposeMatrix[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                TransposeMatrix[i][j] = matrix[j][i];
            }
        }
        return TransposeMatrix;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter n (Rows): ");
            int n = sc.nextInt();
            System.out.print("Enter m (Columns): ");
            int m = sc.nextInt();
            int matrix[][] = randomMatrix(n, m);
            printMatrix(matrix, "Random ");
            int TarnsposeMatrix[][] = TransposeMatrix(matrix);
            printMatrix(TarnsposeMatrix, "Transpose ");
        }
    }
}
