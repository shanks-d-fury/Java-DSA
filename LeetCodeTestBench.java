import java.util.*;

public class LeetCodeTestBench {

    public static void main(String[] args) {
        int testArray[] = Genarate_Random.generateRandomArray(50, -500, 500);
        //
        long startTime = System.currentTimeMillis();
        //
        System.out.println(Arrays.toString(testArray));
        System.out.println(containsDuplicate(testArray));
        //
        long endTime = System.currentTimeMillis();
        long timeTaken = endTime - startTime;
        System.out.println("Time taken : " + timeTaken + " ms");
    }

    // {Given an integer array nums, return true if any value appears at least twice
    // in the array, and return false if every element is distinct.}

    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hm = new HashSet<>();
        for (int x : nums) {
            if (hm.contains(x)) {
                return true;
            } else {
                hm.add(x);
            }
        }
        return false;
    }

}
