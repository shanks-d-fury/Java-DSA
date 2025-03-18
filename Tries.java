import java.util.LinkedList;
import java.util.Queue;

public class Tries {
    public static class Node {
        Node children[] = new Node[26];
        boolean eow = false;

        Node() {
            for (int i = 0; i < children.length; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String word) {
        Node crnt = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (crnt.children[idx] == null) {
                crnt.children[idx] = new Node();
            }
            crnt = crnt.children[idx];
        }
        crnt.eow = true;
    }

    public static boolean search(String key) {
        System.out.print("Searching for the key : " + key + " => ");
        Node crnt = root;
        for (int i = 0; i < key.length(); i++) {
            int idx = key.charAt(i) - 'a';
            if (crnt.children[idx] == null) {
                return false;
            }
            crnt = crnt.children[idx];
        }
        return crnt.eow == true;
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

    public static void main(String args[]) {
        String words[] = {
                "tree",
                "trees",
                "treat",
                "treats",
                "trial",
                "triangle",
                "trigger",
                "truck",
                "true",
                "trust"
        };
        for (String word : words)
            insert(word);

        System.out.println(search("tree"));
        System.out.println("\nTrie in form of level order ");
        printTrie(root);

    }
}
