
public class LeetCodeTestBench {

    public static int romanToInt(String s) {
        char[] cx = s.toCharArray();
        int sum = 0;
        int value = 0;
        int temp;
        for (int i = cx.length - 1; i >= 0; i--) {
            temp = value;
            value = switch (cx[i]) {
                case 'I' ->
                    1;
                case 'V' ->
                    5;
                case 'X' ->
                    10;
                case 'L' ->
                    50;
                case 'C' ->
                    100;
                case 'D' ->
                    500;
                case 'M' ->
                    1000;
                default ->
                    0;
            };
            if (i == cx.length - 1) {
                temp = value;
            }
            if (temp == value) {
                sum += value;
                continue;
            }
            if (value >= sum) {
                sum += value;
            } else {
                sum -= value;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MMMMMMMMMMMMMMDCLXXXIV"));
    }
}
