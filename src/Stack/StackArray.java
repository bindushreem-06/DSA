package Stack;

public class StackArray {
    private int[] arr;         // Array to store stack elements
    private int topOfStack;    // Index of the top item in stack
    private int size;          // Maximum capacity of stack

    // Constructor
    public StackArray(int size) {
        this.size = size;
        arr = new int[size];
        topOfStack = -1;       // Stack initially empty
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return topOfStack == -1;
    }

    // Check if stack is full
    public boolean isFull() {
        return topOfStack == size - 1;
    }

    // Push an element into stack
    public void push(int x) {
        if (isFull()) {
            System.out.println("Stack Overflow! Cannot push " + x);
            return;
        }
        arr[++topOfStack] = x;
        System.out.println(x + " pushed into stack");
    }

    // Pop/remove an element from stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow! Cannot pop");
            return -1;
        }

        int value = arr[topOfStack]; // get top element
        arr[topOfStack] = 0;         // clear the removed slot
        topOfStack--;                // decrease stack pointer
        return value;                // return removed value
    }

    // Peek the top element without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack Empty!");
            return -1;
        }
        return arr[topOfStack];
    }

    // Display all elements in stack
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is Empty!");
            return;
        }
        System.out.print("Stack elements: ");
        for (int i = 0; i <= topOfStack; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Main method (testing stack)
    public static void main(String[] args) {
        StackArray stack = new StackArray(5);

        stack.push(10);
        stack.push(20);
        stack.push(30);

        stack.display();

        System.out.println("Top element = " + stack.peek()); // 30

        System.out.println("Popped = " + stack.pop());  // 30

        stack.display();
        System.out.println("Is stack empty? " + stack.isEmpty());
        System.out.println("Is stack full? " + stack.isFull());
    }
}

