package Assignment2;

import java.util.*;

class NextGreaterElement {
    public static int[] nextGreater(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 25};
        System.out.println("NGE: " + Arrays.toString(nextGreater(arr)));
    }
}
