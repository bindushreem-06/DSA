package LinkedListProblem;

public class MergeSortedLists {

    static class Node {
        int val;
        Node next;
        Node(int v) { this.val = v; }
    }

    // Iterative Merge: O(n + m), stable, no extra space
    public static Node merge(Node a, Node b) {
        if (a == null) return b;
        if (b == null) return a;

        Node dummy = new Node(-1);
        Node tail = dummy;

        while (a != null && b != null) {
            if (a.val <= b.val) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }

        // Attach remaining elements (only one of them non-null)
        tail.next = (a != null) ? a : b;
        return dummy.next;
    }

    // Recursive Merge: cleaner but uses call stack (O(n+m))
    public static Node mergeRec(Node a, Node b) {
        if (a == null) return b;
        if (b == null) return a;

        if (a.val <= b.val) {
            a.next = mergeRec(a.next, b);
            return a;
        } else {
            b.next = mergeRec(a, b.next);
            return b;
        }
    }

    // Utility: Build LinkedList from array
    public static Node build(int[] arr) {
        Node head = null, tail = null;
        for (int v : arr) {
            Node n = new Node(v);
            if (head == null) head = tail = n;
            else tail = tail.next = n;
        }
        return head;
    }

    // Utility: Display LinkedList
    public static void print(Node head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Node a = build(new int[]{1,3,5,7});
        Node b = build(new int[]{2,4,6,8,9});

        System.out.print("A: "); print(a);
        System.out.print("B: "); print(b);

        Node merged = merge(a, b);
        System.out.print("Merged Iterative: "); print(merged);

        // For recursive test, recreate lists (previous ones are modified)
        a = build(new int[]{1,3,5,7});
        b = build(new int[]{2,4,6,8,9});
        Node mergedRec = mergeRec(a, b);
        System.out.print("Merged Recursive: "); print(mergedRec);
    }
}
