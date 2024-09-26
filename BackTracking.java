public class BackTracking {
    static int count = 0;

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

    public static boolean nQueens(char board[][], int row) {
        if (row == board.length) {
            // printBoard(board);
            count++;
            return true;
        }
        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';
                if (nQueens(board, row + 1)) {
                    return true;
                }
                board[row][j] = '.';
            }
        }
        return false;
    }

    public static void printBoard(char board[][]) {
        System.out.println("\t------ Board ------");
        System.out.print("\t  ");
        for (int i = 1; i <= board.length; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        int i = 1;
        for (char[] board1 : board) {
            System.out.print("\t" + i++ + " ");
            for (int j = 0; j < board.length; j++) {
                System.out.print(board1[j] + " ");
            }
            System.out.println();
        }
    }

    public static void initilzeBoard(char board[][]) {
        for (char[] board1 : board) {
            for (int j = 0; j < board.length; j++) {
                board1[j] = '.';
            }
        }
    }

    public static void main(String args[]) {
        int n = 9;
        char board[][] = new char[n][n];
        initilzeBoard(board);
        long startTime = System.currentTimeMillis();
        //
        if (nQueens(board, 0)) {
            printBoard(board);
        }
        System.out.println("\n" + count);
        //
        long endTime = System.currentTimeMillis();
        //

        //
        long timeTaken = endTime - startTime;
        System.out.println("\nTime taken : " + timeTaken + " ms\n");
    }
}
