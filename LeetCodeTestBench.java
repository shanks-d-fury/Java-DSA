
public class LeetCodeTestBench {

    public static void main(String[] args) {
        int testArray[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        //
        long startTime = System.currentTimeMillis();
        //
        rotate(testArray);
        //
        long endTime = System.currentTimeMillis();
        long timeTaken = endTime - startTime;
        System.out.println("Time taken : " + timeTaken + " ms");
    }

    public static void rotate(int[][] matrix) {
        for (int[] mat : matrix) {
            for (int num : mat) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        System.out.println();
        int n = matrix.length - 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int[] mat : matrix) {
            for (int num : mat) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i < (matrix.length) / 2; i++) {
            for (int[] matx : matrix) {
                int temp = matx[i];
                matx[i] = matx[n - i];
                matx[n - i] = temp;
            }
        }
        for (int[] mat : matrix) {
            for (int num : mat) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

    }
}
