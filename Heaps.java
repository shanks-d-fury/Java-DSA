
import java.util.Arrays;
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
            // return this.data - s2.data;
            return s2.data - this.data;
        }
    }

    public static void main(String[] args) {
        // Maximum element in the k'size subarray
        PriorityQueue<Info> pq = new PriorityQueue<>();
        int[] ary = { -5, -3, 0, -5, 5, -1, 5 };
        // int[] ary = Genarate_Random.generateRandomArray(20, -5, 5);
        int k = 3;
        int[] result = new int[ary.length - k + 1];
        System.out.println(Arrays.toString(ary));

        for (int i = 0; i < k; i++) {
            pq.add(new Info(ary[i], i));
        }
        result[0] = pq.peek().data;
        for (int i = 3, j = 1; i < ary.length; i++, j++) {
            while (!pq.isEmpty() && pq.peek().idx <= (i - k))
                pq.remove();
            pq.add(new Info(ary[i], i));
            result[j] = pq.peek().data;
        }
        String x[] = Arrays.toString(result).replaceAll("[\\[\\]]", "").split(",\\s*");
        for (String y : x) {
            System.out.print(y + " ");
        }
    }
}
