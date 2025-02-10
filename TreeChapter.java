import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TreeChapter {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static class BineryTree {
        static int idx = -1;

        public static Node buildTree(int nodes[]) {
            idx++;
            if (idx >= nodes.length) {
                return null;
            }
            if (nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }
    }

    public static void preorder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }

    public static void inorder(Node node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    public static void postorder(Node node) {
        if (node == null) {
            return;
        }
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data + " ");
    }

    public static void levelOrder(Node node) {
        if (node == null)
            return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node curr = queue.poll();
                System.out.print(curr.data + " ");
                if (curr.left != null)
                    queue.add(curr.left);
                if (curr.right != null)
                    queue.add(curr.right);
            }
            System.out.println();
        }
    }

    public static int height(Node node) {
        if (node == null) {
            return 0;
        }
        int lh = height(node.left);
        int rh = height(node.right);
        return Math.max(lh, rh) + 1;
    }

    public static int count(Node node) {
        if (node == null) {
            return 0;
        }
        int lh = count(node.left);
        int rh = count(node.right);
        return lh + rh + 1;
    }

    public static int sum(Node node) {
        if (node == null) {
            return 0;
        }
        int lh = sum(node.left);
        int rh = sum(node.right);
        return lh + rh + node.data;
    }

    public static int diameter(Node root) {
        if (root == null) {
            return 0;
        }
        int left = diameter(root.left);
        int right = diameter(root.right);
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh + rh + 1, Math.max(left, right));
    }

    public static class Info {
        int dia;
        int ht;

        public Info(int dia, int ht) {
            this.dia = dia;
            this.ht = ht;
        }
    }

    public static Info dia(Node root) {
        if (root == null) {
            return new Info(0, 0);
        }
        Info lInfo = dia(root.left);
        Info rInfo = dia(root.right);
        int diam = Math.max(Math.max(lInfo.dia, rInfo.dia), lInfo.ht + rInfo.ht + 1);
        int ht = Math.max(lInfo.ht, rInfo.ht) + 1;
        return new Info(diam, ht);
    }

    public static boolean isIdentical(Node root, Node subroot) {
        if (root == null && subroot == null) {
            return true;
        } else if (root == null || subroot == null || subroot.data != root.data) {
            return false;
        }
        if (!isIdentical(root.left, subroot.left)) {
            return false;
        } else if (!isIdentical(root.right, subroot.right)) {
            return false;
        }
        return true;
    }

    public static boolean subtree(Node root, Node subroot) {
        if (root == null) {
            return false;
        }
        if (subroot.data == root.data) {
            if (isIdentical(root, subroot)) {
                return true;
            }
        }
        return subtree(root.left, subroot) || subtree(root.right, subroot);
    }

    public static class Infox {
        Node node;
        int ht;

        public Infox(Node node, int ht) {
            this.node = node;
            this.ht = ht;
        }
    }

    public static void topView(Node root) {
        Queue<Infox> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();
        int min = 0, max = 0;
        q.add(new Infox(root, 0));
        q.add(null);
        while (!q.isEmpty()) {
            Infox crnt = q.remove();
            if (crnt == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                if (!map.containsKey(crnt.ht)) {
                    map.put(crnt.ht, crnt.node);
                }
                if (crnt.node.left != null) {
                    q.add(new Infox(crnt.node.left, crnt.ht - 1));
                    min = Math.min(min, crnt.ht - 1);
                }
                if (crnt.node.right != null) {
                    q.add(new Infox(crnt.node.right, crnt.ht + 1));
                    max = Math.max(min, crnt.ht + 1);
                }
            }
        }

        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i).data + " ");
        }
    }

    public static void kthLevel(Node root, int level, int k) {
        if (root == null) {
            return;
        }
        if (level == k) {
            System.out.print(root.data + " ");
            return;
        }
        kthLevel(root.left, level + 1, k);
        kthLevel(root.right, level + 1, k);
    }

    public static boolean findPath(Node root, int n, ArrayList<Node> path) {
        if (root == null) {
            return false;
        }
        path.add(root);
        if (root.data == n) {
            return true;
        }
        boolean leftFound = findPath(root.left, n, path);
        boolean rightFound = findPath(root.right, n, path);
        if (leftFound || rightFound) {
            return true;
        }
        path.remove(path.size() - 1);
        return false;
    }

    public static Node lowestCommonAnsestor(Node root, int n1, int n2) {
        ArrayList<Node> lpath = new ArrayList<>();
        ArrayList<Node> rpath = new ArrayList<>();
        findPath(root, n1, lpath);
        findPath(root, n2, rpath);

        int i = 0;
        for (; i < lpath.size() && i < rpath.size(); i++) {
            if (lpath.get(i) != rpath.get(i)) {
                break;
            }
        }
        return lpath.get(i - 1);
    }

    public static Node lca(Node root, int n1, int n2) {
        if (root == null || root.data == n1 || root.data == n2) {
            return root;
        }
        Node llca = lca(root.left, n1, n2);
        Node rlca = lca(root.right, n1, n2);
        if (llca == null) {
            return rlca;
        }
        if (rlca == null) {
            return llca;
        }
        return root;
    }

    public static int searchNode(Node root, int n) {
        if (root == null) {
            return -1;
        }
        if (root.data == n) {
            return 0;
        }

        int left = searchNode(root.left, n);
        int right = searchNode(root.right, n);

        if (left == -1 && right == -1) {
            return -1;
        }

        return Math.max(left, right) + 1;
    }

    public static int kthAnsestor(Node root, int n, int k) {
        if (root == null) {
            return -1;
        }
        if (root.data == n) {
            return 0;
        }

        int left = searchNode(root.left, n);
        int right = searchNode(root.right, n);

        if (left == -1 && right == -1) {
            return -1;
        }

        if (Math.max(left, right) + 1 == k) {
            return root.data;
        }
        return -1;
    }

    public static void main(String args[]) {
        int[] nodes = { 1, 2, 3, -1, -1, -1, 4, 5 };

        /*
         * Tree of the above number
         * 
         * 1
         * / \
         * 2 4
         * / /
         * 3 5
         * 
         */

        Node root = BineryTree.buildTree(nodes);
        // preorder(root);
        // System.out.println();
        // inorder(root);
        // System.out.println();
        // postorder(root);
        levelOrder(root);
        System.out.println(height(root));
        System.out.println(count(root));
        System.out.println(sum(root));
        System.out.println(diameter(root));
        System.out.println(dia(root).dia + " " + dia(root).ht);

        // subtree problem
        Node subRoot = new Node(2);
        subRoot.left = new Node(3);
        subRoot.right = new Node(5);

        System.out.println(subtree(root, subRoot));

        System.out.println();
        topView(root);
        // System.out.println(root.left.right.left.data);

        // kth level
        System.out.println();
        kthLevel(root, 1, 3);

        // Common ansestor for two nodes
        System.out.println();
        System.out.println("Lowest common ansestor: " + lowestCommonAnsestor(root, 1, 1).data);

        System.out.println();
        System.out.println("Lowest common ansestor: " + lca(root, 2, 3).data);
        Node lca = lca(root, 3, 5);
        System.out.println("Min distance between : " + (searchNode(lca, 3) + searchNode(lca, 5)));

        System.out.println("kth Ansestor of a node : " + kthAnsestor(root, 4, 1));
    }
}
