
public class Recursion {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println(tails2_1(4));
        long endTime = System.currentTimeMillis();
        long timeTaken = endTime - startTime;
        System.out.println("Time taken : " + timeTaken + " ms");
    }

    public static int tails2_1(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return tails2_1(n - 1) + tails2_1(n - 2);
    }
}
