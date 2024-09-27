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

    public static void fillRandom(int board[][]) {
        Random rand = new Random();
        for (int i = 0; i < 9; i++) {
            int col = rand.nextInt(1, 9);
            board[i][col] = rand.nextInt(1, 10);
        }
    }

    public static void printBoard(int board[][]) {
        System.out.println("\n------Board-------");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        int board[][] = new int[9][9];
        fillRandom(board);
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

// Random rand = new Random();
// int[] array = new int[size];
// for (int i = 0; i < size; i++) {
// array[i] = rand.nextInt((max - min) + 1) + min;
// }
