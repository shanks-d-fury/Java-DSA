import java.util.*;

public class LeetCodeTestBench {

    public static void main(String[] args) {
        // int testArray[] = Genarate_Random.IntArray(5, -5, 5);
        int testArray[] = { 2, -5, -5, 2, -4 };
        //
        long startTime = System.currentTimeMillis();
        //
        System.out.println(Arrays.toString(twoSum(testArray, -4)));
        //
        long endTime = System.currentTimeMillis();
        long timeTaken = endTime - startTime;
        System.out.println("Time taken : " + timeTaken + " ms\n");
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int comp = target - nums[i];
            if (hm.containsKey(comp)) {
                return new int[] { hm.get(comp).get(0), i };
            }
            hm.putIfAbsent(nums[i], new ArrayList<>());
            hm.get(nums[i]).add(i);
        }
        return new int[] { -1, -1 };
    }
}
