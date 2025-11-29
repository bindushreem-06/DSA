package DSAonHeapAss3;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxHeapPriorityQueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        pq.add(10);
        pq.add(5);
        pq.add(20);
        pq.add(1);

        System.out.println("Max-Heap PQ: " + pq);
        System.out.println("Peek (Max): " + pq.peek());
        System.out.println("Removed: " + pq.poll());
        System.out.println("After Poll: " + pq);
    }
}

