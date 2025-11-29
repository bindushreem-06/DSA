package DSAonHeapAss3;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Arrays;

public class KLargestSmallest {

    public static void findKElements(int[] arr, int k) {

        // Min Heap for K Largest
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Max Heap for K Smallest
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());

        for (int num : arr) {
            // For K Largest
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }

            // For K Smallest
            maxHeap.add(num);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        System.out.println("Array : " + Arrays.toString(arr));
        System.out.println(k + " Largest Elements : " + minHeap);
        System.out.println(k + " Smallest Elements : " + maxHeap);
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 5, 12, 2, 11};
        int k = 3;

        findKElements(arr, k);
    }
}

