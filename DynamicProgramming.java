import java.util.Arrays;

public class DynamicProgramming {
    public static void main(String args[]) {
        long startTime = System.currentTimeMillis();
        //
        int n = 3;
        System.out.println(climbingStaris(n));
        // int[] ways = new int[n + 1];
        // Arrays.fill(ways, -1);
        // System.out.println(climbingStarisDP(n, ways));
        // System.out.println(climbingStarisDPtab(n));
        //
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken : " + (endTime - startTime) + " ms\n");
    }

    public static int fabnormal(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fabnormal(n - 1) + fabnormal(n - 2);
    }

    public static int fabdp(int n, int[] f) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (f[n] != 0) {
            return f[n];
        }
        f[n] = fabdp(n - 1, f) + fabdp(n - 2, f);
        return f[n];
    }

    // recursion for a special case where the person can climb one/two/three strais
    // at a time
    public static int climbingStaris(int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        return climbingStaris(n - 1) + climbingStaris(n - 2) + climbingStaris(n - 3);
    }

    // DP
    public static int climbingStarisDP(int n, int ways[]) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        if (ways[n] != -1) {
            return ways[n];
        }
        ways[n] = climbingStarisDP(n - 1, ways) + climbingStarisDP(n - 2, ways);
        return ways[n];
    }

    public static int climbingStarisDPtab(int n) {
        int ways[] = new int[n + 1];
        ways[0] = 1;
        ways[1] = 1;
        ways[2] = 2;
        for (int i = 3; i <= n; i++) {
            ways[i] = ways[i - 1] + ways[i - 2];
        }
        System.out.println(Arrays.toString(ways));
        ;
        return ways[n];
    }
}
