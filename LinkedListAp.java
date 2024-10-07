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

    public Node getMid(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

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
    }

    public void addFirst(int data) {
        Node node = new Node(data);
        size++;
        if (head == null) {
            head = tail = node;
            return;
        }
        node.next = head;
        head = node;
    }

    public void removeFirst() {
        if (head == null) {
            System.out.println("empty");
            return;
        }
        size--;
        if (head.next == null) {
            tail = head = null;
            return;
        }
        head = head.next;
    }

    public void removeLast() {
        if (head == null) {
            System.out.println("Empty");
            return;
        }
        size--;
        if (head.next == null) {
            head = tail = null;
            return;
        }
        Node prev = head;
        while (prev.next.next != null) {
            prev = prev.next;
        }
        prev.next = null;
        tail = prev;
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

    public int helper(Node head, int key) {
        if (head == null) {
            return -1;
        }
        if (head.data == key) {
            return 0;
        }
        int idx = helper(head.next, key);
        if (idx == -1) {
            return -1;
        }
        return idx + 1;
    }

    public int recursiveSearch(int key) {
        return helper(head, key);
    }

    public void reverseLL() {
        if (head == null) {
            System.out.println("Empty");
            return;
        }
        Node prevND = null;
        Node crntND = head;
        Node nextND;
        while (crntND != null) {
            nextND = crntND.next;
            crntND.next = prevND;
            prevND = crntND;
            crntND = nextND;
        }
        head = prevND;
    }

    public static void main(String[] args) {
        LinkedListAp ll = new LinkedListAp();
        ll.addlast(1);
        ll.addlast(2);
        ll.addlast(3);
        ll.addlast(4);
        ll.addlast(5);
        ll.addFirst(0);
        ll.addFirst(-1);
        ll.addFirst(-2);
        ll.addFirst(-3);
        ll.printLL();
        ll.removeFirst();
        ll.printLL();
        ll.removeLast();
        ll.printLL();
        // System.out.println(LinkedListAp.size);
        // System.out.println(ll.getMid(head).data);
        int i = 0;
        while (i < 10) {
            ll.addFirst(i);
            ll.removeLast();
            i++;
        }
        ll.printLL();
        // System.out.println(ll.recursiveSearch(8));
        ll.reverseLL();
        ll.printLL();
    }
}
