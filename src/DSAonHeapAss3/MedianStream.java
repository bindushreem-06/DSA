package DSAonHeapAss3;

import java.util.Collections;
import java.util.PriorityQueue;

class MedianStream {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public void addNum(int num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek())
            maxHeap.add(num);
        else
            minHeap.add(num);

        if (maxHeap.size() > minHeap.size() + 1)
            minHeap.add(maxHeap.poll());
        else if (minHeap.size() > maxHeap.size())
            maxHeap.add(minHeap.poll());
    }

    public double getMedian() {
        if (maxHeap.size() == minHeap.size())
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        MedianStream ms = new MedianStream();
        int[] data = {5, 15, 1, 3};

        for (int num : data) {
            ms.addNum(num);
            System.out.println("Added: " + num + ", Median: " + ms.getMedian());
        }
    }
}

