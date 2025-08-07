
import java.util.HashSet;

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
        tail = node;
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

    public void reversell() {
        if (head == null) {
            System.out.println("Empty LL");
            return;
        }
        Node prev = null;
        Node cur = tail = head;
        Node next;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head = prev;
    }

    public void connectLastNthtoFirst(int n) {
        int i = 1;
        Node temp = head;
        while (i < n && temp != null) {
            temp = temp.next;
            i++;
        }
        Node lastTemp = head;
        while (lastTemp.next != null) {
            lastTemp = lastTemp.next;
        }
        tail = lastTemp;
        tail.next = temp;
    }

    public void printCycle() {
        if (head == null) {
            System.out.println("Empty ll");
            return;
        }
        HashSet<Integer> hs = new HashSet<>();
        Node temp = head;
        while (temp != null) {
            if (!hs.contains(temp.data)) {
                hs.add(temp.data);
                System.out.print(temp.data + "->");
                temp = temp.next;
            } else {
                System.out.print(temp.data + " cycle starts\n");
                return;
            }
        }
        System.out.println();
    }

    public void findCycle() {
        Node slow = head, fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;// Here the slow is not neccesary for the looping becasue the slow will always
                             // be behind the fast node
            fast = fast.next.next;
            if (slow == fast) {
                System.out.println("cycle present");
                return;
            }
        }
        System.out.println("cycle NOT present");
    }

    // Using the slow-fast approach we will find the midNode
    public Node midNode() {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public void checkPalindrome() {
        Node mid = midNode();
        Node prev = null;
        Node cur = mid;
        Node next;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        Node last = prev;
        Node temp = head;
        while (last != null && temp != null) {
            if (last.data != temp.data) {
                System.out.println("not palindrome");
                return;
            }
            last = last.next;
            temp = temp.next;
        }
        System.out.println("isPalindrome");
    }

    public void removeCycle() {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        slow = head;
        Node prev = fast;
        while (fast != slow) {
            prev = fast;
            fast = fast.next;
            slow = slow.next;
        }
        prev.next = null;

        // copilote suggestion for how to handle the possible null value of the fast
        // node
        // while (fast != null && fast.next != null && fast != slow) {
        // prev = fast;
        // fast = fast.next;
        // slow = slow.next;
        // }
        // if (fast != null && prev != null) {
        // prev.next = null;
        // }
    }

    public static void main(String[] args) {
        LinkedListAp ll = new LinkedListAp();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.connectLastNthtoFirst(2);
        ll.printCycle();
        ll.findCycle();
        // ll.checkPalindrome();
        ll.removeCycle();
        ll.printCycle();
        ll.findCycle();

    }
}
