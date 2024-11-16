
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class GreedyAlgorithm {
    public static void main(String args[]) {
        int start[] = { 1, 3, 0, 5, 8, 5 };
        int end[] = { 2, 8, 6, 9, 9, 7 };

        int maxAct;
        ArrayList<Integer> ary = new ArrayList<>();
        int Selections[][] = new int[start.length][3];
        // start the selection
        for (int i = 0; i < start.length; i++) {
            Selections[i][0] = i;
            Selections[i][1] = start[i];
            Selections[i][2] = end[i];
        }
        System.out.println("Before");
        for (int[] Selection : Selections) {
            System.out.println(Selection[0] + " " + Selection[1] + " " + Selection[2]);
        }
        Arrays.sort(Selections, Comparator.comparingDouble(o -> o[2]));
        System.out.println("After");
        for (int[] Selection : Selections) {
            System.out.println(Selection[0] + " " + Selection[1] + " " + Selection[2]);
        }
        maxAct = 1;
        ary.add(Selections[0][0]);
        int lastEnd = Selections[0][2];

        for (int i = 0; i < end.length; i++) {
            if (Selections[i][1] >= lastEnd) {
                // select activity
                maxAct++;
                ary.add(Selections[i][0]);
                lastEnd = Selections[i][2];
            }
        }

        System.out.println("max activity :" + maxAct);
        for (Integer i : ary) {
            System.out.print("A" + i + " ");
        }
    }
}
