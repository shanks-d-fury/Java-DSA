import java.util.Arrays;

public class LeetCodeTestBench {

    public static void main(String[] args) {
        String testArray[] = { "slow", "slower", "slowest" };
        System.out.println(longestCommonPrefix(testArray));
    }

    public static String longestCommonPrefix(String[] strs) {
        String lcp = new String();
        int i = 0;
        String minString = Arrays.stream(strs)
                .min((s1, s2) -> Integer.compare(s1.length(), s2.length()))
                .orElse(null);
        while (i < minString.length()) {
            char x = minString.charAt(i);
            for (String str : strs) {
                if (x != str.charAt(i)) {
                    return lcp;
                }
            }
            lcp += x;
            i++;
        }
        return lcp;
    }
}
