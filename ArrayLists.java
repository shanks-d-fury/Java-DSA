import java.util.ArrayList;

public class ArrayLists {
    public static void main(String args[]) {
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0;
        while (i < 10) {
            list.add(i);
        }
        System.out.println(Pair_sum_1(list, 10));

    }

    public static boolean Pair_sum_1(ArrayList<Integer> list, int target) {
        int lp = 0, rp = list.size() - 1;
        while (lp < rp) {
            if (list.get(lp) + list.get(rp) == target) {
                return true;
            } else if (list.get(lp) + list.get(rp) < target) {
                lp++;
            } else {
                rp--;
            }
        }
        return false;
    }
}