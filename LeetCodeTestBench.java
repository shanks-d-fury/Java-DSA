
public class LeetCodeTestBench {

    public static int findClosestNumber(int[] nums) {
        // This is my original code but some partial answer
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int x = nums[i];
            if (x < 0) {
                min = min < 0 ? Math.max(min, x) : (min + x == 0 ? min : Math.min(min, x));
            } else {
                min = min < 0 ? Math.max(min, x) : Math.min(min, x);
            }
        }
        return min;

        // // The solution code is 
        // int min = Integer.MAX_VALUE;
        // for (int x : nums) {
        //     if (x + min == 0) {
        //         min = min > 0 ? min : x;
        //     } else if (Math.abs(min) > Math.abs(x)) {
        //         min = x;
        //     }
        // }
    }

    public static void main(String[] args) {
        int testAry[] = {2, 1, 1, -1, 100000};
        System.out.println(findClosestNumber(testAry));
    }
}
