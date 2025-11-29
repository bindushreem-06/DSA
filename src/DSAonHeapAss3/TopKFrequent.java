package DSAonHeapAss3;

import java.util.*;

public class TopKFrequent {
    public static void topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums)
            map.put(n, map.getOrDefault(n, 0) + 1);

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap =
                new PriorityQueue<>(Map.Entry.comparingByValue());

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            minHeap.add(entry);
            if (minHeap.size() > k)
                minHeap.poll();
        }

        List<Integer> result = new ArrayList<>();
        while (!minHeap.isEmpty())
            result.add(minHeap.poll().getKey());

        System.out.println("Top K Frequent: " + result);
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 3};
        topKFrequent(arr, 2);
    }
}

