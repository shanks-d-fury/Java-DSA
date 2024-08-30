
public class LeetCodeTestBench {

    public static boolean checkPalidrome(String s) {
        // System.out.println(s.length());
        s = s.toLowerCase();
        String sx = new String();
        for (int k = 0; k < s.length(); k++) {
            char c = s.charAt(k);
            int x = c - '0';
            if ((c >= 'a' && c <= 'z') || x >= 0 && x <= 9) {
                sx += s.charAt(k);
            }
        }
        // System.out.println(sx + " " + sx.length());
        int i = 0, j = sx.length() - 1;
        while (i < j) {
            if (sx.charAt(i) != sx.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkPalidrome("0P"));
    }
}
