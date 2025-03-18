import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Tries {
    public static class Node {
        Node children[] = new Node[26];
        boolean eow = false;
        int freq;

        Node() {
            for (int i = 0; i < children.length; i++) {
                children[i] = null;
            }
            freq = 1;
        }
    }

    public static Node root = new Node();

    public static void insert(String word) {
        Node crnt = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (crnt.children[idx] == null) {
                crnt.children[idx] = new Node();
            } else {
                crnt.children[idx].freq++;
            }
            crnt = crnt.children[idx];
        }
        crnt.eow = true;
    }

    public static String search(String key) {
        Node crnt = root;
        String ans = "";
        for (int i = 0; i < key.length(); i++) {
            int idx = key.charAt(i) - 'a';
            if (crnt.children[idx].freq == 1) {
                ans += (char) (idx + 'a');
                break;
            } else if (crnt.children[idx] != null) {
                ans += (char) (idx + 'a');
            }
            crnt = crnt.children[idx];
        }
        return ans;
    }

    public static class Info {
        Node node;
        int idx;

        Info(Node node, int idx) {
            this.idx = idx;
            this.node = node;
        }
    }

    static Queue<Info> q = new LinkedList<>();

    public static void printTrie(Node root) {
        q.clear();
        q.add(new Info(root, -1));
        q.add(null);
        while (!q.isEmpty()) {
            Info cc = q.remove();
            if (cc == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(cc.idx == -1 ? "@" : ((char) (cc.idx + 'a') + " "));
                Node childrens[] = cc.node.children;
                for (int i = 0; i < childrens.length; i++) {
                    if (childrens[i] != null) {
                        q.add(new Info(childrens[i], i));
                    }
                }
            }
        }
    }

    public static void prefix(Node root, String words[]) {
        ArrayList<String> ans = new ArrayList<>();
        for (String word : words) {
            ans.add(search(word));
        }
        System.out.println(ans);
    }

    public static void prefixAP(Node root, String ans) {
        if (root == null) {
            return;
        }
        if (root.freq == 1) {
            System.out.print(ans + " ");
            return;
        }
        for (int idx = 0; idx < root.children.length; idx++) {
            if (root.children != null) {
                prefixAP(root.children[idx], ans + (char) (idx + 'a'));
            }
        }
    }

    public static void main(String args[]) {
        String words[] = {
                "zebra", "dog", "duck", "dove", "hadshi", "shanks"
        };
        for (String word : words)
            insert(word);

        // Prefix of the words my way
        prefix(root, words);

        root.freq = -1;
        // prefix of the words in AP way
        prefixAP(root, "");
        System.out.println();
        System.out.println("\nTrie in form of level order ");
        printTrie(root);

    }
}
