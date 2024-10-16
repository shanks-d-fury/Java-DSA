
import java.util.LinkedList;
import java.util.Queue;

public class QueueChapter {
    public static Queue<Integer> interLeave_2_halves(Queue<Integer> q) {
        int i = 0;
        int size = q.size();
        Queue<Integer> q1 = new LinkedList<>();
        while (i < size / 2) {
            q1.add(q.remove());
            i++;
        }
        while (!q1.isEmpty()) {
            q.add(q1.remove());
            q.add(q.remove());
        }
        return q;
    }

    public static void main(String args[]) {
        int input[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        Queue<Integer> qx = new LinkedList<>();
        for (int x : input) {
            qx.add(x);
        }
        Queue<Integer> q = interLeave_2_halves(qx);
        while (!q.isEmpty()) {
            System.out.print(q.remove() + " ");
        }
    }
}
