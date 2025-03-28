import java.util.*;
import java.util.stream.Collectors;

public class LeetCodeTestBench {

    public static void main(String[] args) {
        // int testArray[] = Genarate_Random.IntArray(5, 0, 10);
        // String testArray[] = { "sha", "ash", "sah", "aas", "asa", "shanks" };
        int ary[] = Genarate_Random.IntArray(10, 0, 100);
        //

        // This is first converted to list and then sorted using the collections.sorts
        List<Integer> list = Arrays.stream(ary).boxed().collect(Collectors.toList());
        Collections.sort(list, (a, b) -> a - b);
        System.out.println(list);

        // This is sorted by converting the element in the Interger and sorting
        ary = Arrays.stream(ary).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(ary));
        long startTime = System.currentTimeMillis();
        //
        // System.out.println(longestConsecutive(testArray));
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
}
