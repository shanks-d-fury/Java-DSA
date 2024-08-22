
public class LeetCodeTestBench {

    public int[] plusOne(int[] digits) {
        long m = 0;
        long temp = 0;
        int len = 0;
        for (int x : digits) {
            m = m * 10 + x;
        }
        m = m + 1;
        temp = m;
        while (temp > 0) {
            len++;
            temp = temp / 10;
        }
        int retAry[] = new int[len];
        int i = len - 1;
        while (m > 0) {
            retAry[i] = (int) m % 10;
            m = m / 10;
            i--;
        }
        return retAry;
    }

    public static void main(String[] args) {

    }
}
