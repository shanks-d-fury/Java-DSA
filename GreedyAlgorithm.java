import java.util.Arrays;
import java.util.Comparator;

public class GreedyAlgorithm {
    public static void main(String args[]) {
        int ans;
        int chainPair[][] = { { 5, 24 }, { 39, 60 }, { 5, 28 }, { 27, 40 }, { 50, 90 } };

        // start the count
        Arrays.sort(chainPair, Comparator.comparingDouble(o -> o[1]));
        ans = 1;
        int endLength = chainPair[0][1];
        for (int[] chainPair1 : chainPair) {
            if (chainPair1[0] >= endLength) {
                ans++;
                endLength = chainPair1[1];
            }
        }
        System.out.println("Max chain pair is : " + ans);
    }
}
