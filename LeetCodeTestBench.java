import java.util.*;
import java.util.stream.Collectors;

public class LeetCodeTestBench {

    public static void main(String[] args) {
        //
        //
        long startTime = System.currentTimeMillis();
        List<Integer> list1 = Arrays.asList(5, 1, 5, 6, 3, 2);
        List<Integer> list2 = Arrays.asList(1, 2, 3);
        List<Integer> list3 = Arrays.asList();
        List<List<Integer>> outerList = new ArrayList<>(Arrays.asList(list1, list2, list3));
        // Collections.sort(outerList, Comparator.comparing(List::size));
        // outerList = outerList.stream().sorted().collect(Collectors.toList());
        System.out.println(outerList);
        outerList = outerList.stream()
                .map(list -> new ArrayList<>(Collections.singletonList(
                        list.stream().reduce(0, Integer::sum))))
                .sorted(Comparator.comparing(list -> list.isEmpty() ? null : list.get(0))).collect(Collectors.toList());
        list1 = list1.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println(list1);
        System.out.println(outerList);

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
