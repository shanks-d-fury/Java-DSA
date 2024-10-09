
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

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        reverseStack(s);
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
        // System.out.println(s);
    }
}
