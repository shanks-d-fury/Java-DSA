
public class LeetCodeTestBench {

    public static boolean stringPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        return s.equals(sb.reverse().toString());
    }

    public static void main(String[] args) {
        System.out.println(stringPalindrome("121"));
    }
}
