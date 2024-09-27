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

    public static void main(String args[]) {

        long startTime = System.currentTimeMillis();
        //
        int n = 5, m = 5;
        System.out.println(gridWays(n, m, 0, 0));

        //
        long endTime = System.currentTimeMillis();
        //

        //
        long timeTaken = endTime - startTime;
        System.out.println("\nTime taken : " + timeTaken + " ms\n");
    }
}
