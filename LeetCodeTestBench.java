import java.util.*;

public class LeetCodeTestBench {

    public static void main(String[] args) {
        //
        long startTime = System.currentTimeMillis();
        //

        // int nums[] = Genarate_Random.IntArray(5, 0, 5);
        // System.out.println(findKthLargest(nums, 2));
        // System.out.println((int) ('n' - 'a'));
        // System.out.println();
        // backonarray(new int[5], 0);
        // permutation("abcdefgh", "");
        System.out.println("end of the answer");
        //
        long endTime = System.currentTimeMillis();
        long timeTaken = endTime - startTime;
        System.out.println("Time taken : " + timeTaken + " ms\n");
    }

    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;

        TreeSet<Integer> ts = new TreeSet<>();
        for (int num : nums) {
            ts.add(num);
        }

        int curnt = 1, max = 1;
        Integer prev = null;

        for (int value : ts) {
            if (prev != null) {
                if (value == prev + 1) {
                    curnt++;
                    max = Math.max(max, curnt);
                } else {
                    curnt = 1;
                }
            }
            prev = value;
        }

        return max;
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : nums) {
            pq.add(num);
        }
        System.out.println(pq);
        int count = 1;
        while (count < k) {

            pq.remove();
            System.out.println(pq + " " + count);
            count++;
        }
        return pq.peek();
    }

    public static void backonarray(int[] ary, int i) {
        if (i == ary.length) {
            System.out.println(Arrays.toString(ary));
            return;
        }
        ary[i] = i + 1;
        backonarray(ary, i + 1);
        ary[i] = ary[i] - 2;
        if (i == 0) {
            System.out.println(Arrays.toString(ary));
        }
    }

    public static void findSubset(String s, String x, int i) {
        if (i == s.length()) {
            System.out.println(x);
            return;
        }
        findSubset(s, x + s.charAt(i), i + 1);
        findSubset(s, x, i + 1);
    }

    public static void permutation(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            String newStr = str.substring(0, i) + str.substring(i + 1, str.length());
            permutation(newStr, ans + str.charAt(i));
        }
    }
}
