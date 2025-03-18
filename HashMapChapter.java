import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class HashMapChapter {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        HashMap<Character, Integer> hm = new HashMap<>();
        for (char x : s.toCharArray())
            hm.put(x, hm.getOrDefault(x, 0) + 1);

        for (char x : t.toCharArray()) {
            if (hm.containsKey(x)) {
                if (hm.get(x) == 1) {
                    hm.remove(x);
                } else {
                    hm.put(x, hm.get(x) - 1);
                }
            } else {
                return false;
            }
        }
        return hm.isEmpty();
    }

    public static List<Integer> unionAndInter(int ary1[], int ary2[]) {
        // return of list<int> instead of Arraylist because list is a interface and with
        // that we can implement any of the classes like Arraylist , linkedlist
        HashSet<Integer> union = new HashSet<>();
        HashSet<Integer> inter = new HashSet<>();

        // Add all elements of ary1 to union
        for (int i : ary1)
            union.add(i);

        // Add all elements of ary2 to union and check for intersection
        for (int i : ary2) {
            if (union.contains(i)) {
                inter.add(i);
            }
            union.add(i);
        }

        // Return union size and intersection size as a list
        return Arrays.asList(union.size(), inter.size());
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("shanks", "skyahs"));
        int ary1[] = Genarate_Random.generateRandomArray(3, -3, 3);
        int ary2[] = Genarate_Random.generateRandomArray(5, -3, 3);
        System.out.println(Arrays.toString(ary1));
        System.out.println(Arrays.toString(ary2));
        System.out.println(unionAndInter(ary1, ary2));
    }
}