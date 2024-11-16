
import java.util.ArrayList;

public class GreedyAlgorithm {
    public static void main(String args[]) {
        int start[] = { 1, 3, 0, 5, 8, 5 };
        int end[] = { 2, 4, 6, 7, 9, 9 };

        int maxAct;
        ArrayList<Integer> ary = new ArrayList<>();

        // start the selection
        maxAct = 1;
        ary.add(0);
        int lastEnd = end[0];

        for (int i = 0; i < end.length; i++) {
            if (start[i] >= lastEnd) {
                // select activity
                maxAct++;
                ary.add(i);
                lastEnd = end[i];
            }
        }

        System.out.println("max activity :" + maxAct);
        for (Integer i : ary) {
            System.out.print("A" + i + " ");
        }
    }
}
