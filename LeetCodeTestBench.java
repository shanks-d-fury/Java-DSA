
public class LeetCodeTestBench {

    public static String stringComprestion(String s) {
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                sb.append(s.charAt(i - 1));
                sb.append(count);
                count = 1;
                continue;
            }
            count++;
            if (i == s.length() - 1) {
                sb.append(s.charAt(i));
                sb.append(count);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "aaabbcccddeeeeccccccc";
        System.out.println(stringComprestion(s));
    }
}
