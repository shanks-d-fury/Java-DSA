
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
        Node fast = head.next;
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

    public void printLL() {
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

    public static void main(String[] args) {
        LinkedListAp ll = new LinkedListAp();
        ll.addlast(6);
        ll.addlast(2);
        ll.addlast(10);
        ll.addlast(9);
        ll.addlast(1);
        ll.addlast(8);
        ll.printLL();
        head = ll.mergesort(head);
        ll.printLL();
        // System.out.println(ll.isPalindrome());
    }
}
