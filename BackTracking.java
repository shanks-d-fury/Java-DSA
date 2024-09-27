import java.util.Random;

public class BackTracking {
    public static boolean suduko(int board[][], int row, int col) {
        if (row == 9) {
            return true;
        }
        int newRow = row, newCol = col + 1;
        if (col + 1 == 9) {
            newRow = row + 1;
            newCol = 0;
        }
        if (board[row][col] != 0) {
            return suduko(board, newRow, newCol);
        }
        for (int digit = 1; digit <= 9; digit++) {
            if (isSafe(board, row, col, digit)) {
                board[row][col] = digit;
                if (suduko(board, newRow, newCol)) {
                    return true;
                }
                board[row][col] = 0;
            }
        }
        return false;
    }

    public static boolean isSafe(int board[][], int row, int col, int digit) {

        // checking in the row
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == digit) {
                return false;
            }
        }

        // checking in the column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == digit) {
                return false;
            }
        }

        // checking in the 3x3 grid
        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;
        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (board[i][j] == digit) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void fillRandom(int board[][], int ctf) {
        // ctf is cells to fill && inf is initial fill
        int inf = 0;
        while (inf < ctf) {
            int row = rN();
            int col = rN();
            int num = rN();
            if (board[row][col] == 0 && isSafe(board, row, col, num)) {
                board[row][col] = num;
                inf++;
            }
        }
    }

    public static int rN() {
        Random rand = new Random();
        return rand.nextInt(9);
    }

    public static void printBoard(int board[][]) {
        System.out.println("\n------Suduko-------");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        int board[][] = new int[9][9];

        // cells to fill is ctf
        int ctf = 10; // optimal ctf is 20
        fillRandom(board, ctf);
        printBoard(board);
        long startTime = System.currentTimeMillis();
        //
        if (suduko(board, 0, 0)) {
            printBoard(board);
        } else {
            System.out.println("solution doesn't exist");
        }
        //
        long endTime = System.currentTimeMillis();
        //

        //
        long timeTaken = endTime - startTime;
        System.out.println("\nTime taken : " + timeTaken + " ms\n");
    }
}
