package DSAonHeapAss3;

import java.util.Arrays;

class MinHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        heap = new int[capacity];
        size = 0;
    }

    private int parent(int i) { return (i - 1) / 2; }
    private int left(int i) { return (2 * i) + 1; }
    private int right(int i) { return (2 * i) + 2; }

    public void insert(int value) {
        if (size == capacity) {
            System.out.println("Heap is full!");
            return;
        }
        heap[size] = value;
        int current = size++;
        while (current > 0 && heap[current] < heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public int deleteMin() {
        if (size <= 0) return -1;
        int root = heap[0];
        heap[0] = heap[--size];
        heapify(0);
        return root;
    }

    private void heapify(int i) {
        int smallest = i;
        int l = left(i);
        int r = right(i);

        if (l < size && heap[l] < heap[smallest]) smallest = l;
        if (r < size && heap[r] < heap[smallest]) smallest = r;

        if (smallest != i) {
            swap(i, smallest);
            heapify(smallest);
        }
    }

    private void swap(int a, int b) {
        int t = heap[a];
        heap[a] = heap[b];
        heap[b] = t;
    }

    public void print() {
        System.out.println(Arrays.toString(heap));
    }

    public static void main(String[] args) {
        MinHeap mh = new MinHeap(10);
        mh.insert(20);
        mh.insert(5);
        mh.insert(15);
        mh.insert(2);

        mh.print();

        System.out.println("Deleted Min: " + mh.deleteMin());
        mh.print();
    }
}

