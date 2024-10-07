import java.util.ArrayList;

public class ArrayLists {
    public static void main(String args[]) {
        ArrayList<Integer> list = new ArrayList<>();
        int j = 10;
        while (j < 15) {
            list.add(j);
            j++;
        }
        int i = 0;
        while (i < 10) {
            list.add(i);
            i++;
        }
        System.out.println(list);
        System.out.println(Pair_sum_2(list, 20));
        // Rotated and sorted array
    }

    public static boolean Pair_sum_2(ArrayList<Integer> list, int target) {
        System.out.println("Target : " + target);
        int i = 0, bp = -1, n = list.size();
        while (i < list.size() - 1) {
            if (list.get(i) > list.get(i + 1)) {
                bp = i;
            }
            i++;
        }
        int lp = bp + 1, rp = bp;
        while (lp != rp) {
            if (list.get(lp) + list.get(rp) == target) {
                System.out.println(list.get(lp) + "," + list.get(rp));
                return true;
            } else if (list.get(lp) + list.get(rp) < target) {
                lp = (lp + 1) % n;
            } else {
                rp = (n + rp - 1) % n;
            }
        }
        return false;
    }
}