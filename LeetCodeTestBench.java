import java.util.*;

public class LeetCodeTestBench {

    public static void main(String[] args) {
        // int testArray[] = { 0, 0, 0 };
        //
        long startTime = System.currentTimeMillis();
        //
        System.out.println(getStones("sha", "shnaks"));
        //
        long endTime = System.currentTimeMillis();
        long timeTaken = endTime - startTime;
        System.out.println("Time taken : " + timeTaken + " ms");
    }

    // {You're given strings jewels representing the types of stones that are
    // jewels, and stones representing the stones you have. Each character in stones
    // is a type of stone you have. You want to know how many of the stones you have
    // are also jewels.Letters are case sensitive, so "a" is considered a different
    // type of stone from "A".}

    public static int getStones(String jewels, String stones) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (char x : jewels.toCharArray()) {
            hm.put(x, 0);
        }
        for (char y : stones.toCharArray()) {
            if (hm.get(y) != null) {
                hm.put(y, hm.get(y) + 1);
            }
        }
        int count = 0;
        for (Map.Entry<Character, Integer> map : hm.entrySet()) {
            count += map.getValue();
        }
        return count;
    }

}
