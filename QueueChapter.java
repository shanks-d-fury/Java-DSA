
import java.util.LinkedList;
import java.util.Queue;

public class QueueChapter {
    public static void firstNonRepetingChar(String s) {
        int freq[] = new int[26];
        Queue<Character> q = new LinkedList<>();
        for (char c : s.toCharArray()) {
            int idx = c - ' ' - 65;
            freq[idx]++;
            q.add(c);
            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                q.remove();
            }
            if (q.isEmpty()) {
                System.out.print(-1 + " ");
            } else {
                System.out.print(q.peek() + " ");
            }
        }
    }

    public static void main(String args[]) {
        firstNonRepetingChar("aabccdb");
    }
}
