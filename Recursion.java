
public class Recursion {

    private static Object console;

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        // System.out.println(tails2_1(5));
        boolean map[] = new boolean[26];
        // for (boolean x : map) {
        //     System.out.println(x);
        // }
        System.out.println(removeDuplicate("asdgadsfg", 0, map, ""));
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

    public static String removeDuplicate(String s, int indx, boolean map[], String newx) {
        if (indx == s.length()) {
            return newx;
        }
        if (!map[s.charAt(indx) - 'a']) {
            map[s.charAt(indx) - 'a'] = true;
            newx = newx + s.charAt(indx);
        }
        indx++;
        return removeDuplicate(s, indx, map, newx);
    }
}
