import java.util.*;

public class LeetCodeTestBench {

    public static void main(String[] args) {
        // String testArray[] = Genarate_Random.StringArray(5, 5, false, 0);
        String testArray[] = { "sha", "ash", "sah", "aas", "asa", "shanks" };
        //
        long startTime = System.currentTimeMillis();
        //
        System.out.println(groupAnagrams(testArray));
        //
        long endTime = System.currentTimeMillis();
        long timeTaken = endTime - startTime;
        System.out.println("Time taken : " + timeTaken + " ms\n");
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hm = new HashMap<>();
        for (String str : strs) {
            String sortString = sortString(str);
            hm.putIfAbsent(sortString, new ArrayList<>());
            hm.get(sortString).add(str);
        }
        List<List<String>> list = new ArrayList<>();
        for (Map.Entry<String, List<String>> map : hm.entrySet()) {
            list.add(map.getValue());
        }
        Collections.sort(list, Comparator.comparingInt(List::size));
        return list;
    }

    public static String sortString(String str) {
        char[] charAry = str.toCharArray();
        Arrays.sort(charAry);
        return new String(charAry);

        // this is the cg method
        // return new String(str.chars().sorted().toArray(), 0, str.length());
    }
}
