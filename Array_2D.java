
import java.util.Scanner;

public class Array_2D {

    public static int[][] randomMatrix(int n, int m) {
        int randomMatrix[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //This is common way to write the {Math.random*(max-min+1)+ min} ;
                randomMatrix[i][j] = (int) (Math.random() * (9 - 1 + 1)) + 1;
            }
        }
        return randomMatrix;
    }

    public static void printMatrix(int matrix[][]) {
        System.out.println("The 0-1-0 matrix is : ");
        for (int[] matrix1 : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix1[j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void SprialMatrix_0_1_0(int matrix[][]) {
        int startRow = 0;
        int endRow = matrix.length - 1;
        int startCol = 0;
        int endCol = matrix[0].length - 1;
        int k = 1;
        while (startRow <= endRow && startCol <= endCol) {
            //Top
            for (int j = startCol; j <= endCol; j++) {
                // System.out.print(matrix[startRow][j] + " ");
                matrix[startRow][j] = k;
            }
            //Right
            for (int i = startRow + 1; i <= endRow; i++) {
                // System.out.print(matrix[i][endCol] + " ");
                matrix[i][endCol] = k;
            }
            //Bottom
            for (int j = endCol - 1; j >= startCol; j--) {
                // if (startRow == endRow) {
                //     break;
                // }
                // System.out.print(matrix[endRow][j] + " ");
                matrix[endRow][j] = k;
            }
            //Left
            for (int i = endRow - 1; i >= startRow + 1; i--) {
                // if (startCol == endCol) {
                //     break;
                // }
                // System.out.print(matrix[i][startCol] + " ");
                matrix[i][startCol] = k;
            }
            startCol++;
            startRow++;
            endCol--;
            endRow--;
            k = changeNum(k);
        }
        System.out.println();
    }

    public static int changeNum(int j) {
        j = j == 0 ? 1 : 0;
        return j;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("NOTE :- To get a Matrix same dimension Rows=Columns");
            System.out.print("Enter n (Rows): ");
            int n = sc.nextInt();
            System.out.print("Enter m (Columns): ");
            int m = sc.nextInt();
            // int matrix[][] = randomMatrix(n, m);
            // printMatrix(matrix);
            int matrix[][] = new int[n][m];
            SprialMatrix_0_1_0(matrix);
            printMatrix(matrix);
        }
    }
}
