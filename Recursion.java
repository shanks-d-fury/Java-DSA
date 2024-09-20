
public class Recursion {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println(frindsParing(10));
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

    public static int frindsParing(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        return frindsParing(n - 1) + (n - 1) * frindsParing(n - 2);
    }
}
