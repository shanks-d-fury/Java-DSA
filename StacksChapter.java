
import java.util.HashSet;
import java.util.Set;
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
        for (int i = ary.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && ary[i] <= ary[s.peek()]) {
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

    public static boolean checkDuplicateParanthesis(String sx) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < sx.length(); i++) {
            if (sx.charAt(i) == ')') {
                int count = 0;
                while (s.peek() != '(') {
                    count++;
                    s.pop();
                }
                s.pop();
                if (count < 1) {
                    return true;
                }
            } else {
                s.push(sx.charAt(i));
            }
        }
        return false;
    }

    public static boolean validParanthesis(String sx) {
        Stack<Character> s = new Stack<>();
        Set<Character> set = new HashSet<>();
        set.add('{');
        set.add('(');
        set.add('[');
        for (int i = 0; i < sx.length(); i++) {
            if (set.contains(sx.charAt(i))) {
                s.push(sx.charAt(i));
            } else {
                char checkChar = ' ';
                switch (sx.charAt(i)) {
                    case '}' -> checkChar = '{';
                    case ')' -> checkChar = '(';
                    case ']' -> checkChar = '[';
                }
                if (s.pop() != checkChar) {
                    return false;
                }
            }
        }
        return s.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(checkDuplicateParanthesis("((a+b)+(c+d))"));
    }
}
