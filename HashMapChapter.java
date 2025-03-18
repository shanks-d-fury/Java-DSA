import java.util.Arrays;
import java.util.HashMap;

public class HashMapChapter {
    public static void main(String[] args) {
        // Largest subarray length which has the sum zero
        HashMap<Integer, Integer> hm = new HashMap<>();
        int ary[] = Genarate_Random.generateRandomArray(4, -1, 5);
        System.out.println(Arrays.toString(ary));
        int sum = 0, len = 0;
        for (int j = 0; j < ary.length; j++) {
            sum += ary[j];
            if (hm.containsKey(sum)) {
                len = Math.max(j - hm.get(sum), len);
            } else {
                hm.put(sum, j);
            }
        }
        System.out.println(hm);
        System.out.println("SubArray with sum 0 => " + len);
    }
}