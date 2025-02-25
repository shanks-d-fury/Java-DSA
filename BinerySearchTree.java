
import java.util.LinkedList;
import java.util.Queue;

public class BinerySearchTree {
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

    public static Node buildBST(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (val > root.data) {
            root.right = buildBST(root.right, val);
        } else if (val < root.data) {
            root.left = buildBST(root.left, val);
        }
        return root;
    }

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

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void searchBST(Node root, int target) {
        if (root == null) {
            System.out.println("NOT Found");
            return;
        }
        if (root.data == target) {
            System.out.println("Found");
        } else if (root.data < target) {
            searchBST(root.right, target);
        } else {
            searchBST(root.left, target);
        }
    }

    public static Node deleteNodeInBST(Node root, int key) {
        if (root == null) {
            return null;
        }
        if (root.data > key) {
            root.left = deleteNodeInBST(root.left, key);
        } else if (root.data < key) {
            root.right = deleteNodeInBST(root.right, key);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            }

            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            Node IS = findInorderSuccesor(root.right);
            root.data = IS.data;
            root.right = deleteNodeInBST(root.right, IS.data);
        }
        return root;
    }

    public static Node findInorderSuccesor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void levelOrder(Node root) {
        if (root == null)
            return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node crnt = q.poll();
                System.out.print(crnt.data + " ");
                if (crnt.left != null)
                    q.add(crnt.left);
                if (crnt.right != null)
                    q.add(crnt.right);
            }
            System.out.println();
        }
    }

    public static void printInRange(Node root, int k1, int k2) {
        if (root == null) {
            return;
        }
        if (root.data >= k1 && root.data <= k2) {
            printInRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printInRange(root.right, k1, k2);
        } else if (root.data < k1)
            printInRange(root.right, k1, k2);
        else if (root.data > k2)
            printInRange(root.left, k1, k2);
    }

    public static boolean isValidBST(Node root, Node min, Node max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.data < min.data) {
            return false;
        } else if (max != null && root.data > max.data) {
            return false;
        }
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

    public static void main(String[] args) {
        int nodes[] = { 3, 2, 1 };
        Node root = null;
        for (int i = 0; i < nodes.length; i++) {
            root = buildBST(root, nodes[i]);
        }

        // Node root = buildTree(nodes);

        inorder(root);
        System.out.println();
        searchBST(root, 4);

        System.out.println();

        levelOrder(root);
        System.out.println();
        // deleteNodeInBST(root, 5);
        // levelOrder(root);
        // System.out.println("print in range");

        // printInRange(root, 1, 6);
        String ans = (isValidBST(root, null, null) ? "valid" : "invalid");
        System.out.println(ans);
    }
}
