public class BackTracking {
    public static int gridWays(int n, int m, int i, int j) {
        if (i == n - 1 && j == m - 1) {
            return 1;
        }
        if (i > n || j > m) {
            return 0;
        }
        return gridWays(n, m, i + 1, j) + gridWays(n, m, i, j + 1);
    }

    public static long fact(long n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * fact(n - 1);
    }

    public static void main(String args[]) {

        long startTime = System.currentTimeMillis();
        //
        long n = 10, m = 10;
        // the grid ways method has a huge time complexity O(2^n+m);
        // System.out.println(gridWays(n, m, 0, 0));
        // to decrese the time complexity we use a simple permutation formula

        // The fact is a linear time complexity so we use it insted of the gridways
        // formula
        System.out.println(fact((n - 1 + m - 1)) / (fact((n - 1)) * fact((m - 1))));
        //
        long endTime = System.currentTimeMillis();
        //

        //
        long timeTaken = endTime - startTime;
        System.out.println("\nTime taken : " + timeTaken + " ms\n");
    }
}
