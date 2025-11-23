import java.util.*;
import java.util.stream.Collector;
// import java.util.stream.Collectors;
import java.util.stream.Collectors;

public class LeetCodeTestBench {

    public static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        //
        long startTime = System.currentTimeMillis();
        //

        Scanner sc = new Scanner(System.in);
        // System.out.println("Enter the elements: ");
        // int[] ary = Arrays.stream(sc.nextLine().split(" ")).map(ele ->
        // ele.equals("null") ? "-1" : ele)
        // .mapToInt(Integer::parseInt).toArray();
        // System.out.println(Arrays.toString(ary));
        // Node root = buildtree(ary);
        // // postOrder(root);
        // // System.out.println();
        // levelOrder(root);
        // System.out.println(sum(root));
        // System.out.println(diaAndHeight(root).h + " " + diaAndHeight(root).d);
        int[] ary = Genarate_Random.IntArray(5, 1, 100);
        int[] arx = Genarate_Random.IntArray(5, 1, 10);
        int k = 0;
        // TreeSet<Integer> hs = new TreeSet<>();
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        int i = 0;
        for (int x = 0; x < ary.length; x++) {
            tm.put(ary[x], arx[x]);
        }

        System.out.println(tm);
        for (Map.Entry<Integer, Integer> map : tm.entrySet()) {
            ary[i] = map.getKey();
            arx[i] = map.getValue();
            i++;
        }
        System.out.println(Arrays.toString(ary));
        System.out.println(Arrays.toString(arx));
        // System.out.println(ary[k++] + " " + k);
        // System.out.println(sc.nextLine().split(" ").length);
        //
        sc.close();
        long endTime = System.currentTimeMillis();
        long timeTaken = endTime - startTime;
        System.out.println("Time taken : " + timeTaken + " ms\n");
    }

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh, rh) + 1;
    }

    public static int sum(Node root) {
        if (root == null) {
            return 0;
        }
        int ls = sum(root.left);
        int rs = sum(root.right);
        return ls + rs + root.data;
    }

    public static int diameter(Node root) {
        if (root == null) {
            return 0;
        }
        int ld = diameter(root.left);
        int rd = diameter(root.right);
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(Math.max(ld, rd), lh + rh + 1);
    }

    public static class Info {
        int h;
        int d;

        Info(int h, int d) {
            this.h = h;
            this.d = d;
        }
    }

    public static Info diaAndHeight(Node root) {
        if (root == null) {
            return new Info(0, 0);
        }
        Info lInfo = diaAndHeight(root.left);
        Info rInfo = diaAndHeight(root.right);
        int dia = Math.max(Math.max(lInfo.d, rInfo.d), lInfo.h + rInfo.h + 1);
        int hei = Math.max(lInfo.h, rInfo.h) + 1;
        return new Info(hei, dia);
    }

    public static void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public static void levelOrder(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            Node rem = q.remove();
            if (rem == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(rem.data + " ");
                if (rem.left != null) {
                    q.add(rem.left);
                }
                if (rem.right != null) {
                    q.add(rem.right);
                }
            }

        }
    }

    static int idx = -1;

    public static Node buildtree(int[] nodes) {
        idx++;
        if (idx >= nodes.length) {
            return null;
        }
        if (nodes[idx] == -1) {
            return null;
        }
        Node curNode = new Node(nodes[idx]);
        curNode.left = buildtree(nodes);
        curNode.right = buildtree(nodes);
        return curNode;
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
