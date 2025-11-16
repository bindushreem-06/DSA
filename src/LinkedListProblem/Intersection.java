package LinkedListProblem;

public class Intersection {
    static class Node { int val; Node next; Node(int v){val=v;} }

    // Returns intersection node or null
    public static Node getIntersection(Node headA, Node headB) {
        if (headA == null || headB == null) return null;

        Node p = headA;
        Node q = headB;

        // After switching heads once, they traverse equal distances:
        // p goes lengthA then lengthB, q goes lengthB then lengthA.
        while (p != q) {
            p = (p == null) ? headB : p.next;
            q = (q == null) ? headA : q.next;
        }
        // Either both null (no intersection) or both at intersection
        return p;
    }

    // Helper: prints list
    public static void print(Node h) { Node c=h; while(c!=null){System.out.print(c.val+" -> "); c=c.next;} System.out.println("null"); }

    public static void main(String[] args) {
        // Build two lists that will intersect
        Node common = new Node(30);
        common.next = new Node(40);
        common.next.next = new Node(50);

        // List A: 10 -> 20 -> 30 -> 40 -> 50
        Node a = new Node(10);
        a.next = new Node(20);
        a.next.next = common; // intersection

        // List B: 15 -> 30 -> 40 -> 50
        Node b = new Node(15);
        b.next = common; // intersection

        System.out.print("List A: "); print(a);
        System.out.print("List B: "); print(b);

        Node inter = getIntersection(a, b);
        System.out.println("Intersection at node with value: " + (inter != null ? inter.val : "null"));
    }
}

