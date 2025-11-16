package LinkedListProblem;

public class MiddleElement {
    static class Node { int val; Node next; Node(int v) {val=v;} }

    // Returns the middle node. For even length: returns first middle.
    public static Node findMiddleFirst(Node head) {
        if (head == null) return null;
        Node slow = head, fast = head;
        // Stop when fast.next == null or fast.next.next == null?
        // For first-middle on even length, use: while (fast.next != null && fast.next.next != null)
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Returns second middle for even length lists
    public static Node findMiddleSecond(Node head) {
        if (head == null) return null;
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Helpers
    public static Node build(int[] a) {
        Node h = null, t = null;
        for (int v : a) {
            Node n = new Node(v);
            if (h==null) h=t=n; else { t.next=n; t=n; }
        }
        return h;
    }
    public static void print(Node h) { Node c=h; while(c!=null){System.out.print(c.val+" -> "); c=c.next;} System.out.println("null"); }

    public static void main(String[] args) {
        Node even = build(new int[]{1,2,3,4});
        Node odd  = build(new int[]{10,20,30,40,50});

        System.out.print("Even list: "); print(even);
        System.out.println("First middle (even): " + findMiddleFirst(even).val);
        System.out.println("Second middle (even): " + findMiddleSecond(even).val);

        System.out.print("Odd list: "); print(odd);
        System.out.println("Middle (odd): " + findMiddleFirst(odd).val);
    }
}

