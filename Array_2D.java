
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

    public static void printTestMatrix(int matrix[][]) {
        System.out.println("Matrix : ");
        for (int[] matrix1 : matrix) {
            System.out.print("{");
            for (int j = 0; j < matrix[0].length; j++) {
                String S = j != matrix[0].length - 1 ? "," : "";
                System.out.print(matrix1[j] + S);
            }
            System.out.println("},");
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
        int m = matrix[0].length;
        int i = 0, j = m - 1;
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
            System.out.print("Enter n (Rows): ");
            int n = sc.nextInt();
            System.out.print("Enter m (Columns): ");
            int m = sc.nextInt();
            int matrix[][] = randomSortedMatrix(n, m);
            printMatrix(matrix);

            // //For Testing a matrix use this 
            // int matrix[][] = {{10, 20, 33, 48},
            // {20, 34, 55, 93},
            // {34, 56, 70, 122},
            // {48, 72, 122, 164},};
            // //comment out this below line to get a test matrix in printed form
            // printTestMatrix(matrix);
            //Enter the key for both the random and non-random matrix
            System.out.print("Enter key : ");
            int key = sc.nextInt();
            int AnsMat[] = SortedMatrixScreach(matrix, key);
            System.out.println(AnsMat[0] == 1 ? "Keyfound At (" + (AnsMat[1] + 1) + "," + (AnsMat[2] + 1) + ")" : "Notfound");
        }
    }
}
