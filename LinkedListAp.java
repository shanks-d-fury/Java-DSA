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
        tail = node;
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

    public void deleteFromLast(int idx) {
        if (head == null) {
            System.out.println("Empty");
            return;
        }
        if (idx > size) {
            System.out.println("Can't Delete");
            return;
        }
        if (idx == size) {
            head = head.next;
            return;
        }
        int i = 0;
        Node crntNode = head;
        while (i < (size - idx)) {
            crntNode = crntNode.next;
            i++;
        }
        crntNode.next = crntNode.next.next;
        size--;
    }

    public boolean isPalindrome() {
        if (head == null || head.next == null) {
            return true;
        }
        Node midNode = getMid(head);
        Node prevND = null;
        Node crntND = midNode;
        Node nextND;
        while (crntND != null) {
            nextND = crntND.next;
            crntND.next = prevND;
            prevND = crntND;
            crntND = nextND;
        }
        Node leftNode = head;
        Node rightNode = prevND;
        while (leftNode != null && rightNode != null) {
            if (leftNode.data != rightNode.data) {
                return false;
            }
            leftNode = leftNode.next;
            rightNode = rightNode.next;
        }
        return true;
    }

    public boolean cheackLoop() {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LinkedListAp ll = new LinkedListAp();
        ll.addlast(1);
        ll.addlast(2);
        ll.addlast(1);
        ll.addlast(2);
        ll.addlast(1);
        // tail.next = head.next.next;
        // ll.printLL();
        System.out.println(ll.cheackLoop());
        // System.out.println(ll.isPalindrome());
    }
}
