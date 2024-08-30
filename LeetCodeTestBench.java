
public class LeetCodeTestBench {

    public static String stringComprestion(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int count = 1;
            while (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                count++;
                i++;
            }
            sb.append(s.charAt(i));
            sb.append(count);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "";
        System.out.println(stringComprestion(s));
    }
}
