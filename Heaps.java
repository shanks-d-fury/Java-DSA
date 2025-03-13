
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Heaps {
    static class Info implements Comparable<Info> {
        int data;
        int idx;

        Info(int data, int idx) {
            this.data = data;
            this.idx = idx;
        }

        @Override
        public int compareTo(Info s2) {
            return this.data - s2.data;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.reverseOrder());
        // int[] ary = Genarate_Random.generateRandomArray(7, -5, 5);
        int[] ary = { -5, -3, 0, -5, 5, -1, 5 };
        System.out.println(Arrays.toString(ary));
        pq.add(new Info(ary[0], 0));
        pq.add(new Info(ary[1], 1));
        pq.add(new Info(ary[2], 2));
        int k = 3;
        int[] result = new int[ary.length - k + 1];
        result[0] = pq.peek().data;
        for (int i = 3, j = 1; i < ary.length; i++, j++) {
            while (pq.peek().idx <= (i - k))
                pq.remove();
            pq.add(new Info(ary[i], i));
            result[j] = pq.peek().data;
        }
        System.out.println(Arrays.toString(result));
    }
}
