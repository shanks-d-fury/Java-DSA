import java.util.*;
import java.util.stream.*;

public class LeetCodeTestBench {

    public static void main(String[] args) {
        //
        //
        System.out.println("Enter a list of numbers : ");
        double[] list;
        try (Scanner scanner = new Scanner(System.in)) {
            list = Arrays.stream(scanner.nextLine().split(" ")).map(Double::parseDouble)
                    .sorted(Comparator.reverseOrder())
                    .mapToDouble(Double::doubleValue).toArray();
        }
        long startTime = System.currentTimeMillis();

        DoubleStream steam = Arrays.stream(list);
        Stream<Integer> steam2 = Arrays.stream(list).boxed().mapToInt(Double::intValue).boxed();
        steam2.forEach(x -> System.out.print(x + " "));
        System.out.println(steam.average().orElse(-1));
        System.out.println(Arrays.toString(list));
        //
        // Comparator<Integer> com = Comparator.comparingInt(Integer::intValue);
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
