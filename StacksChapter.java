
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

    public static String reverseString(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }
        s = "";
        while (!stack.isEmpty()) {
            s += stack.pop();
        }
        return s;
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        System.out.println(reverseString("fuckyou"));
        // System.out.println(s);
    }
}
