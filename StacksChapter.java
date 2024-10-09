
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

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        System.out.println(reverseString(""));
        // System.out.println(s);
    }
}
