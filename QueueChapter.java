
import java.util.LinkedList;
import java.util.Queue;

public class QueueChapter {
    public static String interLeave_2_halves(int[] ary) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for (int i = 0; i < ary.length; i++) {
            if (i < ary.length / 2) {
                q1.add(ary[i]);
            } else {
                q2.add(ary[i]);
            }
        }
        StringBuilder sx = new StringBuilder();
        while (!q1.isEmpty() && !q2.isEmpty()) {
            sx.append(q1.remove());
            sx.append(" ");
            sx.append(q2.remove());
            sx.append(" ");
        }
        return sx.toString();
    }

    public static void main(String args[]) {
        int input[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        System.out.println(interLeave_2_halves(input));
    }
}
