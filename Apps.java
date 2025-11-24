
import java.util.*;

public class Apps {
    public static int[] findIndexes(int input[], int x, int index, ArrayList<Integer> ary) {
        if (index == input.length) {
            return ary.stream().mapToInt(Integer::intValue).toArray();
        }
        if (x == input[index]) {
            ary.add(index);
        }
        return findIndexes(input, x, index + 1, ary);
    }

    public static void main(String[] args) {
        int[] input = Genarate_Random.IntArray(1, 0, 1);
        int[] ans = findIndexes(input, 1, 0, new ArrayList<>());
        System.out.println(Arrays.toString(ans));
        System.out.println(Arrays.stream(ans).max().orElse(-1));
        this line is a error which should be picked from the ai changed again for check number 29

    }
}
