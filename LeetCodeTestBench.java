
public class LeetCodeTestBench {

    public static double findMinimumDirection(String s) {
        s = s.toUpperCase();
        double k;
        int x = 0, y = 0;
        for (char c : s.toCharArray()) {
            switch (c) {
                case 'N' ->
                    x++;
                case 'S' ->
                    x--;
                case 'E' ->
                    y++;
                case 'W' ->
                    y--;
            }
        }
        k = Math.sqrt(x * x + y * y);
        return k;
    }

    public static void main(String[] args) {
        System.out.println(findMinimumDirection("nsewww"));
    }
}
