import java.util.*;
import java.util.stream.Collectors;

public class LeetCodeTestBench {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static int idx = -1;

    public static Node buildtree(int[] nodes) {
        idx++;
        if (idx > nodes.length) {
            return null;
        }
        if (nodes[idx] == -1) {
            return null;
        }
        Node curNode = new Node(nodes[idx]);
        curNode.left = buildtree(nodes);
        curNode.right = buildtree(nodes);
        return null;
    }

    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        //
        long startTime = System.currentTimeMillis();
        //
        ArrayList<Integer> al = new ArrayList<>(
                Arrays.stream(Genarate_Random.IntArray(5, 1, 5)).boxed().collect(Collectors.toList()));

        // TAKING INPUT
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the elements: ");
        int[] ary = Arrays.stream(sc.nextLine().split(" ")).map(ele -> ele.equals("null") ? "-1" : ele)
                .mapToInt(Integer::parseInt).toArray();
        System.out.println(Arrays.toString(ary));

        sc.close();

        // // THE BELOW TAKES INPUT BY USING HASNEXT AND CONVERTS THE LIST TO ARRAY
        // List<Integer> list = new ArrayList<>();
        // while (sc.hasNextInt()) {
        // list.add(sc.nextInt());
        // }
        // System.out.println(list);
        // int[] ar = list.stream().mapToInt(Integer::intValue).toArray();
        //
        long endTime = System.currentTimeMillis();
        long timeTaken = endTime - startTime;
        System.out.println("Time taken : " + timeTaken + " ms\n");
    }

    public static void compress(char[] chars) {
        if (chars.length == 0) {
            // return 0;
        }
        LinkedHashMap<Character, Integer> hm = new LinkedHashMap<>();
        for (char c : chars) {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }
        System.out.println(hm);
        ArrayList<Character> aryl = new ArrayList<>();
        for (Map.Entry<Character, Integer> map : hm.entrySet()) {
            aryl.add(map.getKey());
            if (map.getValue() == 1) {
                // nothing to add
            } else if (Integer.toString(map.getValue()).length() <= 1) {
                aryl.add((char) (map.getValue() + '0'));
            } else if (Integer.toString(map.getValue()).length() > 1) {
                for (char x : Integer.toString(map.getValue()).toCharArray()) {
                    System.out.println(x);
                    aryl.add(x);
                }
            }
        }
        chars = new char[aryl.size()];
        for (int i = 0; i < aryl.size(); i++) {
            chars[i] = aryl.get(i);
        }
        System.out.println(Arrays.toString(chars));
        // return chars.length;
    }

    public static String reverseWords(String s) {
        s = s.trim();
        String[] ary = s.split("\\s+");
        System.out.println(s.matches(".*world.*"));
        System.out.println("b".matches("[abc]"));
        System.out.println("\"shis\"");
        int n = ary.length;
        for (int i = 0; i < n / 2; i++) {
            String temp = ary[i];
            ary[i] = ary[n - i - 1];
            ary[n - 1 - i] = temp;
        }
        String ans = "";
        System.out.println(Arrays.toString(ary));
        for (String x : ary) {
            if (x.equals(" ")) {
                continue;
            }
            ans += x;
            ans += " ";
        }
        ans = ans.trim();
        return ans;
    }

    public static String removeOccurrences(String s, String part) {
        s = s.trim();
        while (s.contains(part)) {
            int x = s.indexOf(part);
            int n = part.length();
            s = s.substring(0, x) + s.substring(x + n, s.length());
        }
        ArrayList<String> ary = new ArrayList<>();
        return s;
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        HashMap<Character, Integer> s1map = new HashMap<>();

        for (int i = 0; i < s1.length(); i++)
            s1map.put(s1.charAt(i), s1map.getOrDefault(s1.charAt(i), 0) + 1);

        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            HashMap<Character, Integer> s2map = new HashMap<>();
            for (int j = 0; j < s1.length(); j++) {
                s2map.put(s2.charAt(i + j), s2map.getOrDefault(s2.charAt(i + j), 0) + 1);
            }
            if (matches(s1map, s2map))
                return true;
        }
        return false;
    }

    public boolean matches(HashMap<Character, Integer> s1map, HashMap<Character, Integer> s2map) {
        for (char key : s1map.keySet()) {
            if (s1map.get(key) - s2map.getOrDefault(key, -1) != 0)
                return false;
        }
        String[] strs = new String[2];
        HashMap<String, List<String>> hm = new HashMap<>();
        for (String str : strs) {
            String sortStr = sort(str);
            List<String> list = hm.getOrDefault(sortStr, new ArrayList<String>());
            list.add(str);
            hm.put(sortStr, list);
        }
        return true;

    }

    public static String sort(String str) {
        char[] charary = str.toCharArray();
        Arrays.sort(charary);
        return new String(charary);
    }

}
