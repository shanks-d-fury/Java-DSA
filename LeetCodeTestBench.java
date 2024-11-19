import java.util.ArrayList;
import java.util.List;

public class LeetCodeTestBench {

    public static void main(String[] args) {
        int testArray[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        //
        long startTime = System.currentTimeMillis();
        //
        System.out.println(spiralOrder(testArray));
        //
        long endTime = System.currentTimeMillis();
        long timeTaken = endTime - startTime;
        System.out.println("Time taken : " + timeTaken + " ms");
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> ary = new ArrayList<>();
        int startRow = 0;
        int endRow = matrix.length - 1;
        int startCol = 0;
        int endCol = matrix[0].length - 1;
        while (startRow <= endRow && startCol <= endCol) {
            // Top
            for (int j = startCol; j <= endCol; j++) {
                ary.add(matrix[startRow][j]);
            }
            // Right
            for (int i = startRow + 1; i <= endRow; i++) {
                ary.add(matrix[i][endCol]);
            }
            // Bottom
            for (int j = endCol - 1; j >= startCol; j--) {
                if (startRow == endRow) {
                    break;
                }
                ary.add(matrix[endRow][j]);
            }
            // Left
            for (int i = endRow - 1; i >= startRow + 1; i--) {
                if (startCol == endCol) {
                    break;
                }
                ary.add(matrix[i][startCol]);
            }
            startCol++;
            startRow++;
            endCol--;
            endRow--;
        }
        return ary;
    }
}
