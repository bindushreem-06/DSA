package LinkedListProblem;

public class PalindromeList {
    static class Node { int val; Node next; Node(int v){val=v;} }

    // Reverse list and return new head
    private static Node reverse(Node head) {
        Node prev = null, curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // Main palindrome check (restores list before returning)
    public static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) return true;

        // 1. Find middle (for odd length, slow will be first of middle pair)
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // If list length is odd, slow is at middle. We want start of second half:
        Node secondHalfStart = (fast == null) ? slow : slow.next;
        // Explanation:
        // - fast == null => even length => slow is at first-middle => second half starts at slow
        // - fast != null => odd length => slow points to middle => second half starts at slow.next

        // 2. Reverse second half
        Node secondReversed = reverse(secondHalfStart);

        // 3. Compare first half and reversed second half
        Node p1 = head;
        Node p2 = secondReversed;
        boolean palindrome = true;
        while (p2 != null) { // only need to compare length of second half
            if (p1.val != p2.val) { palindrome = false; break; }
            p1 = p1.next;
            p2 = p2.next;
        }

        // 4. Restore the second half to original (optional but good practice)
        Node restoredSecond = reverse(secondReversed);
        // Reconnect restored second half back to the list
        if (fast == null) {
            // even length: slow is first node of second half originally, so its previous should point restoredSecond
            // We need to find node before secondHalfStart to reconnect.
            Node temp = head;
            while (temp.next != secondHalfStart) temp = temp.next;
            temp.next = restoredSecond;
        } else {
            // odd length: slow is the true middle, and slow.next originally pointed to second half start
            slow.next = restoredSecond;
        }
        return palindrome;
    }

    // Helpers to build/print
    public static Node build(int[] arr) {
        Node h=null, t=null;
        for (int v: arr) {
            Node n=new Node(v);
            if (h==null) h=t=n; else {t.next=n; t=n;}
        }
        return h;
    }
    public static void print(Node h) { Node c=h; while(c!=null){System.out.print(c.val+" -> "); c=c.next;} System.out.println("null"); }

    public static void main(String[] args) {
        Node p1 = build(new int[]{1,2,3,2,1});
        Node p2 = build(new int[]{1,2,2,1});
        Node p3 = build(new int[]{1,2,3,4});

        System.out.print("p1: "); print(p1); System.out.println("palindrome? " + isPalindrome(p1));
        System.out.print("p2: "); print(p2); System.out.println("palindrome? " + isPalindrome(p2));
        System.out.print("p3: "); print(p3); System.out.println("palindrome? " + isPalindrome(p3));
    }
}
