
import java.util.Stack;

public class StacksChapter {

    public static void pushBottom(Stack<Integer> s, int data) {
        if (s.isEmpty()) {
            s.push(data);
            return;
        }
        int top = s.pop();
        pushBottom(s, data);
        s.push(top);
    }

    public static String reverseString(String sx) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < sx.length(); i++) {
            stack.push(sx.charAt(i));
        }
        StringBuilder s = new StringBuilder();
        while (!stack.isEmpty()) {
            s.append(stack.pop());
        }
        return s.toString();
    }

    public static void reverseStack(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }
        int top = s.pop();
        reverseStack(s);
        pushBottom(s, top);
    }

    public static void spanProblem(int stocks[], int span[]) {
        Stack<Integer> s = new Stack<>();
        s.push(0);
        span[0] = 1;
        for (int i = 1; i < stocks.length; i++) {
            int price = stocks[i];
            while (!s.isEmpty() && price > stocks[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
                span[i] = i + 1;
            } else {
                span[i] = i - s.peek();
            }
            s.push(i);
        }
    }

    public static void nxtGrtElmnt(int ary[], int grtAry[]) {
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < ary.length; i++) {
            while (!s.isEmpty() && ary[i] >= ary[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
                grtAry[i] = -1;
            } else {
                grtAry[i] = ary[s.peek()];
            }
            s.push(i);
        }
    }

    public static void main(String[] args) {
        int ary[] = { 6, 8, 0, 1, 3 };
        int grtAry[] = new int[ary.length];
        nxtGrtElmnt(ary, grtAry);
        for (int x : grtAry) {
            System.out.print(x + " ");
        }
        // System.out.println(s);
    }
}
