
import java.util.Arrays;

public class LeetCodeTestBench {

    public static boolean checkAnagram(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        return Arrays.equals(c1, c2);
    }

    public static void main(String[] args) {
        String s1 = "mama";
        String s2 = "amma";
        System.out.println(checkAnagram(s1, s2));
    }
}
