
import java.util.Scanner;

public class Array_2D {

    public static void printMatrix(int matrix[][]) {
        System.out.println("The 1-0-1 matrix is : ");
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
        // int k = matrix.length - 1; // For decreasing Matrix 
        int k = 1; // for the 0-1-0 Matrix for 1-0-1 Matrix give k=1;
        while (startRow <= endRow && startCol <= endCol) {
            //Top
            for (int j = startCol; j <= endCol; j++) {
                matrix[startRow][j] = k;
            }
            //Right
            for (int i = startRow + 1; i <= endRow; i++) {
                matrix[i][endCol] = k;
            }
            //Bottom
            for (int j = endCol - 1; j >= startCol; j--) {
                matrix[endRow][j] = k;
            }
            //Left
            for (int i = endRow - 1; i >= startRow + 1; i--) {
                matrix[i][startCol] = k;
            }
            startCol++;
            startRow++;
            endCol--;
            endRow--;
            k = changeNum(k); // 0-1-0 Matrix
            // k -= 2; //odd changing Matrix
            // k--; // Simple dicreasing matrix

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
            int matrix[][] = new int[n][m];
            SprialMatrix_0_1_0(matrix);
            printMatrix(matrix);
        }
    }
}
