import java.util.ArrayList;
import java.util.List;

public class LeetCodeTestBench {

    public static void main(String[] args) {
        int testArray[] = { 0, 4, 5, 7 };
        //
        long startTime = System.currentTimeMillis();
        //
        System.out.println(summaryRanges(testArray));
        //
        long endTime = System.currentTimeMillis();
        long timeTaken = endTime - startTime;
        System.out.println("Time taken : " + timeTaken + " ms");

    }

    public static List<String> summaryRanges(int[] nums) {
        ArrayList<String> ans = new ArrayList<>();
        int start = nums[0];
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                if (count == 0) {
                    ans.add(Integer.toString(start));
                } else {
                    ans.add(start + "->" + nums[i - 1]);
                }
                start = nums[i];
            } else {
                count++;
            }
        }
        if (start == nums[nums.length - 1]) {
            ans.add(Integer.toString(start));
        } else {
            ans.add(start + "->" + nums[nums.length - 1]);
        }
        return ans;
    }
}
