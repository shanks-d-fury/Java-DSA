
import java.util.HashMap;

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

    public static void main(String[] args) {
        System.out.println(isAnagram("shanks", "skyahs"));
    }
}