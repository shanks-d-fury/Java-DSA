
public class DynamicProgramming {
    public static void main(String args[]) {
        long startTime = System.currentTimeMillis();
        //
        int n = 30;
        // System.out.println(fabnormal(n));
        System.out.println(fabdp(n, new int[n + 1]));
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
}
