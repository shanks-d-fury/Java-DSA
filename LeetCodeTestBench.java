import java.util.*;

public class LeetCodeTestBench {

    public static void main(String[] args) {
        // int testArray[] = Genarate_Random.generateRandomArray(5, -500, 500);
        //
        long startTime = System.currentTimeMillis();
        //
        // System.out.println(Arrays.toString(testArray));
        System.out.println(maxNumberOfBalloons("loonbalxballpoon"));
        //
        long endTime = System.currentTimeMillis();
        long timeTaken = endTime - startTime;
        System.out.println("Time taken : " + timeTaken + " ms");
    }

    // {Given a string text, you want to use the characters of text to form as many
    // instances of the word "balloon" as possible.You can use each character in
    // text at most once. Return the maximum number of instances that can be
    // formed.}

    public static int maxNumberOfBalloons(String text) {
        if (text.length() < "balloon".length()) {
            return 0;
        }
        HashMap<Character, Integer> hm = new HashMap<>();
        String bln = "balon";
        for (char x : text.toCharArray())
            if (bln.contains(String.valueOf(x)))
                hm.put(x, hm.getOrDefault(x, 0) + 1);
        int count = Integer.MAX_VALUE;
        for (char x : bln.toCharArray()) {
            if (!hm.containsKey(x)) {
                return 0;
            }
            count = (x == 'l' || x == 'o') ? Math.min(count, hm.getOrDefault(x, 0) / 2)
                    : Math.min(count, hm.getOrDefault(x, 0));
        }
        return count;
    }
}
