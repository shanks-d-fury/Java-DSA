
public class LeetCodeTestBench {

    public static String firstLetterCaptial(String s) {
        boolean toCap = true;
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (toCap) {
                sb.append(Character.toUpperCase(c));
                toCap = false;
            } else {
                sb.append(c);
            }
            if (c == ' ') {
                toCap = true;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "StringBuilder is a mutable sequence of characters in Java, which is particularly useful in scenarios where you need to perform a lot of modifications on strings, such as appending, inserting, or deleting characters. It is often used in competitive programming and coding platforms like LeetCode because it offers better performance than String when it comes to string manipulation";
        System.out.println(firstLetterCaptial(s));

        // For  Primitive  Types  And  A  Tuned  Mergesort  For  Objects,  Providing  A  Balance  Between  Performance  And  Stability
    }
}
