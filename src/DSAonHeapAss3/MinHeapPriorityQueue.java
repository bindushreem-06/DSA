package DSAonHeapAss3;

import java.util.PriorityQueue;

public class MinHeapPriorityQueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(10);
        pq.add(5);
        pq.add(20);
        pq.add(1);

        System.out.println("PriorityQueue: " + pq);
        System.out.println("Peek (Min): " + pq.peek());
        System.out.println("Removed: " + pq.poll());
        System.out.println("After Poll: " + pq);
    }
}

