package Queue;

public class QueueArray {
    private int[] arr;       // Array to store queue elements
    private int front;       // Points to first element in queue
    private int rear;        // Points to last element in queue
    private int size;        // Maximum capacity of queue

    public QueueArray(int size) {
        this.size = size;
        arr = new int[size];
        front = -1;
        rear = -1;
    }

    // Check if Queue is empty
    public boolean isEmpty() {
        return front == -1;
    }

    // Check if Queue is full
    public boolean isFull() {
        return rear == size - 1;
    }

    // Insert element in Queue
    public void enqueue(int x) {
        if (isFull()) {
            System.out.println("Queue Overflow! Cannot insert " + x);
            return;
        }

        if (front == -1) {
            front = 0; // First element insertion
        }

        arr[++rear] = x;
        System.out.println(x + " inserted into queue");
    }

    // Remove element from Queue
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow! Cannot remove");
            return -1;
        }

        int value = arr[front];

        if (front == rear) {
            front = rear = -1;  // Queue became empty
        } else {
            front++;            // Move front to next element
        }

        return value;
    }

    // Peek front element
    public int front() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return arr[front];
    }

    // Display queue items
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is Empty!");
            return;
        }

        System.out.print("Queue elements: ");
        for (int i = front; i <= rear; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Testing Queue
    public static void main(String[] args) {
        QueueArray queue = new QueueArray(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        queue.display();

        System.out.println("Front element = " + queue.front());

        System.out.println("Dequeued = " + queue.dequeue());

        queue.display();

        System.out.println("Is queue empty? " + queue.isEmpty());
        System.out.println("Is queue full? " + queue.isFull());
    }
}

