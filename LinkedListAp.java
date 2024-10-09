
public class LinkedListAp {
    public static class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node head = null;
    public static Node tail = null;
    public static int size = 0;

    public void addLast(int data) {
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
        node.prev = temp;
        tail = node;
    }

    public void addFirst(int data) {
        Node node = new Node(data);
        size++;
        if (head == null) {
            head = tail = node;
            return;
        }
        head.prev = node;
        node.next = head;
        head = node;
    }

    public void removeFirst() {
        if (size == 0) {
            System.out.println("Empty");
            return;
        }
        if (size == 1) {
            head = tail = null;
            return;
        }
        size--;
        head = head.next;
        head.prev = null;
    }

    public void removeLast() {
        if (size == 0) {
            System.out.println("Empty");
            return;
        }
        if (size == 1) {
            head = tail = null;
            return;
        }
        size--;
        tail = tail.prev;
        tail.next = null;
    }

    public void printDLL() {
        if (head == null) {
            System.out.println("null");
            return;
        }
        Node temp = head;
        System.out.print("null<->");
        while (temp != null) {
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void printRevDLL() {
        if (size == 0) {
            System.out.println("null");
            return;
        }
        Node temp = tail;
        System.out.print("null<->");
        while (temp != null) {
            System.out.print(temp.data + "<->");
            temp = temp.prev;
        }
        System.out.println("null");
    }

    public void reveseDll() {
        if (size == 0) {
            System.out.println("Empty");
            return;
        }
        Node prev = null, crnt = head, nextNode;
        while (crnt != null) {
            nextNode = crnt.next;
            crnt.next = prev;
            crnt.prev = nextNode;
            prev = crnt;
            crnt = nextNode;
        }
        head = prev;
    }

    public static void main(String[] args) {
        LinkedListAp dll = new LinkedListAp();
        dll.addFirst(1);
        dll.addFirst(2);
        dll.addFirst(3);
        dll.addFirst(4);
        dll.addFirst(5);
        dll.printDLL();
        // dll.removeFirst();
        // dll.printDLL();
        dll.reveseDll();
        dll.printDLL();
        // System.out.println(ll.isPalindrome());
    }
}
