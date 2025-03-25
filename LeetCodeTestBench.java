import java.util.*;

public class LeetCodeTestBench {

    public static void main(String[] args) {
        // int testArray[] = Genarate_Random.IntArray(5, -5, 5);
        // int testArray[] = { 2, -5, -5, 2, -4 };
        //
        long startTime = System.currentTimeMillis();
        //
        // System.out.println(Arrays.toString(twoSum(testArray, -4)));
        //
        long endTime = System.currentTimeMillis();
        long timeTaken = endTime - startTime;
        System.out.println("Time taken : " + timeTaken + " ms\n");
    }

    public static boolean isValidSudoku(char[][] board) {
        HashSet<Character> hs = new HashSet<>();
        // check the row
        for (int i = 0; i < board.length; i++) {
            hs.clear();
            for (int j = 0; j < board[0].length; j++) {
                char x = board[i][j];
                if (hs.contains(x))
                    return false;
                else if (x != '.')
                    hs.add(x);
            }
        }
        // check for columns
        for (int i = 0; i < board.length; i++) {
            hs.clear();
            for (int j = 0; j < board[0].length; j++) {
                char x = board[j][i];
                if (hs.contains(x))
                    return false;
                else if (x != '.')
                    hs.add(x);
            }
        }

        // checking for the 3*3 matrix
        for (int i = 0; i < 3; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                hs.clear();
                for (int row = i; row < i + 3; row++) {
                    for (int col = j; col < j + 3; col++) {
                        char x = board[row][col];
                        if (hs.contains(x))
                            return false;
                        else if (x != '.')
                            hs.add(x);
                    }
                }
            }
        }

        return true;
    }
}
