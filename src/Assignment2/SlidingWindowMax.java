package Assignment2;

import java.util.*;

public class SlidingWindowMax {
    public static int[] maxSlidingWindow(int[] arr, int k) {
        int n = arr.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> dq = new LinkedList<>(); // stores indices

        for (int i = 0; i < n; i++) {

            // Remove elements out of window
            if (!dq.isEmpty() && dq.peekFirst() < i - k + 1)
                dq.pollFirst();

            // Maintain decreasing deque
            while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i])
                dq.pollLast();

            dq.offerLast(i);

            // Store max after first k-1
            if (i >= k - 1)
                result[i - k + 1] = arr[dq.peekFirst()];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(arr, k)));
    }
}

