import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCodeTestBench {

    public static void main(String[] args) {
        int testArray[] = { 0, 0, 0 };
        //
        long startTime = System.currentTimeMillis();
        //
        System.out.println(threeSum(testArray));
        //
        long endTime = System.currentTimeMillis();
        long timeTaken = endTime - startTime;
        System.out.println("Time taken : " + timeTaken + " ms");
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        System.out.println();
        List<List<Integer>> ans = new ArrayList<>();
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int x = nums[i] + nums[j];
            int k = 0;
            if (x < 0) {
                k = j - 1;
            } else if (x > 0) {
                k = i + 1;
            }
            if (x <= 0) {
                i++;
            } else if (x > 0) {
                j--;
            }
            if (x + nums[k] == 0) {
                ans.add(new ArrayList<>(List.of(nums[i], nums[j], nums[k])));
            }
        }
        return ans;
    }

}
