
import java.util.Scanner;

public class Array_2D {

    public static void printMatrix(int matrix[][]) {
        System.out.println("Matrix : ");
        for (int[] matrix1 : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix1[j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int[][] randomSortedMatrix(int n, int m) {
        int randomMatrix[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    randomMatrix[i][j] = (int) (Math.random() * (10 - 10 + 1)) + 10;
                    continue;
                }
                if (i != 0 && j == 0) {
                    randomMatrix[i][j] = randomMatrix[i - 1][j] + (int) (Math.random() * (10 - randomMatrix[i - 1][j] + 1)) + randomMatrix[i - 1][j];
                    continue;
                }
                randomMatrix[i][j] = randomMatrix[i][j - 1] + (int) (Math.random() * (10 - randomMatrix[i][j - 1] + 1)) + randomMatrix[i][j - 1];
            }
        }
        return randomMatrix;
    }

    public static int[] SortedMatrixScreach(int matrix[][], int key) {
        int n = matrix.length;
        int i = 0, j = n - 1;
        int retMat[] = new int[3];
        while (i < n && j >= 0) {
            if (matrix[i][j] == key) {
                retMat[0] = 1;
                retMat[1] = i;
                retMat[2] = j;
                return retMat;
            } else if (key < matrix[i][j]) {
                j--;
            } else if (key > matrix[i][j]) {
                i++;
            }
        }
        return retMat;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter n : ");
            int n = sc.nextInt();
            int matrix[][] = randomSortedMatrix(n, n);
            printMatrix(matrix);
            System.out.print("Enter key : ");
            int key = sc.nextInt();
            int AnsMat[] = SortedMatrixScreach(matrix, key);
            System.out.println(AnsMat[0] == 1 ? "Keyfound At (" + (AnsMat[1] + 1) + "," + (AnsMat[2] + 1) + ")" : "Notfound");
        }
    }
}
