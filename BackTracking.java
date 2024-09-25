public class BackTracking {

    public static boolean isSafe(char board[][], int row, int col) {
        // top vertical
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        // top left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // top right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void nQueens(char board[][], int row) {
        if (row == board.length) {
            printBoard(board);
            return;
        }
        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';
                nQueens(board, row + 1);
                board[row][j] = 'x';
            }
        }
    }

    public static void printBoard(char board[][]) {
        System.out.println("--------- Board -----------");
        for (char[] board1 : board) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board1[j] + " ");
            }
            System.out.println();
        }
    }

    public static void initilzeBoard(char board[][]) {
        for (char[] board1 : board) {
            for (int j = 0; j < board.length; j++) {
                board1[j] = 'x';
            }
        }
    }

    public static void main(String args[]) {
        int n = 4;
        char board[][] = new char[n][n];
        initilzeBoard(board);
        long startTime = System.currentTimeMillis();
        //
        nQueens(board, 0);
        //
        long endTime = System.currentTimeMillis();
        //

        //
        long timeTaken = endTime - startTime;
        System.out.println("\nTime taken : " + timeTaken + " ms\n");
    }
}
