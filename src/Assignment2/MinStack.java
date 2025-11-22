package Assignment2;
import java.util.*;

public class MinStack {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek())
            minStack.push(x);
    }

    public int pop() {
        if (stack.isEmpty()) return -1;
        int val = stack.pop();
        if (val == minStack.peek()) minStack.pop();
        return val;
    }

    public int getMin() {
        return minStack.isEmpty() ? -1 : minStack.peek();
    }

    public static void main(String[] args) {
        MinStack ms = new MinStack();
        ms.push(5);
        ms.push(3);
        ms.push(7);
        ms.push(2);

        System.out.println(ms.getMin()); // 2
        ms.pop();
        System.out.println(ms.getMin()); // 3
    }
}

