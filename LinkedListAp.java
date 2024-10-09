
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

    public Node deleteN_nodes_after_Mnodes(int N, int M) {
        Node temp = head;
        Node erase;
        while (temp != null) {
            for (int i = 0; i < M - 1; i++) {
                temp = temp.next;
            }
            erase = temp.next;
            for (int i = 0; i < N; i++) {
                if (erase != null) {
                    erase = erase.next;
                }
            }
            temp.next = erase;
            temp = temp.next;
        }
        return head;
    }

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
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);
        ll.addLast(7);
        ll.addLast(8);
        ll.addLast(9);
        ll.addLast(10);
        ll.printLL();
        head = ll.deleteN_nodes_after_Mnodes(2, 3);
        ll.printLL();

    }
}
