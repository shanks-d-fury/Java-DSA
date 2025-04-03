import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LeetCodeTestBench {

    public static void main(String[] args) {
        // int testArray[] = Genarate_Random.IntArray(5, 0, 10);
        // String testArray[] = { "sha", "ash", "sah", "aas", "asa", "shanks" };
        // int ary[] = Genarate_Random.IntArray(10, 0, 100);
        //
        long startTime = System.currentTimeMillis();
        //
        System.out.println("Enter a list of numbers : ");
        List<Integer> list;
        try (Scanner scanner = new Scanner(System.in)) {
            list = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt)
                    .collect(Collectors.toList());
        }
        Stream<Integer> steam = list.stream();
        steam.forEach(x -> System.out.print(x + " "));
        System.out.println(list);
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
