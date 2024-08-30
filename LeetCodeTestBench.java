
public class LeetCodeTestBench {

    public static boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) {
            return true;
        }
        int i, j;
        for (j = 0, i = 0; j < t.length(); j++) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                if (i == s.length()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("abs", ""));
    }
}
