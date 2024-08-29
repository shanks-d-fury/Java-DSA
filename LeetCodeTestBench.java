
public class LeetCodeTestBench {

    public static String mergeAlternately(String word1, String word2) {
        int i;
        String s = new String();
        char[] word1x = word1.toCharArray();
        char[] word2x = word2.toCharArray();
        int min = Math.min(word1x.length, word2x.length);
        for (i = 0; i < min; i++) {
            s += word1x[i];
            s += word2x[i];
        }
        if (word1x.length > word2x.length) {
            s += word1.substring(i, word1.length());
        } else {
            s += word2.substring(i, word2.length());
        }
        // s+=word1.substring(i,word1.length());
        return s;
    }

    public static void main(String[] args) {
        // int testAry[] = {2, 1, 1, -1, 100000};
        System.out.println(mergeAlternately("ab", "pqrsss"));
    }
}
