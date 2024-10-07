import java.util.ArrayList;
import java.util.Random;

public class ArrayLists {
    public static void main(String args[]) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();

        ArrayList<ArrayList<Integer>> dadList = new ArrayList<>();
        dadList.add(list1);
        dadList.add(list2);
        dadList.add(list3);

        Random rand = new Random();
        int i = 0, j;
        while (i < 3) {
            j = 0;
            while (j < 5) {
                dadList.get(i).add(rand.nextInt(10));
                j++;
            }
            i++;
        }
        System.out.println(list1 + "\n" + list2 + "\n" + list3);

        System.out.println(dadList);
        System.out.println(dadList.get(0).get(0));
    }
}