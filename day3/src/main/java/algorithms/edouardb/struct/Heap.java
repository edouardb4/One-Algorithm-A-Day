package algorithms.edouardb.struct;

public class Heap {

    private int[] heap;
    private int heapLength;
    public Heap() {
        this.heap = new int[3];
    }

    public Heap(int[] heap) {
        this.heap = heap;
    }

    public int parent(int i) {
        return i / 2;
    }

    public int left(int i) {
        return i * 2;
    }

    public int right(int i) {
        return left(i) + 1;
    }

    public void buildMaxHeap() {
        heapLength = heap.length;
        for(int i = heap.length / 2; i >= 0; i--) {
            maxHeapify(i);
        }
    }

    public void maxHeapify(int i) {
        int left = left(i);
        int right = right(i);
        int largest = -1;
        if(left < heapLength && heap[left] > heap[i]) {
            largest = left;
        }
        else {
            largest = i;
        }
        if(right < heapLength && heap[right] > heap[largest]) {
            largest = right;
        }
        if(largest != i) {
            int replace = heap[i];
            heap[i] = heap[largest];
            heap[largest] = replace;
            maxHeapify(largest);
        }
    }

    public int[] heapSort() {
        int[] copy = new int[heap.length];
        for(int i = 0; i < heap.length; i++) {
            copy[i] = heap[i];
        }
        buildMaxHeap();
        for(int i = heap.length - 1; i >= 0; i--) {
            int replace = heap[0];
            heap[0] = heap[i];
            heap[i] = replace;
            heapLength--;
            maxHeapify(0);
        }
        int[] current = heap;
        heap = copy;
        return current;
    }
}
