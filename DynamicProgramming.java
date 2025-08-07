
public class DynamicProgramming {
    public static void main(String args[]) {
        long startTime = System.currentTimeMillis();
        //
        // int[] val = { 15, 14, 10, 45, 30 };
        // int[] wt = { 2, 5, 1, 3, 4 };
        int[] val = Genarate_Random.IntArray(5, 10, 20);
        int[] wt = Genarate_Random.IntArray(5, 1, 5);
        int W = 7;
        System.out.println(kanpsack0_1(val, wt, W, val.length - 1));
        //
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken : " + (endTime - startTime) + " ms\n");
    }

    public static int kanpsack0_1(int[] val, int[] wt, int W, int i) {
        if (i == 0 || W == 0) {
            return 0;
        }
        if (wt[i] <= W) {
            int ans1 = val[i] + kanpsack0_1(val, wt, W - wt[i], i - 1);
            int ans2 = kanpsack0_1(val, wt, W, i - 1);
            return Math.max(ans1, ans2);
        } else {
            return kanpsack0_1(val, wt, W, i - 1);
        }
    }

}
