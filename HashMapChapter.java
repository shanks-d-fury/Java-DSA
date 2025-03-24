import java.util.Arrays;
import java.util.HashMap;

public class HashMapChapter {
    public static void main(String[] args) {
        // Largest subarray length which has the sum equal to k
        int k = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int ary[] = Genarate_Random.generateRandomIntArray(10, -10, 10);
        System.out.println(Arrays.toString(ary));
        int sum = 0, count = 0;
        for (int j = 0; j < ary.length; j++) {
            sum += ary[j];
            if (hm.containsKey(sum - k)) {
                count += hm.get(sum - k);
            }
            hm.put(sum, hm.getOrDefault(sum, 0) + 1);
        }
        System.out.println(hm + " k=" + k);
        System.out.println("SubArray with sum 0 => " + count);
    }
}