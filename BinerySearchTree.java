
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

    public static void main(String[] args) {
        int nodes[] = { 5, 1, 3, 4, 2, 7 };
        Node root = null;
        for (int i = 0; i < nodes.length; i++) {
            root = buildBST(root, nodes[i]);
        }

        inorder(root);
        System.out.println();
        searchBST(root, 4);
    }
}
