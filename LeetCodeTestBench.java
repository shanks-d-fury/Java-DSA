import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LeetCodeTestBench {

    public static void main(String[] args) {
        int testArray[][] = { { 1, 4 }, { 0, 0 } };
        //
        long startTime = System.currentTimeMillis();
        //
        int[][] ansArray = mergeInterval(testArray);
        //
        long endTime = System.currentTimeMillis();
        long timeTaken = endTime - startTime;
        System.out.println("Time taken : " + timeTaken + " ms");
        for (int[] ary : ansArray) {
            for (int num : ary) {
                System.out.print(num + " ");
            }
            System.out.print("||");
        }
    }

    public static int[][] mergeInterval(int[][] intervals) {
        ArrayList<ArrayList<Integer>> arys = new ArrayList<>();
        if (intervals.length == 0) {
            return arys.stream()
                    .map(row -> row.stream().mapToInt(Integer::intValue).toArray())
                    .toArray(int[][]::new);
        }
        if (intervals.length == 1) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingDouble(o -> o[0]));
        int i;
        int prev[] = intervals[0];
        for (i = 1; i < intervals.length; i++) {
            int[] crnt = intervals[i];
            if (prev[1] >= crnt[0]) {
                prev[1] = Math.max(crnt[0], prev[1]);
            } else {
                arys.add(new ArrayList<>(List.of(prev[0], prev[1])));
                prev = intervals[i];
            }
        }
        arys.add(new ArrayList<>(List.of(prev[0], prev[1])));
        return arys.stream()
                .map(row -> row.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
    }
}
