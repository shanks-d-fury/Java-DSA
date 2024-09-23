import java.util.Arrays;

public class LeetCodeTestBench {

    public static void main(String[] args) {
        String testArray[] = { "slow", "slower", "slowest" };
        System.out.println(longestCommonPrefix(testArray));
    }

    public static String longestCommonPrefix(String[] strs) {
        String lcp = new String();
        Arrays.sort(strs);
        String mString = Arrays.stream(strs).min((s1, s2) -> Integer.compare(s1.length(), s2.length())).orElse(null);
        for (int i = 0; i < mString.length(); i++) {
            if (strs[0].charAt(i) != strs[strs.length - 1].charAt(i)) {
                return lcp;
            }
            lcp += strs[0].charAt(i);
        }
        return lcp;
    }
}
