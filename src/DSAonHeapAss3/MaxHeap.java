package DSAonHeapAss3;

import java.util.Arrays;

class MaxHeap {
    private int[] heap;
    private int size;

    public MaxHeap(int capacity) {
        heap = new int[capacity];
        size = 0;
    }

    private int parent(int i){ return (i - 1) / 2; }

    public void insert(int value) {
        heap[size] = value;
        int i = size;
        size++;

        while (i > 0 && heap[parent(i)] < heap[i]) {
            int temp = heap[i];
            heap[i] = heap[parent(i)];
            heap[parent(i)] = temp;
            i = parent(i);
        }
    }

    public int deleteMax() {
        if (size <= 0) return -1;
        int root = heap[0];
        heap[0] = heap[size-1];
        size--;
        heapify(0);
        return root;
    }

    private void heapify(int i) {
        int largest = i;
        int left = (2*i)+1;
        int right = (2*i)+2;

        if (left < size && heap[left] > heap[largest]) largest = left;
        if (right < size && heap[right] > heap[largest]) largest = right;

        if (largest != i) {
            int temp = heap[i];
            heap[i] = heap[largest];
            heap[largest] = temp;
            heapify(largest);
        }
    }

    public void print() {
        System.out.println(Arrays.toString(heap));
    }

    public static void main(String[] args) {
        MaxHeap mh = new MaxHeap(10);
        mh.insert(15);
        mh.insert(10);
        mh.insert(30);
        mh.insert(40);

        mh.print();
        System.out.println("Deleted Max: " + mh.deleteMax());
        mh.print();
    }
}

