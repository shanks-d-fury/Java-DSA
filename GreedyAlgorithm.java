
import java.util.Arrays;

public class GreedyAlgorithm {
    public static void main(String args[]) {
        int vertical[] = { 2, 1, 3, 1, 4 };
        int horizontal[] = { 4, 1, 2 };
        int vi = vertical.length - 1;
        int hj = horizontal.length - 1;
        int vpart = 1;
        int hpart = 1;
        int totalCost = 0;
        Arrays.sort(vertical);
        Arrays.sort(horizontal);

        while (vi >= 0 && hj >= 0) {
            if (horizontal[hj] >= vertical[vi]) {
                totalCost += (vpart * horizontal[hj]);
                hpart++;
                hj--;
            } else {
                totalCost += (hpart * vertical[vi]);
                vpart++;
                vi--;
            }
        }
        while (vi >= 0) {
            totalCost += (hpart * vertical[vi]);
            vpart++;
            vi--;
        }
        while (hj >= 0) {
            totalCost += (vpart * horizontal[hj]);
            hpart++;
            hj--;
        }
        System.out.println("Total Minimum cost of cutting is : " + totalCost);
    }
}
