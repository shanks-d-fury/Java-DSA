
public class LinkedListAp {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head = null;
    public static Node tail = null;
    public static int size = 0;

    public void addlast(int data) {
        Node node = new Node(data);
        size++;
        if (head == null) {
            head = tail = node;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        tail = node;
    }

    public Node midNode(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public Node mergesort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node midNode = midNode(head);
        Node rightNode = mergesort(midNode.next);
        midNode.next = null;
        Node leftNode = mergesort(head);
        return merge(leftNode, rightNode);
    }

    public Node merge(Node leftNode, Node rightNode) {
        Node mergeLL = new Node(-1);
        Node temp = mergeLL;
        while (leftNode != null && rightNode != null) {
            if (leftNode.data < rightNode.data) {
                temp.next = leftNode;
                leftNode = leftNode.next;
            } else {
                temp.next = rightNode;
                rightNode = rightNode.next;
            }
            temp = temp.next;
        }
        while (leftNode != null) {
            temp.next = leftNode;
            leftNode = leftNode.next;
            temp = temp.next;
        }
        while (rightNode != null) {
            temp.next = rightNode;
            rightNode = rightNode.next;
            temp = temp.next;
        }

        return mergeLL.next;
    }

    public void printLL(Node head) {
        if (head == null) {
            System.out.println("null");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public Node zigZag(Node node) {
        Node zigzagNode = new Node(-1);
        Node temp = zigzagNode;
        Node leftNode = node, rightNode;
        Node midNode = midNode(node);
        rightNode = midNode.next;
        midNode.next = null;
        rightNode = reverse(rightNode);
        while (leftNode != null || rightNode != null) {
            if (leftNode != null) {
                temp.next = new Node(leftNode.data);
                leftNode = leftNode.next;
                temp = temp.next;
            }
            if (rightNode != null) {
                temp.next = new Node(rightNode.data);
                rightNode = rightNode.next;
                temp = temp.next;
            }
        }
        return zigzagNode.next;
    }

    public Node reverse(Node head) {
        if (head == null) {
            System.out.println("Empty");
            return head;
        }
        Node prev = null, crnt = head, nextNode;
        while (crnt != null) {
            nextNode = crnt.next;
            crnt.next = prev;
            prev = crnt;
            crnt = nextNode;
        }
        return prev;
    }

    public static void main(String[] args) {
        LinkedListAp ll = new LinkedListAp();
        ll.addlast(1);
        ll.addlast(2);
        ll.addlast(3);
        ll.addlast(4);
        ll.addlast(5);
        ll.addlast(6);
        ll.printLL(head);
        // head = ll.mergesort(head);
        // head = ll.reverse(head);
        head = ll.zigZag(head);
        ll.printLL(head);
        // System.out.println(ll.isPalindrome());
    }
}
