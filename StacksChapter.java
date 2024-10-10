
import java.util.Stack;

public class StacksChapter {

    public static void nxtLstElmnt(int ary[], int grtAry[]) {
        Stack<Integer> s = new Stack<>();
        for (int i = ary.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && ary[i] <= ary[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
                grtAry[i] = -1;
            } else {
                grtAry[i] = s.peek();
            }
            s.push(i);
        }
    }

    public static void prvLstElmnt(int ary[], int grtAry[]) {
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < ary.length; i++) {
            while (!s.isEmpty() && ary[i] <= ary[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
                grtAry[i] = -1;
            } else {
                grtAry[i] = s.peek();
            }
            s.push(i);
        }
    }

    public static int maxAreaHistogram(int ary[]) {
        int prvLst[] = new int[ary.length];
        int nxtLst[] = new int[ary.length];
        prvLstElmnt(ary, prvLst);
        nxtLstElmnt(ary, nxtLst);
        int area, maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < ary.length; i++) {
            int height = ary[i];
            int p = prvLst[i];
            int q = nxtLst[i] == -1 ? ary.length : nxtLst[i];
            int width = q - p - 1;
            area = height * width;
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] ary = {
                10, 10
        };
        System.out.println(maxAreaHistogram(ary));
    }
}
