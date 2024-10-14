
import java.util.Stack;

public class QueueChapter {
    public static class Queues {
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public static boolean isEmpty() {
            return s1.isEmpty();
        }

        public static void add(int data) {
            s1.push(data);
        }

        public static int remove() {
            if (s1.isEmpty()) {
                System.out.println("Empty");
                return -1;
            }
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            int removedElement = s2.pop();
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
            return removedElement;
        }

        public static int peek() {
            if (s1.isEmpty()) {
                System.out.println("Empty");
                return -1;
            }
            return s1.peek();
        }
    }

    public static void main(String args[]) {
        Queues q = new Queues();
        System.out.println("Queues:- ");
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        while (!q.isEmpty()) {
            System.out.println(q.remove());
        }

        System.out.println("Stacks :-");
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);

        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
}
